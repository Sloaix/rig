package com.lsxiao.rig.core.rule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 带参数的校验规则
 */
interface ParamAble {

    /**
     * 校验parameters,如果符合就返回true
     */
    fun checkParams(): Boolean

    /**
     * @Rule,value字段分离出来的参数列表
     */
    val params: Array<String>
}
