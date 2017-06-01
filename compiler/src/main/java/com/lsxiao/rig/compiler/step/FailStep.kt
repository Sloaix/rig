package com.lsxiao.rig.compiler.step

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import com.lsxiao.rig.compiler.RigProcessor
import com.lsxiao.rig.core.annotation.Fail
import com.lsxiao.rig.core.annotation.Group
import javax.lang.model.element.Element

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-01 17:12
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
class FailStep : BasicAnnotationProcessor.ProcessingStep {
    override fun annotations(): Set<Class<out Annotation>> = setOf(Group::class.java)

    override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>): Set<Element> {
        elementsByAnnotation.asMap().keys.forEach { clazz ->
            elementsByAnnotation.asMap()[clazz]?.mapNotNull { RigProcessor.sDescriptorMap[it] }?.forEach {
                it.failTemplates.plus(it.element.getAnnotation(Fail::class.java).value)
            }
        }
        return java.util.HashSet()
    }
}
