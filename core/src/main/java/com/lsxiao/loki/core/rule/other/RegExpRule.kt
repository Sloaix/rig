package com.lsxiao.loki.core.rule.other

import com.lsxiao.loki.core.rule.ParameterLokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RegExpRule(override val params: Array<String>) : ParameterLokiRule {
    companion object {
        val name = "reg"
    }

    override fun checkParams(): Boolean {
        return params.size == 1
    }

    override fun check(data: String?): Boolean {
        return data != null
    }
}
