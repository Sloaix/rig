package com.lsxiao.loki.core.rule.numeric

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class IntegerRule : LokiRule {
    companion object {
        val name = "int"

    }
    override fun check(data: String?): Boolean = data?.toIntOrNull() != null
}
