package com.lsxiao.loki.core.rule.numeric

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class Numeric : Rule() {
    override val name = "numeric"

    override fun hasParameter() = false

    override fun isParameterValid(): Boolean = false

    override fun validate(data: String) = data.toDoubleOrNull() != null
}
