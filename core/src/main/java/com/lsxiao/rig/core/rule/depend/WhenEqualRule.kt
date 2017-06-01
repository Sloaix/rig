package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.Dependable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段等于提供的值的时候,验证字段才是必须的
 */

class WhenEqualRule(override val params: Array<String>, override val dependValue: String?) : Dependable {
    companion object {
        val names = setOf("when_eq", "w_eq")
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = dependValue == params.last()
}