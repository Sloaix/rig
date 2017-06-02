package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.BaseRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 数字校验规则
 */

class NumericRule : BaseRule {
    companion object {
        val names = setOf("numeric")
    }

    override fun check(checkedFiled: String?): Boolean = checkedFiled?.toDoubleOrNull() != null
}
