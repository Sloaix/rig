package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.LokiRule

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class NotNullRule : LokiRule {
    companion object {
        val name = "notnull"
    }

    override fun check(data: String?): Boolean {
        return data != null
    }
}
