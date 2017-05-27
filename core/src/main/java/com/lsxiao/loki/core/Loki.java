package com.lsxiao.loki.core;

import java.lang.reflect.Method;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class Loki {
    public static ValidateResult validate(Object object) {
        try {
            Class<?> lokiValidatorClass = Class.forName("com.lsxiao.loki.core.LokiValidator");
            Object validator = lokiValidatorClass.newInstance();
            Method validateMethod = lokiValidatorClass.getMethod("validate", Object.class);
            validateMethod.invoke(validator, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ValidateResult) new Object();
    }
}
