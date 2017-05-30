package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.ParameterRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class MinRule(override val params: Array<String>) : ParameterRigRule {
    companion object {
        val name = "min"
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length >= params.first().toInt()
    }
}