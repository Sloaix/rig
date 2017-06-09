package com.lsxiao.rig.core.rule.other

import com.lsxiao.rig.core.rule.BaseRule
import java.util.regex.Pattern

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 23:19
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class HanRule : BaseRule {
    companion object {
        val names = setOf("han")
    }

    override fun check(checkedFiled: String?): Boolean {
        return Pattern.matches("""^[\u4e00-\u9fa5]*$""", checkedFiled)
    }
}
