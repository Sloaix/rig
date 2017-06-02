package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.RuleFactory

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
    private fun parseSingleRule(stringRule: String): BaseRule {
        val temp = stringRule.split(":")
        //分离出规则名称和参数列表 between:1,2
        val name = temp.first()
        val parameters = if (temp.size >= 2) temp.last() else ""
        return RuleFactory.create(name, parseParameters(parameters)) ?: throw IllegalArgumentException("无法解析 $name 对应的Rule,请确保 $name 是Rig已有的rule")
    }

    /**
     * 解析规则参数,返回一个参数数组
     */
    private fun parseParameters(parameters: String): Array<String> {
        return parameters.split(",").toTypedArray()
    }
}
