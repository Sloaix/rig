package com.lsxiao.rig.core.rule

import com.lsxiao.rig.core.rule.`when`.*
import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.other.AcceptedRule
import com.lsxiao.rig.core.rule.other.FilledRule
import com.lsxiao.rig.core.rule.other.NotNullRule
import com.lsxiao.rig.core.rule.size.MaxRule
import com.lsxiao.rig.core.rule.size.MinRule
import com.lsxiao.rig.core.rule.size.SameRule
import com.lsxiao.rig.core.rule.size.length.LengthRule
import com.lsxiao.rig.core.rule.size.length.MaxLengthRule
import com.lsxiao.rig.core.rule.size.length.MinLengthRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-26 16:45
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
object RuleFactory {
    fun create(name: String, parameters: Array<String> = emptyArray(), relyValue: String? = null, relyName: String? = null): BaseRule? = when (name) {
        in LengthRule.names -> LengthRule(parameters)
        in MinLengthRule.names -> MinLengthRule(parameters)
        in MaxLengthRule.names -> MaxLengthRule(parameters)
        in MinRule.names -> MinRule(parameters)
        in MaxRule.names -> MaxRule(parameters)
        in SameRule.names -> SameRule(parameters, relyValue, relyName)
        in AcceptedRule.names -> AcceptedRule()
        in NotNullRule.names -> NotNullRule()
        in FilledRule.names -> FilledRule()
        in IntegerRule.names -> IntegerRule()
        in WhenEqualRule.names -> WhenEqualRule(parameters, relyValue, relyName)
        in WhenFilledRule.names -> WhenFilledRule(parameters, relyValue, relyName)
        in WhenGreaterThanRule.names -> WhenGreaterThanRule(parameters, relyValue, relyName)
        in WhenIntegerRule.names -> WhenIntegerRule(parameters, relyValue, relyName)
        in WhenLessThanRule.names -> WhenLessThanRule(parameters, relyValue, relyName)
        in WhenNotNullRule.names -> WhenNotNullRule(parameters, relyValue, relyName)
        in WhenNumericRule.names -> WhenNumericRule(parameters, relyValue, relyName)
        in WhenSizeRule.names -> WhenSizeRule(parameters, relyValue, relyName)
        else -> null
    }
}