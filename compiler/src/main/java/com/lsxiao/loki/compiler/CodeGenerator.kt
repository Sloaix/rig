package com.lsxiao.apllo.processor

import com.lsxiao.loki.compiler.RuleAnnotationDescriptor
import com.lsxiao.loki.core.ValidateResult
import com.lsxiao.loki.core.Validator
import com.lsxiao.loki.core.rule.LokiRule
import com.lsxiao.loki.core.rule.ParameterLokiRule
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.IOException
import javax.annotation.processing.Filer
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier

class CodeGenerator private constructor(private val ruleAnnotationDescriptors: ArrayList<RuleAnnotationDescriptor>, private val mFiler: Filer) {

    companion object {
        private val CLASS = "\$T"
        private val PACKAGE_NAME = "com.lsxiao.loki.core"
        private val CLASS_NAME = "LokiValidator"
        private val VAR_OBJECT_NAME = "object"
        private val VAR_ERRORS_NAME = "errors"
        private val VAR_TARGET_NAME = "target"
        private val VAR_RULE_MAP_NAME = "ruleMap"

        fun create(ruleAnnotationDescriptors: ArrayList<RuleAnnotationDescriptor>, filer: Filer): CodeGenerator = CodeGenerator(ruleAnnotationDescriptors, filer)
    }

    fun generate() = createJavaFile()

    private fun createJavaFile() = try {
        getBinderGeneratorJavaFile().writeTo(mFiler)
    } catch (e: IOException) {
        e.printStackTrace()
    }

    fun getBinderGeneratorJavaFile(): JavaFile = JavaFile
            .builder(PACKAGE_NAME, getGeneratorTypeSpec())
            .build()

    /**
     *   public final class LokiValidator {
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
        val builder = MethodSpec.methodBuilder("check")
                .addAnnotation(Override::class.java)
                .addModifiers(Modifier.PUBLIC)
                .returns(ValidateResult::class.java)
                .addParameter(Object::class.java, VAR_OBJECT_NAME, Modifier.FINAL)
                .addStatement("$CLASS<String,$CLASS<$CLASS>> $VAR_ERRORS_NAME = new $CLASS<String,$CLASS<$CLASS>>()", Map::class.java, List::class.java, LokiRule::class.java, HashMap::class.java, List::class.java, LokiRule::class.java)

        ruleAnnotationDescriptors.groupBy { it.className }.values.forEach {
            wrapByIf(builder, it.first(), ruleCodeForOneInstance(it))
        }

        return builder.addStatement("return new $CLASS($VAR_ERRORS_NAME)", ValidateResult::class.java).build()
    }

    fun ruleCodeForOneInstance(ruleAnnotationDescriptors: List<RuleAnnotationDescriptor>): CodeBlock {
        val builder = CodeBlock.builder()
        ruleAnnotationDescriptors.forEach {
            val key = "\"${variableOrMethod(it.element)}\""
            builder.addStatement("$VAR_RULE_MAP_NAME.put($key,new $CLASS<$CLASS>())",
                    ArrayList::class.java,
                    LokiRule::class.java)
                    .addStatement("$VAR_ERRORS_NAME.put($key,new $CLASS<$CLASS>())",
                            ArrayList::class.java,
                            LokiRule::class.java)

            it.rules.forEach {
                builder.addStatement("$VAR_RULE_MAP_NAME.get($key).add(${ruleInstance(it)})")
                        .build()
            }


            builder.beginControlFlow("for($CLASS rule:$VAR_RULE_MAP_NAME.get($key))", LokiRule::class.java)
                    .beginControlFlow("if(!rule.check($VAR_TARGET_NAME.${variableOrMethod(it.element)}))")
                    .addStatement("$VAR_ERRORS_NAME.get($key).add(rule)")
                    .endControlFlow()
                    .endControlFlow()
        }

        return builder.build()
    }

    fun ruleInstance(rule: LokiRule): CodeBlock {
        return CodeBlock
                .builder()
                .add("new $CLASS(${params(rule)})",
                        rule.javaClass)
                .build()
    }

    fun params(rule: LokiRule): CodeBlock? = CodeBlock
            .builder()
            .add(if (rule is ParameterLokiRule) {
                "new String[]{${rule.params.map { "\"$it\"" }.joinToString(",")}}"
            } else {
                ""
            })
            .build()


    fun variableOrMethod(element: Element): String {
        return if (element is ExecutableElement) {
            "${element.simpleName}()"
        } else {
            "${element.simpleName}"
        }
    }

    /**
     *  if (object.getClass().getCanonicalName().equals(...)) {
     *      MainActivity target = ((MainActivity) object);
     *      Map<String, List<LokiRule>> ruleMap = new HashMap();
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
                        LokiRule::class.java,
                        HashMap::class.java)
                .addCode(codeBlock)
                .endControlFlow()
    }

}
