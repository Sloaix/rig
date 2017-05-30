package com.lsxiao.rig.core.rule

import com.lsxiao.rig.core.rule.depend.WhenBetweenRule
import com.lsxiao.rig.core.rule.depend.WhenEqualRule
import com.lsxiao.rig.core.rule.depend.WhenFilledRule
import com.lsxiao.rig.core.rule.depend.WhenGreaterThanRule
import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.other.AcceptedRule
import com.lsxiao.rig.core.rule.other.FilledRule
import com.lsxiao.rig.core.rule.other.NotNullRule
import com.lsxiao.rig.core.rule.size.BetweenRule
import com.lsxiao.rig.core.rule.size.MaxRule
import com.lsxiao.rig.core.rule.size.MinRule
import com.lsxiao.rig.core.rule.size.SizeRule

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-26 16:45
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
object RuleFactory {
    fun create(name: String, parameters: Array<String> = emptyArray(), dependValue: String? = null): RigRule? = when (name) {
        SizeRule.name -> SizeRule(parameters)
        MinRule.name -> MinRule(parameters)
        MaxRule.name -> MaxRule(parameters)
        BetweenRule.name -> BetweenRule(parameters)
        AcceptedRule.name -> AcceptedRule()
        NotNullRule.name -> NotNullRule()
        FilledRule.name -> FilledRule()
        IntegerRule.name -> IntegerRule()
        WhenBetweenRule.name -> WhenBetweenRule(parameters, dependValue)
        WhenEqualRule.name -> WhenEqualRule(parameters, dependValue)
        WhenFilledRule.name -> WhenFilledRule(parameters, dependValue)
        WhenGreaterThanRule.name -> WhenGreaterThanRule(parameters, dependValue)
        else -> null
    }
}