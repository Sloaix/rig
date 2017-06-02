package com.lsxiao.rig.core.rule.size.length

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 字符串长度校验规则
 */

class LengthRule(override val params: Array<String>) : BaseRule, ParamAble {
    companion object {
        val names = setOf("length", "len")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length == params.first().toInt()
    }
}
