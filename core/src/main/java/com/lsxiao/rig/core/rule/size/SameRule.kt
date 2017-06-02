package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble
import com.lsxiao.rig.core.rule.RelyAble

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 15:05
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 *
 */

class SameRule(override val params: Array<String>, override val relyName: String?, override val relyValue: String?) : BaseRule, ParamAble, RelyAble {
    companion object {
        val names = setOf("same", "eq")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(checkedFiled: String?): Boolean {
        return checkedFiled != null && checkedFiled.toDouble() == params.first().toDouble()
    }
}