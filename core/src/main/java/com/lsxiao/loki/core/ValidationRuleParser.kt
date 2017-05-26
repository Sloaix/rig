package com.lsxiao.loki.core

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 21:56
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

object ValidationRuleParser {
    fun parse(rules: String) {

    }

    fun splitRules(rules: String) {

        //required|min:2|max:5  分离规则
        val split = rules.split("|")
        split.forEach {
            //mix:2或者required
            val rawRuleSplit = it.split(":")
        }
    }

    fun parseStringRule(rules: String) {

    }
}
