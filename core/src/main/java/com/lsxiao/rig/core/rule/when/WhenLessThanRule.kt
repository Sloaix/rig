package com.lsxiao.rig.core.rule.`when`

import com.lsxiao.rig.core.rule.WhenAble

/**
 * write with CheckAble
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段值小于提供的值的时候，验证字段才是必须的
 */

class WhenLessThanRule(override val params: Array<String>, override val relyValue: String?) : WhenAble {
    companion object {
        val names = setOf("when_lt", "w_lt")
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = when {
        relyValue?.toIntOrNull() == null -> false
        else -> relyValue < params.last()
    }
}