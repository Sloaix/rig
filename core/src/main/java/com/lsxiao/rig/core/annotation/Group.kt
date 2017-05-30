package com.lsxiao.rig.core.annotation

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 18:10
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.SOURCE)
annotation class Group(val value: Int)
