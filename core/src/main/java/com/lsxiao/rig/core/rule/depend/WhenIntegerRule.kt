package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.Dependable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段为整数的时候，才校验剩余的规则
 */

class WhenIntegerRule(override val params: Array<String>, override val dependValue: String?) : Dependable {
    companion object {
        val names = setOf("when_int", "when_integer", "w_integer", "w_int")
    }

    override fun checkParams() = params.size == 1

    override fun check(data: String?): Boolean = dependValue?.toIntOrNull() != null
}