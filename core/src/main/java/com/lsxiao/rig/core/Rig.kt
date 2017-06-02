package com.lsxiao.rig.core

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

object Rig {
    val PACKAGE_NAME = "com.lsxiao.rig.core"
    val CLASS_NAME = "RigValidator"
    val VALIDATOR_NAME = "$PACKAGE_NAME.$CLASS_NAME"
    private val validator: Validator by lazy {
        Class.forName(VALIDATOR_NAME).newInstance() as Validator
    }

    @JvmStatic
    fun check(any: Any): ValidateResult = validator.check(any)
}
