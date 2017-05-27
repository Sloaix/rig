package com.lsxiao.apllo.processor

import com.lsxiao.loki.compiler.UnitRuleDescriptor
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import java.io.IOException
import java.util.*
import javax.annotation.processing.Filer
import javax.lang.model.element.Modifier


/**
 * write with Apollo
 * author:lsxiao
 * date:2017-04-22 18:00
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class CodeGenerator private constructor(private val unitRuleDescriptors: ArrayList<UnitRuleDescriptor>, private val mFiler: Filer) {

    companion object {
        private val GENERATE_PACKAGE_NAME = "com.lsxiao.loki.core"
        private val GENERATE_CLASS_NAME = "LokiValidator"

        fun create(apolloDescriptors: ArrayList<UnitRuleDescriptor>, filer: Filer): CodeGenerator = CodeGenerator(apolloDescriptors, filer)
    }

    fun generate() = createJavaFile()

    private fun createJavaFile() = try {
        getBinderGeneratorJavaFile().writeTo(mFiler)
    } catch (e: IOException) {
        e.printStackTrace()
    }

    fun getBinderGeneratorJavaFile(): JavaFile = JavaFile
            .builder(GENERATE_PACKAGE_NAME, getGeneratorTypeSpec())
            .build()

    /**
     *   public final class LokiValidator {
     *      ...
     *  }
     */
    fun getGeneratorTypeSpec(): TypeSpec = TypeSpec
            .classBuilder(GENERATE_CLASS_NAME)
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(getBroadcastEventFunctionMethodSpec())
            .build()

    /**
     * public void validate(final Object o) {
     *      ...
     *      return;
     * }
     */
    fun getBroadcastEventFunctionMethodSpec(): MethodSpec {
        val builder = MethodSpec.methodBuilder("validate")
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Object::class.java, "o", Modifier.FINAL)

        return builder.addStatement("return").build()
    }

}
