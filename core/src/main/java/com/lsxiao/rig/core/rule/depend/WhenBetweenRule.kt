package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.Dependable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段处于提供的区间的时候，才校验剩余的规则
 */

class WhenBetweenRule(override val params: Array<String>, override val dependValue: String?) : Dependable {
    companion object {
        val names = setOf("when_between", "w_between")
    }

    override fun checkParams() = params.size == 3

    override fun check(data: String?): Boolean = when {
        dependValue?.toIntOrNull() == null -> false
        else -> dependValue >= params.get(1) && dependValue <= params.last()
    }
}
