package com.lsxiao.rig.core.rule.`when`

import com.lsxiao.rig.core.rule.WhenAble

/**
 * write with CheckAble
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 当对应的字段值为数字的时候，验证字段才是必须的
 */

class WhenNumericRule(override val params: Array<String>, override val relyValue: String?) : WhenAble {
    companion object {
        val names = setOf("when_numeric", "w_numeric")
    }


    override fun checkParams() = params.size == 1

    override fun check(data: String?): Boolean = relyValue?.toDoubleOrNull() != null
}