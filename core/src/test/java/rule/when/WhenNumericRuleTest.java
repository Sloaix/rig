package rule.when;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.RelyAble;
import com.lsxiao.rig.core.rule.WhenAble;
import com.lsxiao.rig.core.rule.when.WhenNotNullRule;
import com.lsxiao.rig.core.rule.when.WhenNumericRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 14:20
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class WhenNumericRuleTest extends TestCase {

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(WhenNumericRule.class));
        assertTrue(WhenAble.class.isAssignableFrom(WhenNumericRule.class));
        assertTrue(RelyAble.class.isAssignableFrom(WhenNumericRule.class));
    }
}
