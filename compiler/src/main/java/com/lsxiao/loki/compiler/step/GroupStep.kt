package com.lsxiao.loki.compiler.step

import com.google.auto.common.BasicAnnotationProcessor
import com.google.auto.common.MoreElements
import com.google.common.collect.SetMultimap
import com.lsxiao.loki.compiler.LokiProcessor
import com.lsxiao.loki.core.annotation.Group
import java.util.*
import javax.lang.model.element.Element

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-28 01:38
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */
class GroupStep : BasicAnnotationProcessor.ProcessingStep {
    override fun annotations(): Set<Class<out Annotation>> = setOf(Group::class.java)

    override fun process(elementsByAnnotation: SetMultimap<Class<out Annotation>, Element>): Set<Element> {
        elementsByAnnotation.asMap().keys.forEach { clazz ->
            elementsByAnnotation.asMap()[clazz]?.mapNotNull { LokiProcessor.sDescriptorMap[it] }?.forEach {
                it.groupId = MoreElements.asExecutable(it.element).getAnnotation(Group::class.java).value
            }
        }
        return HashSet()
    }
}