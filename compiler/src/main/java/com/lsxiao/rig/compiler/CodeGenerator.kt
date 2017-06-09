package com.lsxiao.rig.compiler

import com.lsxiao.rig.core.*
import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble
import com.lsxiao.rig.core.rule.RelyAble
import com.lsxiao.rig.core.rule.WhenAble
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.MethodSpec.methodBuilder
import com.squareup.javapoet.TypeSpec
import javax.annotation.processing.Filer
import javax.lang.model.element.Element
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.Modifier

class CodeGenerator private constructor(private val rigDescriptors: ArrayList<RigDescriptor>, private val mFiler: Filer) {

    companion object {
        private val CLASS = "\$T"
        private val PACKAGE_NAME = Rig.PACKAGE_NAME
        private val CLASS_NAME = Rig.CLASS_NAME
        private val VAR_OBJECT_NAME = "object"
        private val VAR_GROUP_NAME = "group"
        private val VAR_ERRORS_NAME = "errors"
        private val VAR_TARGET_NAME = "target"
        private val VAR_RULE_MAP_NAME = "ruleMap"

        fun create(rigDescriptors: ArrayList<RigDescriptor>, filer: Filer): CodeGenerator = CodeGenerator(rigDescriptors, filer)
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
                .addStatement("$CLASS<String,$CLASS<$CLASS>> $VAR_ERRORS_NAME = new $CLASS<String,$CLASS<$CLASS>>()", Map::class.java, List::class.java, String::class.java, HashMap::class.java, List::class.java, String::class.java)

        rigDescriptors.groupBy { it.className }.values.forEach {
            wrapByIf(builder, it.first(), ruleCodeForOneAnnotation(it))
        }

        return builder.addStatement("return new $CLASS($VAR_ERRORS_NAME)", ValidateResult::class.java).build()
    }

    /**
     *
     */
    fun ruleCodeForOneAnnotation(rigDescriptors: List<RigDescriptor>): CodeBlock {
        val builder = CodeBlock.builder()
        rigDescriptors.groupBy {
            it.group
        }.values.forEach { groupDescriptors ->
            builder.beginControlFlow("if($VAR_GROUP_NAME==${groupDescriptors.first().group})")

            groupDescriptors.forEach { descriptor ->
                val key = toRaw(ruleNameOrFieldName(descriptor))
                builder.addStatement("$VAR_RULE_MAP_NAME.put($key,new $CLASS<$CLASS>())",
                        ArrayList::class.java,
                        BaseRule::class.java)

                descriptor.parseResults
                        //按照depend优先降序排列,depend优先级最高,以便遍历的时候先校验dependRule,如果dependRule没有校验通过则不再需要校验之后的规则
                        .sortedBy {
                            it.clazz !is WhenAble
                        }
                        .forEach {
                            builder.add(addRuleToMap(key, newRule(it, descriptor)))
                        }

                builder.beginControlFlow("for($CLASS rule:$VAR_RULE_MAP_NAME.get($key))", BaseRule::class.java)
                        .beginControlFlow("if(!rule.check($VAR_TARGET_NAME.${textTobeValidate(descriptor.element)}))")
                        .beginControlFlow("if(rule instanceof $CLASS)", WhenAble::class.java)
                        .addStatement("break")
                        .endControlFlow()
                        .beginControlFlow("if($VAR_ERRORS_NAME.get($key) == null)")
                        .addStatement("$VAR_ERRORS_NAME.put($key,new $CLASS<$CLASS>())",
                                ArrayList::class.java,
                                String::class.java)
                        .endControlFlow()
                        .addStatement("$CLASS[] args = new $CLASS[]{}", String::class.java, String::class.java)
                        .addStatement("$CLASS relyName=\"\"", String::class.java)
                        .addStatement("$CLASS relyValue=\"\"", String::class.java)
                        .beginControlFlow("if(rule instanceof $CLASS)", ParamAble::class.java)
                        .addStatement("args = (($CLASS)rule).getParams()", ParamAble::class.java)
                        .endControlFlow()
                        .beginControlFlow("if(rule instanceof $CLASS)", RelyAble::class.java)
                        .addStatement("relyName = (($CLASS)rule).getRelyName()", RelyAble::class.java)
                        .addStatement("relyValue = (($CLASS)rule).getRelyValue()", RelyAble::class.java)
                        .endControlFlow()
                        .addStatement(renderTemplate(
                                getFailTemplate(),
                                ruleNameOrFieldName(descriptor)
                        ))
                        .addStatement("$VAR_ERRORS_NAME.get($key).add(rendered)")
                        .endControlFlow()
                        .endControlFlow()
            }
            builder.endControlFlow()
        }

        return builder.build()
    }

    fun addRuleToMap(key: String, ruleInstance: CodeBlock): CodeBlock {
        return CodeBlock.builder()
                .addStatement("$VAR_RULE_MAP_NAME.get($key).add($ruleInstance)")
                .build()
    }

    /**
     * new IntegerRule()
     */
    fun newRule(result: RuleParser.Result, descriptor: RigDescriptor): CodeBlock {
        return CodeBlock.of("new $CLASS(${ruleParams(result, rigDescriptors, descriptor)})", result.clazz)
    }

    /**
     * String rendered = FailTemplate.INSTANCE.render(...)
     */
    fun renderTemplate(template: String, fieldName: String): String =
            CodeBlock.of("""$CLASS rendered = $CLASS.INSTANCE.render("$fieldName",args,relyName,relyValue,$template)""", String::class.java, FailTemplate::class.java)
                    .toBuilder()
                    .build()
                    .toString()

    /**
     *  FailTemplate.INSTANCE.get(...)
     */
    fun getFailTemplate(): String {
        return CodeBlock
                .builder()
                .add("$CLASS.INSTANCE.get(rule.getClass())", FailTemplate::class.java)
                .build()
                .toString()
    }

    /**
     * 实例化Rule的参数
     *
     * IntegerRule result = new Rule(...)
     *
     */
    fun ruleParams(result: RuleParser.Result, collections: List<RigDescriptor>, descriptor: RigDescriptor): CodeBlock = CodeBlock
            .builder()
            .add(
                    when {
                        RelyAble::class.java.isAssignableFrom(result.clazz) -> relyRuleParams(result, collections, descriptor)
                        ParamAble::class.java.isAssignableFrom(result.clazz) -> paramRulePrams(result)
                        else -> ""
                    }
            )
            .build()

    /**
     *
     */
    fun paramRulePrams(result: RuleParser.Result) = "new String[]{${result.params.map { """"$it"""" }.joinToString(",")}}"

    /**
     * 返回一个依赖规则的参数
     *
     * new String[]{target.age},"",target.age)
     */
    fun relyRuleParams(result: RuleParser.Result, collections: List<RigDescriptor>, descriptor: RigDescriptor): String {
        val relyName = result.params.first()
        val ruleName = toRaw(descriptor.name)
        val relyValue = "$VAR_TARGET_NAME.${relyValue(relyName, collections)}"
        val params = result.params.map { """"$it"""" }.joinToString(",")
        val isRelyEnable = isRelyNameExist(relyName, collections)

        return if (isRelyEnable) {
            "new String[]{$relyValue},$ruleName,$relyValue"
        } else {
            throw IllegalArgumentException("找不到依赖字段(cant' find rely field name)")
        }
    }

    /**
     * "..."
     */
    fun toRaw(string: String): String {
        return """"$string""""
    }

    /**
     * 根据依赖的name获取依赖校验的值
     *
     */
    fun relyValue(name: String, collections: List<RigDescriptor>): String? = when {
        isRelyNameExist(name, collections) -> collections.find { it.name == name }?.element?.let { textTobeValidate(it) }.toString()
        else -> null
    }

    /**
     * 判断依赖的name是否存在
     */
    fun isRelyNameExist(name: String, collections: List<RigDescriptor>): Boolean = collections.any {
        it.name == name
    }

    /**
     * age
     * getAge()
     */
    fun ruleNameOrFieldName(descriptor: RigDescriptor): String = if (descriptor.name.isNotEmpty()) {
        descriptor.name
    } else if (descriptor.element is ExecutableElement) {
        "${descriptor.element.simpleName}()"
    } else {
        "${descriptor.element.simpleName}"
    }

    /**
     * age
     * getAge()
     */
    fun textTobeValidate(element: Element): String {
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
     *      Map<String, List<BaseRule>> ruleMap = new HashMap();
     *  ....
     *  }
     */
    fun wrapByIf(builder: MethodSpec.Builder, descriptor: RigDescriptor, codeBlock: CodeBlock) {
        builder.beginControlFlow("""if($VAR_OBJECT_NAME.getClass().getCanonicalName().equals("${descriptor.className}"))""")
                .addStatement("${descriptor.className} $VAR_TARGET_NAME = (${descriptor.className})$VAR_OBJECT_NAME")
                .addStatement("$CLASS<$CLASS,$CLASS<$CLASS>> ruleMap = new $CLASS()",
                        Map::class.java,
                        String::class.java,
                        List::class.java,
                        BaseRule::class.java,
                        HashMap::class.java)
                .addCode(codeBlock)
                .endControlFlow()
    }

}
