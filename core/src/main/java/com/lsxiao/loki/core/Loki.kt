package com.lsxiao.loki.core

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

class Loki {
    companion object {
        private val validator: Validator by lazy {
            Class.forName("com.lsxiao.loki.core.LokiValidator").newInstance() as Validator
        }

        @JvmStatic
        fun check(any: Any): ValidateResult {
            validator.check(any)
            return Any() as ValidateResult
        }
    }
}
