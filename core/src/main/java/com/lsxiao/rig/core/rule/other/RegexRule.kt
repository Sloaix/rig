package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule
import com.lsxiao.rig.core.rule.ParamAble

/**
 * write with BaseRule
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 正则表达式校验规则
 */

class RegexRule(override val params: Array<String>) : BaseRule, ParamAble {
    companion object {
        val name = "reg"
    }

    override fun checkParams(): Boolean {
        return params.size == 1
    }

    override fun check(data: String?): Boolean {
        return data != null
    }
}
