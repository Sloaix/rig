package com.lsxiao.rig.core.rule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 基础规则
 */
interface BaseRule {

    /**
     * 实现校验规则，如果校验成功，返回true
     */
    fun check(checkedFiled: String?): Boolean
}
