package rule.value;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.ParamAble;
import com.lsxiao.rig.core.rule.value.DiffWithRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 13:57
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class DiffWithRuleTest extends TestCase {

    public void testName() throws Exception {
        assertTrue(DiffWithRule.Companion.getNames().contains("diff_with"));
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(DiffWithRule.class));
        assertTrue(ParamAble.class.isAssignableFrom(DiffWithRule.class));
    }

    public void testParams() throws Exception {
        assertTrue(new DiffWithRule(new String[]{"密码"}, "密码", "123456").checkParams());
        assertFalse(new DiffWithRule(new String[]{"密码", "test"}, "密码", "123456").checkParams());
        assertFalse(new DiffWithRule(new String[]{"密码", "test"}, "密码", "123456").checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(new DiffWithRule(new String[]{"密码"}, "密码", "123456").check("123456"));
        assertTrue(new DiffWithRule(new String[]{"密码"}, "密码", "123456").check("test"));
    }
}
