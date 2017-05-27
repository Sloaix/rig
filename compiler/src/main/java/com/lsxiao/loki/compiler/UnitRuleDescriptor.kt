package com.lsxiao.loki.compiler

import com.lsxiao.loki.core.rule.LokiRule
import javax.lang.model.element.Element

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-28 01:24
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class UnitRuleDescriptor private constructor(val methodElement: Element) {
    companion object {
        fun newInstance(methodElement: Element): UnitRuleDescriptor {
            return UnitRuleDescriptor(methodElement)
        }
    }

    var rules: List<LokiRule> = emptyList()
    var dependedName: String? = null
    var groupId: Int = 0
}