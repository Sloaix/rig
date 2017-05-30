package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.RigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class FilledRule : RigRule {
    companion object {
        val name = "filled"
    }

    override fun check(data: String?): Boolean {
        return data != null && data.isNotEmpty()
    }
}
