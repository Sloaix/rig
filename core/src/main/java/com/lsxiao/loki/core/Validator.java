package com.lsxiao.loki.core;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class Validator {

    /**
     * 依赖于其他字段作为参数的验证规则
     */
    protected String[] dependentRules = new String[]{
            "RequiredWithAny",
            "RequiredWithAll",
            "RequiredWithoutAny",
            "RequiredWithoutAll",
            "RequiredWhen",
            "RequiredExcept",
            "Confirmed",
            "Same",
            "Different",
            "Unique",
            "Before",
            "After",
            "BeforeOrEqual",
            "AfterOrEqual",
    };

    /**
     * 可能适用于文件的验证规则
     */
    protected String[] fileRules = new String[]{
            "File",
            "Image",
            "Mimes",
            "Mimetypes",
            "MinRule",
            "MaxRule",
            "SizeRule",
            "BetweenRule",
            "Dimensions",
    };

    /**
     * 必须字段验相关的验证规则
     */
    protected String[] implicitRules = new String[]{
            "Required",
            "Filled",
            "RequiredWithAny",
            "RequiredWithAll",
            "RequiredWithoutAny",
            "RequiredWithoutAll",
            "RequiredWhen",
            "RequiredExcept",
            "Accepted",
            "Present"
    };

    /**
     * 大小相关的验证规则
     */
    protected String[] $sizeRules = new String[]{"SizeRule", "BetweenRule", "MinRule", "MaxRule"};

    /**
     * 数字相关的验证规则
     */
    protected String[] numericRules = new String[]{
            "Numeric",
            "Integer"
    };
}
