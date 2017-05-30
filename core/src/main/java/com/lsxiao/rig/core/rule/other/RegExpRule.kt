package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.ParameterRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RegExpRule(override val params: Array<String>) : ParameterRigRule {
    companion object {
        val name = "reg"
    }

    override fun checkParams(): Boolean {
        return params.size == 1
    }

    override fun check(data: String?): Boolean {
        return data != null
    }
}
