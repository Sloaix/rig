package com.lsxiao.rig.compiler

import com.lsxiao.rig.core.rule.Checkable
import javax.lang.model.element.Element
import kotlin.properties.Delegates

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-28 01:24
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RigDescriptor private constructor(val element: Element) {
    companion object {
        fun newInstance(methodElement: Element): RigDescriptor {
            return RigDescriptor(methodElement)
        }
    }

    var rules: List<Checkable> = emptyList()
    var name: String = ""
    var group: Int = 0
    var failTemplates: Array<String> = emptyArray()
    var className: String by Delegates.notNull()
}