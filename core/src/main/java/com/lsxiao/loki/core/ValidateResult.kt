package com.lsxiao.loki.core

import com.lsxiao.loki.core.rule.LokiRule

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 20:59
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class ValidateResult(val errors: Map<String, List<LokiRule>> = emptyMap()) {
    val isFail: Boolean
        get() = !isPass

    val isPass: Boolean
        get() = errors.isEmpty()
}
