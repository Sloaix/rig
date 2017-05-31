package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.Checkable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * d
 */

class AcceptedRule : Checkable {
    companion object {
        val name = "accepted"
    }

    val acceptable = listOf("yes", "on", "1", "true")

    override fun check(data: String?): Boolean {
        return acceptable.contains(data)
    }
}