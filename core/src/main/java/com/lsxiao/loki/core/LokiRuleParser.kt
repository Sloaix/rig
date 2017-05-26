package com.lsxiao.loki.core

import com.lsxiao.loki.core.rule.LokiRule
import com.lsxiao.loki.core.rule.RuleFactory

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 21:56
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

object LokiRuleParser {

    /**
     * 解析单行规则，返回一个lokiRule列表
     */
    fun parse(rules: String) = rules.split("|").map(this::parseStringRule)

    /**
     * 解析一个规则between:1,2  包括规则名和参数,返回一个LokiRule对象
     */
    private fun parseStringRule(stringRule: String): LokiRule {
        val temp = stringRule.split(":")
        //分离出规则名称和参数列表 between:1,2
        val name = temp.first()
        val parameters = if (temp.size >= 2) temp.last() else ""

        return RuleFactory.create(name, parseParameters(parameters))
    }

    /**
     * 解析规则参数,返回一个参数数组
     */
    private fun parseParameters(parameters: String): Array<String> {
        return parameters.split(",").toTypedArray()
    }
}
