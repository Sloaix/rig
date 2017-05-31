package com.lsxiao.rig.compiler

import com.lsxiao.rig.core.Rig
import com.lsxiao.rig.core.ValidateResult
import com.lsxiao.rig.core.Validator
import com.lsxiao.rig.core.rule.Dependable
import com.lsxiao.rig.core.rule.Paramable
import com.lsxiao.rig.core.rule.Checkable
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.MethodSpec.methodBuilder
import com.squareup.javapoet.TypeSpec
import javax.annotation.processing.Filer
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier

class CodeGenerator private constructor(private val ruleAnnotationDescriptors: ArrayList<RuleAnnotationDescriptor>, private val mFiler: Filer) {

    companion object {
        private val CLASS = "\$T"
        private val PACKAGE_NAME = Rig.PACKAGE_NAME
        private val CLASS_NAME = Rig.CLASS_NAME
        private val VAR_OBJECT_NAME = "object"
        private val VAR_GROUP_NAME = "group"
        private val VAR_ERRORS_NAME = "errors"
        private val VAR_TARGET_NAME = "target"
        private val VAR_RULE_MAP_NAME = "ruleMap"

        fun create(ruleAnnotationDescriptors: ArrayList<RuleAnnotationDescriptor>, filer: Filer): CodeGenerator = CodeGenerator(ruleAnnotationDescriptors, filer)
    }

    fun generate() = createJavaFile()

    private fun createJavaFile() = try {
        getBinderGeneratorJavaFile().writeTo(mFiler)
    } catch (e: java.io.IOException) {
        e.printStackTrace()
    }

    fun getBinderGeneratorJavaFile(): JavaFile = JavaFile
            .builder(PACKAGE_NAME, getGeneratorTypeSpec())
            .build()

    /**
     *   public final class RigValidator {
     *      ...
     *  }
     */
    fun getGeneratorTypeSpec(): TypeSpec = TypeSpec
            .classBuilder(CLASS_NAME)
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addSuperinterface(Validator::class.java)
            .addMethod(getValidateFunctionMethodSpec())
            .build()

    /**
     * public void check(final Object o) {
     *      if(o.)
     *      ...
     *      return;
     * }
     */
    fun getValidateFunctionMethodSpec(): MethodSpec {
        val builder = methodBuilder("check")
                .addAnnotation(Override::class.java)
                .addModifiers(Modifier.PUBLIC)
                .returns(ValidateResult::class.java)
                .addParameter(Object::class.java, VAR_OBJECT_NAME, Modifier.FINAL)
                .addParameter(Int::class.java, VAR_GROUP_NAME, Modifier.FINAL)
                .addStatement("$CLASS<String,$CLASS<$CLASS>> $VAR_ERRORS_NAME = new $CLASS<String,$CLASS<$CLASS>>()", Map::class.java, List::class.java, Checkable::class.java, HashMap::class.java, List::class.java, Checkable::class.java)

        ruleAnnotationDescriptors.groupBy { it.className }.values.forEach {
            wrapByIf(builder, it.first(), ruleCodeForOneAnnotation(it))
        }

        return builder.addStatement("return new $CLASS($VAR_ERRORS_NAME)", ValidateResult::class.java).build()
    }

    /**
     *
     */
    fun ruleCodeForOneAnnotation(ruleAnnotationDescriptors: List<RuleAnnotationDescriptor>): CodeBlock {
        val builder = CodeBlock.builder()
        ruleAnnotationDescriptors.groupBy {
            it.group
        }.values.forEach { groupDescriptors ->
            builder.beginControlFlow("if($VAR_GROUP_NAME==${groupDescriptors.first().group})")

            groupDescriptors.forEach { descriptor ->
                val key = "\"${variableOrMethod(descriptor.element)}\""
                builder.addStatement("$VAR_RULE_MAP_NAME.put($key,new $CLASS<$CLASS>())",
                        ArrayList::class.java,
                        Checkable::class.java)

                descriptor.mRules
                        //按照depend优先降序排列,depend优先级最高,以便遍历的时候先校验dependRule,如果dependRule没有校验通过则不再需要校验之后的规则
                        .sortedBy {
                            it !is Dependable
                        }
                        .forEach {
                            builder.addStatement("$VAR_RULE_MAP_NAME.get($key).add(new $CLASS(${params(it, ruleAnnotationDescriptors)}))",
                                    it.javaClass)
                        }

                builder.beginControlFlow("for($CLASS rule:$VAR_RULE_MAP_NAME.get($key))", Checkable::class.java)
                        .beginControlFlow("if(!rule.check($VAR_TARGET_NAME.${variableOrMethod(descriptor.element)}))")
                        .beginControlFlow("if(rule instanceof $CLASS)", Dependable::class.java)
                        .addStatement("break")
                        .endControlFlow()
                        .beginControlFlow("if($VAR_ERRORS_NAME.get($key) == null)")
                        .addStatement("$VAR_ERRORS_NAME.put($key,new $CLASS<$CLASS>())",
                                ArrayList::class.java,
                                Checkable::class.java)
                        .endControlFlow()
                        .addStatement("$VAR_ERRORS_NAME.get($key).add(rule)")
                        .endControlFlow()
                        .endControlFlow()
            }
            builder.endControlFlow()
        }

        return builder.build()
    }

    /**
     * 生成校验Rule的参数
     */
    fun params(rule: Checkable, collections: List<RuleAnnotationDescriptor>): CodeBlock = CodeBlock
            .builder()
            .add(if (rule is Dependable) {
                "new String[]{${rule.params.map { "\"$it\"" }.joinToString(",")}},$VAR_TARGET_NAME.${dependValue(rule.params.first(), collections)}"
            } else if (rule is Paramable) {
                "new String[]{${rule.params.map { "\"$it\"" }.joinToString(",")}}"
            } else {
                ""
            })
            .build()

    /**
     * 依赖校验的值
     */
    fun dependValue(name: String, collections: List<RuleAnnotationDescriptor>): String {
        return collections.find {
            it.dependedName == name
        }?.element?.let { variableOrMethod(it) }.toString()
    }

    /**
     * 获取返回String值的方法或者属性
     */
    fun variableOrMethod(element: Element): String {
        return if (element is ExecutableElement) {
            "${element.simpleName}()"
        } else if (setOf("android.widget.TextView", "android.widget.EditText").contains(element.asType().toString())) {
            "${element.simpleName}.getText().toString()"
        } else {
            "${element.simpleName}"
        }
    }

    /**
     *  if (object.getClass().getCanonicalName().equals(...)) {
     *      MainActivity target = ((MainActivity) object);
     *      Map<String, List<Checkable>> ruleMap = new HashMap();
     *  ....
     *  }
     */
    fun wrapByIf(builder: MethodSpec.Builder, annotationDescriptor: RuleAnnotationDescriptor, codeBlock: CodeBlock) {
        builder.beginControlFlow("if($VAR_OBJECT_NAME.getClass().getCanonicalName().equals(\"${annotationDescriptor.className}\"))")
                .addStatement("${annotationDescriptor.className} $VAR_TARGET_NAME = (${annotationDescriptor.className})$VAR_OBJECT_NAME")
                .addStatement("$CLASS<$CLASS,$CLASS<$CLASS>> ruleMap = new $CLASS()",
                        Map::class.java,
                        String::class.java,
                        List::class.java,
                        Checkable::class.java,
                        HashMap::class.java)
                .addCode(codeBlock)
                .endControlFlow()
    }

}
