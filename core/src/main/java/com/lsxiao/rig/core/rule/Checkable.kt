package com.lsxiao.rig.core.rule

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 校验规则
 */
interface Checkable {
    fun check(data: String?): Boolean
}
