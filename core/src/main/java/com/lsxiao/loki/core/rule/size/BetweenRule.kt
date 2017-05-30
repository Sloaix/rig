package com.lsxiao.loki.core.rule.size

import com.lsxiao.loki.core.rule.ParameterLokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class BetweenRule(override val params: Array<String>) : ParameterLokiRule {
    companion object {
        val name = "between"
    }

    override fun checkParams(): Boolean {
        return params.size == 2 && params.all { it.toIntOrNull() != null }
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length >= params.min()!!.toInt() && data.length <= params.max()!!.toInt()
    }
}
