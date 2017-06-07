package com.lsxiao.rig.core.rule.`when`

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble
import com.lsxiao.rig.core.rule.RelyAble

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段不为null且notEmpty的时候,验证字段才是必须的
 */

class WhenFilledRule(override val params: Array<String>, override val relyName: String?, override val relyValue: String?, override val isRely: Boolean = true) : BaseRule, ParamAble, RelyAble {
    companion object {
        val names = setOf("when_filled", "w_filled", "w_nonempty")
    }

    override fun checkParams() = params.size == 1

    override fun check(checkedFiled: String?): Boolean = relyValue != null && relyValue.isNotEmpty()
}