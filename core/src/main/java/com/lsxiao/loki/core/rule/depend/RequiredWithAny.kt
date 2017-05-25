package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredWithAny : Rule() {
    override val name = "requiredWithAny"

    override fun hasParameter() = true

    override fun isParameterValid(): Boolean {
        return parameters.isNotEmpty()
    }

    override fun validate(data: String): Boolean {
        return parameters.any { it.isNotEmpty() } && data.isNotEmpty()
    }
}