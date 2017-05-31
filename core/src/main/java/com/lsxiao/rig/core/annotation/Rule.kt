package com.lsxiao.rig.core.annotation

/**
 * write with Checkable
 * author:lsxiao
 * date:2017-05-26 18:10
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.SOURCE)
annotation class Rule(val value: String, val name: String = "")
