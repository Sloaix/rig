package com.lsxiao.loki.core.rule.size

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class BetweenRule(parameters: Array<String>) : Rule(parameters) {
    companion object {
        val name = "between"
    }

    override fun hasParameters() = true

    override fun validateParameters(): Boolean {
        return parameters.size == 2 && parameters.all { it.toIntOrNull() != null }
    }

    override fun validate(data: String): Boolean {
        return data.length >= parameters.min()!!.toInt() && data.length <= parameters.max()!!.toInt()
    }
}