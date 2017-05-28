package com.lsxiao.loki.core.rule

import java.util.*

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
abstract class LokiRule(val params: Array<String> = emptyArray()) {

    abstract fun needParams(): Boolean

    abstract fun checkParams(): Boolean

    abstract fun check(data: String?): Boolean

    override fun toString(): String {
        return "LokiRule(params=${Arrays.toString(params)})"
    }
}
