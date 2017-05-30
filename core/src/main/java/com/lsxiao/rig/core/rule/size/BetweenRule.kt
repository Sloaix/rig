package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.ParameterRigRule
import com.lsxiao.rig.core.rule.numeric.NumericRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class BetweenRule(override val params: Array<String>) : ParameterRigRule {
    companion object {
        val name = "between"
    }

    override fun checkParams(): Boolean {
        return params.size == 2 && params.all { it.toIntOrNull() != null }
    }

    override fun check(data: String?): Boolean {
        return NumericRule().check(data) && data!!.toInt() >= params.min()!!.toInt() && data.toInt() <= params.max()!!.toInt()
    }
}
