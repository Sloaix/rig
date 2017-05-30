package com.lsxiao.rig.core;

import com.lsxiao.rig.core.ValidateResult;

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-25 21:55
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public interface Validator {
    ValidateResult check(Object o);
}
