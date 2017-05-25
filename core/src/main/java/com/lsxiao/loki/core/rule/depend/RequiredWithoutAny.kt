package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithoutAny : Rule() {
    override val name = "requiredWithoutAny"

    override fun hasParameters() = true

    override fun validateParameters(): Boolean {
        return parameters.isNotEmpty()
    }

    override fun validate(data: String): Boolean {
        return parameters.any { it.isEmpty() } && data.isNotEmpty()
    }
}