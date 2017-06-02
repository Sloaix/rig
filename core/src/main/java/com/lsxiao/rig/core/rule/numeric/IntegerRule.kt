package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.BaseRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 整数校验规则
 */

class IntegerRule : BaseRule {
    companion object {
        val names = setOf("int", "integer")

    }

    override fun check(checkedFiled: String?): Boolean = checkedFiled?.toIntOrNull() != null
}
