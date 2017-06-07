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

    /**
     * 此时不一定是依赖校验模式,例如same:12或者same:password,所以需要传入
     */
    val isRely: Boolean
}
