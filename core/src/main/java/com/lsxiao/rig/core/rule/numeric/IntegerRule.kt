package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.RigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class IntegerRule : RigRule {
    companion object {
        val name = "int"

    }
    override fun check(data: String?): Boolean = data?.toIntOrNull() != null
}
