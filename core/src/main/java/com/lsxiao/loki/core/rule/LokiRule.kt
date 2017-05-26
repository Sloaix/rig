package com.lsxiao.loki.core.rule

import java.util.*

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
abstract class LokiRule(val parameters: Array<String> = emptyArray()) {

    abstract fun hasParameters(): Boolean

    abstract fun validateParameters(): Boolean

    abstract fun validate(data: String?): Boolean

    override fun toString(): String {
        return "LokiRule(parameters=${Arrays.toString(parameters)})"
    }
}
