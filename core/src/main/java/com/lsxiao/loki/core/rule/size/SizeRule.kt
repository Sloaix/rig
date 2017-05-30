package com.lsxiao.loki.core.rule.size

import com.lsxiao.loki.core.rule.ParameterLokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class SizeRule(override val params: Array<String>) : ParameterLokiRule {
    companion object {
        val name = "size"
    }

    override fun checkParams(): Boolean {
        return params.size == 1 && params.first().toIntOrNull() != null
    }

    override fun check(data: String?): Boolean {
        return data != null && data.length == params.first().toInt()
    }
}
