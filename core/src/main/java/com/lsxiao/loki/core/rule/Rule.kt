package com.lsxiao.loki.core.rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
abstract class Rule(val parameters: List<String> = emptyList()) {
    abstract val name: String

    abstract fun hasParameter(): Boolean

    abstract fun isParameterValid(): Boolean

    abstract fun validate(data: String): Boolean
}
