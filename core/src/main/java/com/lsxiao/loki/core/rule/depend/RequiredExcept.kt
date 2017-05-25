package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredExcept(parameters: Array<String>) : Rule(parameters) {
    override val name = "requiredExcept"

    override fun hasParameters() = true

    override fun validateParameters() = parameters.size == 2

    override fun validate(data: String) = when {
        parameters.first() != parameters.last() -> data.isNotEmpty()
        else -> true
    }
}
