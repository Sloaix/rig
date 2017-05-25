package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithAll(parameters: Array<String>) : Rule(parameters) {
    override val name = "requiredWithAll"

    override fun hasParameters() = true

    override fun validateParameters() = parameters.isNotEmpty()

    override fun validate(data: String) = when {
        parameters.all { it.isNotEmpty() } -> data.isNotEmpty()
        else -> true
    }
}