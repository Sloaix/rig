package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble
import java.util.regex.Pattern

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 23:19
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class MobileRule(override val params: Array<String>) : BaseRule, ParamAble {
    companion object {
        val names = setOf("mobile")
        val i18n = linkedMapOf(
                "zh-CN" to """^1(3[0-9]|4[57]|5[0-35-9]|7[0135678]|8[0-9])\d{8}$"""
        )
    }

    override fun checkParams() = params.isEmpty() || params.size == 1

    override fun check(checkedFiled: String?): Boolean {
        return Pattern.compile(i18n[params.firstOrNull()] ?: i18n.values.first()).matcher(checkedFiled).matches()
    }
}
