package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 不为NUll校验规则
 */

class NotNullRule : BaseRule {
    companion object {
        val names = setOf("notnull")
    }

    override fun check(data: String?): Boolean {
        return data != null
    }
}
