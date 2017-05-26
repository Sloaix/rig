package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWhen(parameters: Array<String>) : LokiRule(parameters) {
    companion object {
        val name = "requiredWhen"
    }

    override fun hasParameters() = true

    override fun validateParameters() = parameters.size == 2

    override fun validate(data: String?): Boolean = when {
        parameters.first() == parameters.last() -> data != null && data.isNotEmpty()
        else -> true
    }
}