package com.lsxiao.loki.core.rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
abstract class Rule(val parameters: Array<String> = emptyArray()) {

    abstract fun hasParameters(): Boolean

    abstract fun validateParameters(): Boolean

    abstract fun validate(data: String): Boolean

}
