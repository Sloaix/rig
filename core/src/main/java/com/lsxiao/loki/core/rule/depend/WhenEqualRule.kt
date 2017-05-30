package com.lsxiao.loki.core.rule.depend

import com.lsxiao.loki.core.rule.ParameterLokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class WhenEqualRule(override val params: Array<String>) : ParameterLokiRule {
    companion object {
        val name = "when_eq"
    }

    override fun checkParams() = params.size == 2

    override fun check(data: String?): Boolean = when {
        params.first() == params.last() -> data != null && data.isNotEmpty()
        else -> true
    }
}