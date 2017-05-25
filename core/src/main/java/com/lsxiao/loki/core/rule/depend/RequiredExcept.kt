package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RequiredExcept : Rule() {
    override val name = "requiredExcept"

    override fun hasParameter() = true

    override fun isParameterValid(): Boolean {
        return parameters.size == 2
    }

    override fun validate(data: String): Boolean {
        return parameters.first() != parameters.last() && data.isNotEmpty()
    }
}
