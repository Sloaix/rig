package com.lsxiao.rig.compiler

import com.lsxiao.rig.core.rule.RigRule
import javax.lang.model.element.Element
import kotlin.properties.Delegates

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-28 01:24
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RuleAnnotationDescriptor private constructor(val element: Element) {
    companion object {
        fun newInstance(methodElement: Element): RuleAnnotationDescriptor {
            return RuleAnnotationDescriptor(methodElement)
        }
    }

    var rules: List<RigRule> = emptyList()
    var dependedName: String? = null
    var groupId: Int = 0
    var className: String by Delegates.notNull()
}