package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.LokiRule

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-26 20:59
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class ValidateResult(val errors: Map<String, List<LokiRule>> = emptyMap()) {
    val isFail: Boolean
        get() = !isPass

    val isPass: Boolean
        get() = errors.values.all { it.isEmpty() }

    override fun toString(): String {
        return "ValidateResult(errors=$errors)"
    }

}
