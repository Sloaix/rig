package com.lsxiao.rig.core.rule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
interface ParameterLokiRule : LokiRule {

    fun checkParams(): Boolean

    val params: Array<String>
}
