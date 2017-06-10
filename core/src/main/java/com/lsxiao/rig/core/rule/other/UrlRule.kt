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

class UrlRule : BaseRule {
    companion object {
        val names = setOf("url")
    }

    override fun check(checkedFiled: String?): Boolean {
        return Pattern.compile("""https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,4}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)""").matcher(checkedFiled).matches()
    }
}
