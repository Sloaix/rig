package rule.value;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.RelyAble;
import com.lsxiao.rig.core.rule.value.DiffRule;
import com.lsxiao.rig.core.rule.value.SameAsRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 13:57
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class DiffRuleTest extends TestCase {

    public void testName() throws Exception {
        assertTrue(DiffRule.Companion.getNames().contains("diff"));
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(SameAsRule.class));
        assertTrue(RelyAble.class.isAssignableFrom(SameAsRule.class));
    }

    public void testParams() throws Exception {
        assertTrue(new DiffRule(new String[]{"1"}).checkParams());
        assertTrue(new DiffRule(new String[]{"a"}).checkParams());
        assertFalse(new DiffRule(new String[]{"a", "1"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(new DiffRule(new String[]{"1"}).check("1"));

        assertTrue(new DiffRule(new String[]{"1"}).check("2"));
    }
}
