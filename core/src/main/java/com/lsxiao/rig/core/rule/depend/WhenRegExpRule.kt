package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.DependRigRule
import com.lsxiao.rig.core.rule.ParameterRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class WhenRegExpRule(override val params: Array<String>, override val dependValue: String?) : DependRigRule {
    companion object {
        val name = "when_reg"
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = when {
        params.first() == params.last() -> data != null && data.isNotEmpty()
        else -> true
    }
}