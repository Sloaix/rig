package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 最大值校验规则
 */

class MaxRule(override val params: Array<String>) : BaseRule, ParamAble {
    companion object {
        val names = setOf("max")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toDoubleOrNull() != null
    }

    override fun check(checkedFiled: String?): Boolean {
        return checkedFiled != null && checkedFiled.toDouble() <= params.first().toDouble()
    }

}
