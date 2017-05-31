package com.lsxiao.rig.core

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

interface Validator {
    fun check(o: Any, group: Int = 0): ValidateResult
}
