package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.CheckAble

/**
 * write with CheckAble
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * d
 */

class AcceptedRule : CheckAble {
    companion object {
        val names = setOf("accept")
    }

    val acceptable = listOf("yes", "on", "1", "true")

    override fun check(data: String?): Boolean {
        return acceptable.contains(data)
    }
}