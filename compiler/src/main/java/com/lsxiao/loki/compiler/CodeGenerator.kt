package com.lsxiao.apllo.processor

import com.lsxiao.loki.compiler.UnitRuleDescriptor
import com.lsxiao.loki.core.Validator
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
        private val GENERATE_METHOD_BIND_OBJECT_NAME = "object"

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
                .addParameter(Object::class.java, GENERATE_METHOD_BIND_OBJECT_NAME, Modifier.FINAL)

        unitRuleDescriptors.groupBy { it.className }.values.forEach {
            getSingleBinderStatement(builder, it)
        }

        return builder.addStatement("return").build()
    }

    /**
     *  if (object.getClass().getCanonicalName().equals(...)) {
     *      apolloBinder.add(Apollo.get().toFlowable(new String[]{...}).subscribeOn(Apollo.get().getSchedulerProvider().get(...)).observeOn(...).subscribeWith(...))
     *  }
     */
    fun getSingleBinderStatement(builder: MethodSpec.Builder, descriptors: List<UnitRuleDescriptor>) {
        builder.beginControlFlow("if($GENERATE_METHOD_BIND_OBJECT_NAME.getClass().getCanonicalName().equals(\"${descriptors.first().className}\"))")
                .endControlFlow()
    }

}
