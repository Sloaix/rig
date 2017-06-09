package rule.when;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.RelyAble;
import com.lsxiao.rig.core.rule.WhenAble;
import com.lsxiao.rig.core.rule.when.WhenLengthRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 14:20
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class WhenLengthRuleTest extends TestCase {

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(WhenLengthRule.class));
        assertTrue(WhenAble.class.isAssignableFrom(WhenLengthRule.class));
        assertTrue(RelyAble.class.isAssignableFrom(WhenLengthRule.class));
    }


    public void testName() throws Exception {
        assertTrue(WhenLengthRule.Companion.getNames().contains("when_length"));
    }
}
