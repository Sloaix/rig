package com.lsxiao.rig.core.rule.depend

import com.lsxiao.rig.core.rule.Dependable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段不为null且notEmpty的时候,才校验剩余的规则
 */

class WhenFilledRule(override val params: Array<String>, override val dependValue: String?) : Dependable {
    companion object {
        val name = "when_filled"
    }

    override fun checkParams() = params.size == 1

    override fun check(data: String?): Boolean = dependValue != null && dependValue.isNotEmpty()
}