package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.Paramable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 字符串长度校验规则
 */

class LengthRule(override val params: Array<String>) : Paramable {
    companion object {
        val names = setOf("size", "length")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length == params.first().toInt()
    }
}
