package com.lsxiao.rig.compiler.step

import com.google.auto.common.BasicAnnotationProcessor
import com.google.auto.common.MoreElements
import com.google.common.collect.SetMultimap
import com.lsxiao.rig.compiler.RigProcessor.sDescriptorMap
import com.lsxiao.rig.compiler.RuleAnnotationDescriptor
import com.lsxiao.rig.core.RuleParser
import com.lsxiao.rig.core.annotation.Rule
import javax.lang.model.element.Element

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-28 01:38
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class RuleStep : BasicAnnotationProcessor.ProcessingStep {
    override fun annotations(): Set<Class<out Annotation>> = setOf(Rule::class.java)

    override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>): Set<Element> {
        elementsByAnnotation.asMap().keys.forEach {
            elementsByAnnotation.asMap()[it]?.forEach { element ->
                val descriptor = RuleAnnotationDescriptor.Companion.newInstance(element)
                descriptor.dependedName = element.getAnnotation(Rule::class.java).name
                descriptor.rules = RuleParser.parse(element.getAnnotation(Rule::class.java).value)
                descriptor.className = MoreElements.asType(element.enclosingElement).qualifiedName.toString()
                sDescriptorMap.put(element, descriptor)
            }
        }
        return java.util.HashSet()
    }
}