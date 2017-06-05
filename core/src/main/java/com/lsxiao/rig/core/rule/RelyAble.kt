package com.lsxiao.rig.core.rule

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 14:56
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 *
 * 依赖某一个字段
 */
interface RelyAble : ParamAble {
    /**
     * 依赖的@Rule的name属性
     */
    val relyName: String?

    /**
     * 依赖的@Rule标记字段的值
     */
    val relyValue: String?
}
