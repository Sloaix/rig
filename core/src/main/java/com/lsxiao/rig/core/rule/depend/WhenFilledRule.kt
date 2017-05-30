package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.DependRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class WhenFilledRule(override val params: Array<String>, override val dependValue: String?) : DependRigRule {
    companion object {
        val name = "when_filled"
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = dependValue != null && dependValue.isNotEmpty()
}