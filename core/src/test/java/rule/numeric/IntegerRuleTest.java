package rule.numeric;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.numeric.IntegerRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 11:43
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class IntegerRuleTest extends TestCase {
    private IntegerRule mIntegerRule;

    @Override
    public void setUp() throws Exception {
        mIntegerRule = new IntegerRule();
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(IntegerRule.class));
    }

    public void testName() throws Exception {
        assertTrue(IntegerRule.Companion.getNames().contains("integer"));
    }

    public void testRule() throws Exception {
        assertFalse(mIntegerRule.check(""));
        assertFalse(mIntegerRule.check("a"));
        assertFalse(mIntegerRule.check("4.1"));
        assertFalse(mIntegerRule.check("ab"));
        assertTrue(mIntegerRule.check("0"));
        assertTrue(mIntegerRule.check("1"));
        assertTrue(mIntegerRule.check("2"));
        assertTrue(mIntegerRule.check("3"));
        assertTrue(mIntegerRule.check("12"));
        assertTrue(mIntegerRule.check("111111111111111111111111111111"));
    }
}
