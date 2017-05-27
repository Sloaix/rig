package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithoutAllRule(parameters: Array<String>) : LokiRule(parameters) {
    companion object {
        val name = "required_without_all"
    }

    override fun hasParameters() = true

    override fun validateParameters() = parameters.isNotEmpty()

    override fun validate(data: String?): Boolean = when {
        parameters.all { it.isEmpty() } -> data != null && data.isNotEmpty()
        else -> true
    }
}