package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.Checkable

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 整数校验规则
 */

class IntegerRule : Checkable {
    companion object {
        val names = setOf("int", "integer")

    }

    override fun check(data: String?): Boolean = data?.toIntOrNull() != null
}
