package com.lsxiao.loki.compiler;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableSet;
import com.lsxiao.apllo.processor.CodeGenerator;
import com.lsxiao.loki.compiler.step.GroupStep;
import com.lsxiao.loki.compiler.step.RuleStep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;


@AutoService(Processor.class)
public class LokiProcessor extends BasicAnnotationProcessor {
    public static Map<Element, RuleAnnotationDescriptor> sDescriptorMap = new HashMap<>();
    private boolean mGenerated = false;

    @Override
    protected Iterable<? extends ProcessingStep> initSteps() {
        return ImmutableSet.of(
                new RuleStep(),
                new GroupStep()
        );
    }

    @Override
    protected void postRound(RoundEnvironment roundEnv) {
        super.postRound(roundEnv);
        if (mGenerated) {
            return;
        }
        CodeGenerator.Companion.create(new ArrayList<>(sDescriptorMap.values()), processingEnv.getFiler()).generate();
        mGenerated = true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
