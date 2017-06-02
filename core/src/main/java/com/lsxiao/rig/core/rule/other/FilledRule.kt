package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * NotEmpty校验规则
 */

class FilledRule : BaseRule {
    companion object {
        val names = setOf("filled", "nonempty")
    }

    override fun check(data: String?): Boolean {
        return data != null && data.isNotEmpty()
    }
}
