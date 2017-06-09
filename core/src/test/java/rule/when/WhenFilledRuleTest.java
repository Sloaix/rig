package rule.when;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.RelyAble;
import com.lsxiao.rig.core.rule.WhenAble;
import com.lsxiao.rig.core.rule.when.WhenFilledRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 14:20
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class WhenFilledRuleTest extends TestCase {

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(WhenFilledRule.class));
        assertTrue(WhenAble.class.isAssignableFrom(WhenFilledRule.class));
        assertTrue(RelyAble.class.isAssignableFrom(WhenFilledRule.class));
    }

    public void testName() throws Exception {
        assertTrue(WhenFilledRule.Companion.getNames().contains("when_filled"));
        assertTrue(WhenFilledRule.Companion.getNames().contains("when_notempty"));
    }
}
