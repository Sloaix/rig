package com.lsxiao.loki.core.rule.size

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class SizeRule(parameters: Array<String>) : LokiRule(parameters) {
    companion object {
        val name = "size"
    }

    override fun hasParameters() = true

    override fun validateParameters(): Boolean {
        return parameters.size == 1 && parameters.first().toIntOrNull() != null
    }

    override fun validate(data: String): Boolean {
        return data.length == parameters.first().toInt()
    }
}
