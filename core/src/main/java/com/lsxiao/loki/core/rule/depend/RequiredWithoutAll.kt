package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithoutAll : Rule() {
    override val name = "requiredWithoutAll"

    override fun hasParameters() = true

    override fun validateParameters(): Boolean {
        return parameters.isNotEmpty()
    }

    override fun validate(data: String): Boolean {
        return parameters.all { it.isEmpty() } && data.isNotEmpty()
    }
}