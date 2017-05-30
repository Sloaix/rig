package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.RigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class NumericRule : RigRule {
    companion object {
        val name = "numeric"
    }

    override fun check(data: String?): Boolean = data?.toDoubleOrNull() != null
}
