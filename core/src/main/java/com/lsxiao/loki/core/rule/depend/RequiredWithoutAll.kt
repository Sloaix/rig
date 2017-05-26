package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithoutAll(parameters: Array<String>) : Rule(parameters) {
    companion object {
        val name = "requiredWithoutAll"
    }

    override fun hasParameters() = true

    override fun validateParameters() = parameters.isNotEmpty()

    override fun validate(data: String) = when {
        parameters.all { it.isEmpty() } -> data.isNotEmpty()
        else -> true
    }
}