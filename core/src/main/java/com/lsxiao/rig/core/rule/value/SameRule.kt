package com.lsxiao.rig.core.rule.value

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.RelyAble

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-02 15:05
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 *
 */

class SameRule(override val params: Array<String>, override val relyName: String?, override val relyValue: String?) : BaseRule, RelyAble {
    companion object {
        val names = setOf("same", "eq")
    }

    override fun checkParams(): Boolean {
        return params.size == 1
    }

    override fun check(checkedFiled: String?): Boolean = checkedFiled == params.first()
}