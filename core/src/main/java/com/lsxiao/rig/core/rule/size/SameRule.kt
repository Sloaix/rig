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
        return isDirect() || isRely()
    }

    fun isDirect(): Boolean = params.size == 1

    fun isRely(): Boolean = params.size == 2 && !relyName.isNullOrBlank()

    override fun check(checkedFiled: String?): Boolean = when {
        isDirect() -> checkedFiled == params.first()
        isRely() -> checkedFiled == relyValue
        else -> false
    }
}