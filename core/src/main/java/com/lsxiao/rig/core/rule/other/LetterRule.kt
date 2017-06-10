package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 23:57
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
class LetterRule : BaseRule {
    companion object {
        val names = setOf("letter")
    }

    override fun check(checkedFiled: String?): Boolean {
        return checkedFiled != null && checkedFiled.isNotEmpty() && checkedFiled.all { "$it" in "abcdefghijklmnopqrstuvwxyz" }
    }
}