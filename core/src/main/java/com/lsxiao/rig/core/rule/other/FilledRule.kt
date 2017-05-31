package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.Checkable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * NotEmpty校验规则
 */

class FilledRule : Checkable {
    companion object {
        val names = setOf("filled", "nonempty")
    }

    override fun check(data: String?): Boolean {
        return data != null && data.isNotEmpty()
    }
}
