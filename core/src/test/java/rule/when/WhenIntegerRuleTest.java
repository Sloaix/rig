package rule.when;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.RelyAble;
import com.lsxiao.rig.core.rule.WhenAble;
import com.lsxiao.rig.core.rule.when.WhenIntegerRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 14:20
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class WhenIntegerRuleTest extends TestCase {

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(WhenIntegerRule.class));
        assertTrue(WhenAble.class.isAssignableFrom(WhenIntegerRule.class));
        assertTrue(RelyAble.class.isAssignableFrom(WhenIntegerRule.class));
    }

    public void testName() throws Exception {
        assertTrue(WhenIntegerRule.Companion.getNames().contains("when_int"));
        assertTrue(WhenIntegerRule.Companion.getNames().contains("when_integer"));
    }
}
