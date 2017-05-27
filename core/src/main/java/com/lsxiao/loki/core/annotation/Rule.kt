package com.lsxiao.loki.core.annotation

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 18:10
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class Rule(val value: String, val name: String = "")
