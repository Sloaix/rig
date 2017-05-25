package com.lsxiao.loki.core.rule.implicit

import com.lsxiao.loki.core.rule.Rule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 22:48
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class Accepted : Rule() {
    override val name = "accepted"
    val acceptable = listOf("yes", "on", "1", "true")

    override fun hasParameter() = false

    override fun isParameterValid() = false

    override fun validate(data: String): Boolean {
        return acceptable.contains(data)
    }
}