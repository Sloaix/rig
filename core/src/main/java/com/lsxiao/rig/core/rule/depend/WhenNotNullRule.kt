package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.DependRigRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class WhenNotNullRule(override val params: Array<String>, override val dependValue: String?) : DependRigRule {
    companion object {
        val name = "when_not_null"
    }

    override fun checkParams() = params.size == 1

    override fun check(data: String?): Boolean = dependValue != null
}