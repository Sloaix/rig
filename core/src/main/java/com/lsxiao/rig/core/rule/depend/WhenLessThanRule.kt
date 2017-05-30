package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.ParameterRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class WhenLessThanRule(override val params: Array<String>) : ParameterRigRule {
    companion object {
        val name = "when_lt"
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = when {
        params.first() == params.last() -> data != null && data.isNotEmpty()
        else -> true
    }
}