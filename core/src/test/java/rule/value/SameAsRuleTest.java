package rule.value;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.ParamAble;
import com.lsxiao.rig.core.rule.value.SameAsRule;
import com.lsxiao.rig.core.rule.value.SameRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 13:57
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class SameAsRuleTest extends TestCase {

    public void testName() throws Exception {
        assertTrue(SameAsRule.Companion.getNames().contains("same_as"));
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(SameRule.class));
        assertTrue(ParamAble.class.isAssignableFrom(SameRule.class));
    }

    public void testParams() throws Exception {
        assertTrue(new SameAsRule(new String[]{"密码"}, "密码", "123456").checkParams());
        assertFalse(new SameAsRule(new String[]{"密码", "test"}, "密码", "123456").checkParams());
        assertFalse(new SameAsRule(new String[]{"密码", "test"}, "密码", "123456").checkParams());
    }

    public void testRule() throws Exception {
        assertTrue(new SameAsRule(new String[]{"密码"}, "密码", "123456").check("123456"));
        assertFalse(new SameAsRule(new String[]{"密码"}, "密码", "123456").check("test"));
    }
}
