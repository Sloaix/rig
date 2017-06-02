package com.lsxiao.rig.core.rule.size

import com.lsxiao.rig.core.rule.ParamAble

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 15:05
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 *
 */

class SameRule(override val params: Array<String>) : ParamAble {
    companion object {
        val names = setOf("min")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length >= params.first().toInt()
    }
}