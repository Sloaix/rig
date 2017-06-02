package com.lsxiao.rig.core.rule.size.length

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 14:58
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
class MinLengthRule(override val params: Array<String>) : com.lsxiao.rig.core.rule.ParamAble {
    companion object {
        val names = setOf("min_length", "min_len")
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length >= params.first().toInt()
    }
}