package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.numeric.IntegerRule
import com.lsxiao.rig.core.rule.numeric.NumericRule
import com.lsxiao.rig.core.rule.other.FilledRule
import com.lsxiao.rig.core.rule.other.NotNullRule
import com.lsxiao.rig.core.rule.size.LengthRule
import com.lsxiao.rig.core.rule.size.MaxRule
import com.lsxiao.rig.core.rule.size.MinRule

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-01 17:26
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

object MessageTemplate {
    val NAME = ":name"
    val VALUE = ":value"
    val ARG = ":arg"
    val ARG1 = "${ARG}1"
    val ARG2 = "${ARG}2"

    fun get(name: String, locale: String = "zh-CN"): String? {
        return i18n.get(locale)?.get(name)
    }

    val zhCN = hashMapOf(
            NotNullRule.names.first() to "$NAME 不能为null",
            FilledRule.names.first() to "$NAME 不能为空字符串",
            IntegerRule.names.first() to "$NAME 必须是整数",
            NumericRule.names.first() to "$NAME 必须是数字",
            LengthRule.names.first() to "$NAME 长度必须大于 $ARG1 小于 $ARG2",
            MinRule.names.first() to "$NAME 不能小于 $ARG",
            MaxRule.names.first() to "$NAME 不能大于 $ARG"
    )

    val zhTW = hashMapOf(
            NotNullRule.names.first() to "$NAME 不能為null",
            FilledRule.names.first() to "$NAME 不能為空字符串",
            IntegerRule.names.first() to "$NAME 必須是整數",
            NumericRule.names.first() to "$NAME 必須是數字",
            LengthRule.names.first() to "$NAME 長度必須大於 $ARG1 小於 $ARG2",
            MinRule.names.first() to "$NAME 不能小於 $ARG",
            MaxRule.names.first() to "$NAME 不能大於 $ARG"
    )


    val en = hashMapOf(
            NotNullRule.names.first() to "$NAME can't be null",
            FilledRule.names.first() to "$NAME can't be empty",
            IntegerRule.names.first() to "$NAME must be integer",
            NumericRule.names.first() to "$NAME must be numeric",
            LengthRule.names.first() to "$NAME must greater than $ARG1 and less than $ARG2",
            MinRule.names.first() to "$NAME can't less than $ARG",
            MaxRule.names.first() to "$NAME can't greater than $ARG"
    )


    val i18n = hashMapOf(
            "zh-CN" to zhCN,
            "zh-TW" to zhTW,
            "en" to en
    )
}
