package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.Dependable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段值小于提供的值的时候，才校验剩余的规则
 */

class WhenLessThanRule(override val params: Array<String>, override val dependValue: String?) : Dependable {
    companion object {
        val names = setOf("when_lt", "w_lt")
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = when {
        dependValue?.toIntOrNull() == null -> false
        else -> dependValue < params.last()
    }
}