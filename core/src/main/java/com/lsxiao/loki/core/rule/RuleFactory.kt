package com.lsxiao.loki.core.rule

import com.lsxiao.loki.core.rule.implicit.AcceptedRule
import com.lsxiao.loki.core.rule.implicit.FilledRule
import com.lsxiao.loki.core.rule.implicit.NotNullRule
import com.lsxiao.loki.core.rule.size.BetweenRule
import com.lsxiao.loki.core.rule.size.MaxRule
import com.lsxiao.loki.core.rule.size.MinRule
import com.lsxiao.loki.core.rule.size.SizeRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 16:45
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
object RuleFactory {
    fun create(name: String, parameters: Array<String> = emptyArray()): LokiRule = when (name) {
        SizeRule.name -> SizeRule(parameters)
        MinRule.name -> MinRule(parameters)
        MaxRule.name -> MaxRule(parameters)
        BetweenRule.name -> BetweenRule(parameters)
        AcceptedRule.name -> AcceptedRule()
        NotNullRule.name -> NotNullRule()
        FilledRule.name -> FilledRule()
        else -> null!!
    }
}