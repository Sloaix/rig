package com.lsxiao.loki.compiler.step

import com.google.auto.common.BasicAnnotationProcessor
import com.google.common.collect.SetMultimap
import com.lsxiao.loki.compiler.LokiProcessor
import com.lsxiao.loki.compiler.UnitRuleDescriptor
import com.lsxiao.loki.core.LokiRuleParser
import com.lsxiao.loki.core.annotation.Rule
import java.util.*
import javax.lang.model.element.Element

/**
 * write with Loki
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
                val descriptor = UnitRuleDescriptor.newInstance(element)
                descriptor.dependedName = element.getAnnotation(Rule::class.java).name
                descriptor.rules = LokiRuleParser.parse(element.getAnnotation(Rule::class.java).value)
                LokiProcessor.sDescriptorMap.put(element, descriptor)
            }
        }
        return HashSet()
    }
}