package com.lsxiao.rig.core.rule

/**
 * write with CheckAble
 * author:lsxiao
 * date:2017-05-25 23:34
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 * 在一个@Rule注解中，如果出现了依赖校验规则，依赖校验规则的优先级最高，只有当依赖的值满足给定的条件的时候，才校验剩余的规则，否则不做校验
 */
interface WhenAble : ParamAble
