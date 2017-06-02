package com.lsxiao.rig.core

import com.lsxiao.rig.core.rule.CheckAble
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
 *
 * 失败消息模板
 */

object FailTemplate {
    val NAME = ":name"
    val VALUE = ":value"
    val ARG = ":arg"
    val ARG1 = "${ARG}1"
    val ARG2 = "${ARG}2"
    var LOCALE = "zh-CN"

    fun render(name: String, args: Array<String>, template: String?): String? {
        return template?.replace(NAME, name)?.replace(VALUE, name)?.replace(ARG, ARG1)?.replace(ARG1, "%1\$s")?.replace(ARG2, "%2\$s")?.format(*args)
    }

    fun get(clazz: Class<out CheckAble>): String? {
        return i18n.get(LOCALE)?.get(clazz)
    }

    val zhCN = hashMapOf(
            NotNullRule::class.java to "不能为null",
            FilledRule::class.java to "不能为空字符串",
            IntegerRule::class.java to "必须是整数",
            NumericRule::class.java to "必须是数字",
            LengthRule::class.java to "长度必须等于$ARG",
            MinRule::class.java to "不能小于 $ARG",
            MaxRule::class.java to "不能大于 $ARG"
    )

    val zhTW = hashMapOf(
            NotNullRule::class.java to "不能為null",
            FilledRule::class.java to "不能為空字符串",
            IntegerRule::class.java to "必須是整數",
            NumericRule::class.java to "必須是數字",
            LengthRule::class.java to "長度必須等於$ARG",
            MinRule::class.java to "不能小於$ARG",
            MaxRule::class.java to "不能大於$ARG"
    )


    val en = hashMapOf(
            NotNullRule::class.java to "can't be null",
            FilledRule::class.java to "can't be empty",
            IntegerRule::class.java to "must be integer",
            NumericRule::class.java to "must be numeric",
            LengthRule::class.java to "length must equal$ARG",
            MinRule::class.java to "can't less than$ARG",
            MaxRule::class.java to "can't greater than$ARG"
    )


    val i18n = hashMapOf(
            "zh-CN" to zhCN,
            "zh-TW" to zhTW,
            "en" to en
    )
}
