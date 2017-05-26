package com.lsxiao.loki.core;

import com.lsxiao.loki.core.rule.LokiRule;

import java.util.HashMap;
import java.util.Map;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 20:59
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class ValidateResult {
    private Map<LokiRule, String> errors = new HashMap<>();

    public ValidateResult(Map<LokiRule, String> errors) {
        this.errors = errors;
    }

    private boolean isFail() {
        return !isPass();
    }

    private boolean isPass() {
        return errors.isEmpty();
    }
}
