package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithAnyRule(parameters: Array<String>) : LokiRule(parameters) {
    companion object {
        val name = "required_with_any"
    }

    override fun hasParameters() = true


    override fun validateParameters() = parameters.isNotEmpty()

    override fun validate(data: String?): Boolean = when {
        parameters.any { it.isNotEmpty() } -> data != null && data.isNotEmpty()
        else -> true
    }
}