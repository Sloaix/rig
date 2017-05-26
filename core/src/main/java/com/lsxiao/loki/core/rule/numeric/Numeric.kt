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
    companion object {
        val name = "numeric"
    }

    override fun hasParameters() = false

    override fun validateParameters(): Boolean = false

    override fun validate(data: String) = data.toDoubleOrNull() != null
}
