package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.`when`.*
import com.lsxiao.rig.core.rule.length.LengthRule
import com.lsxiao.rig.core.rule.length.MaxLengthRule
import com.lsxiao.rig.core.rule.length.MinLengthRule
import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.numeric.MaxRule
import com.lsxiao.rig.core.rule.numeric.MinRule
import com.lsxiao.rig.core.rule.numeric.NumericRule
import com.lsxiao.rig.core.rule.other.*
import com.lsxiao.rig.core.rule.value.SameAsRule
import com.lsxiao.rig.core.rule.value.SameRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 21:56
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

object RuleParser {

    /**
     * 解析单行规则，返回一个RigRule列表
     */
    fun parse(rules: String) = rules.split("|").map(this::parseSingleRule)

    /**
     * 解析一个单元规则between:1,2  包括规则名和参数,返回一个RigRule对象
     */
    private fun parseSingleRule(stringRule: String): Result {
        val temp = stringRule.split(":")
        //分离出规则名称和参数列表 between:1,2
        val name = temp.first()
        val parameters = if (temp.size >= 2) temp.last() else ""
        return Result(parseClass(name), parseParameters(parameters))
    }

    /**
     * 解析出rule string 对应的Rule Class
     */
    private fun parseClass(name: String): Class<out BaseRule> = when (name) {
        in LengthRule.names -> LengthRule::class.java
        in MinLengthRule.names -> MinLengthRule::class.java
        in MaxLengthRule.names -> MaxLengthRule::class.java

        in MinRule.names -> MinRule::class.java
        in MaxRule.names -> MaxRule::class.java
        in IntegerRule.names -> IntegerRule::class.java
        in NumericRule.names -> NumericRule::class.java

        in NotNullRule.names -> NotNullRule::class.java
        in FilledRule.names -> FilledRule::class.java

        in SameRule.names -> SameRule::class.java
        in SameAsRule.names -> SameAsRule::class.java

        in MobileRule.names -> MobileRule::class.java
        in EmailRule.names -> EmailRule::class.java
        in LetterRule.names -> LetterRule::class.java
        in HanRule.names -> HanRule::class.java
        in UrlRule.names -> UrlRule::class.java

        in WhenEqualRule.names -> WhenEqualRule::class.java
        in WhenFilledRule.names -> WhenFilledRule::class.java
        in WhenGreaterThanRule.names -> WhenGreaterThanRule::class.java
        in WhenIntegerRule.names -> WhenIntegerRule::class.java
        in WhenLessThanRule.names -> WhenLessThanRule::class.java
        in WhenNotNullRule.names -> WhenNotNullRule::class.java
        in WhenNumericRule.names -> WhenNumericRule::class.java
        in WhenLengthRule.names -> WhenLengthRule::class.java
        else -> null!!
    }

    /**
     * 解析规则参数,返回一个参数数组
     */
    private fun parseParameters(parameters: String): List<String> {
        return parameters.split(",")
    }


    data class Result(val clazz: Class<out BaseRule>, val params: List<String>)
}
