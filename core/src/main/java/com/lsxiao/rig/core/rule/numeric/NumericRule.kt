package com.lsxiao.rig.core.rule.numeric

import com.lsxiao.rig.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class NumericRule : LokiRule {
    companion object {
        val name = "numeric"
    }

    override fun check(data: String?): Boolean = data?.toDoubleOrNull() != null
}
