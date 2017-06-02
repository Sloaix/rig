package com.lsxiao.rig.core.rule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 带单数的校验规则
 */
interface ParamAble {

    fun checkParams(): Boolean

    val params: Array<String>
}
