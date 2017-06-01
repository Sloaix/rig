package com.lsxiao.rig.core.rule

import com.lsxiao.rig.core.rule.depend.*
import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.other.AcceptedRule
import com.lsxiao.rig.core.rule.other.FilledRule
import com.lsxiao.rig.core.rule.other.NotNullRule
import com.lsxiao.rig.core.rule.size.BetweenRule
import com.lsxiao.rig.core.rule.size.MaxRule
import com.lsxiao.rig.core.rule.size.MinRule
import com.lsxiao.rig.core.rule.size.LengthRule

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-26 16:45
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
object RuleFactory {
    fun create(name: String, parameters: Array<String> = emptyArray(), dependValue: String? = null): Checkable? = when (name) {
        in LengthRule.names -> LengthRule(parameters)
        in MinRule.names -> MinRule(parameters)
        in MaxRule.names -> MaxRule(parameters)
        in BetweenRule.names -> BetweenRule(parameters)
        in AcceptedRule.names -> AcceptedRule()
        in NotNullRule.names -> NotNullRule()
        in FilledRule.names -> FilledRule()
        in IntegerRule.names -> IntegerRule()
        in WhenBetweenRule.names -> WhenBetweenRule(parameters, dependValue)
        in WhenEqualRule.names -> WhenEqualRule(parameters, dependValue)
        in WhenFilledRule.names -> WhenFilledRule(parameters, dependValue)
        in WhenGreaterThanRule.names -> WhenGreaterThanRule(parameters, dependValue)
        in WhenIntegerRule.names -> WhenIntegerRule(parameters, dependValue)
        in WhenLessThanRule.names -> WhenLessThanRule(parameters, dependValue)
        in WhenNotNullRule.names -> WhenNotNullRule(parameters, dependValue)
        in WhenNumericRule.names -> WhenNumericRule(parameters, dependValue)
        in WhenSizeRule.names -> WhenSizeRule(parameters, dependValue)
        else -> null
    }
}