package com.lsxiao.loki.core.rule.implicit

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class Required : Rule() {
    companion object {
        val name = "required"
    }

    override fun hasParameters() = false

    override fun validateParameters() = false

    override fun validate(data: String): Boolean {
        return data.isNotEmpty()
    }
}
