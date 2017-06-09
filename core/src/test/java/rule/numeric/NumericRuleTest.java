package rule.numeric;

import com.lsxiao.rig.core.rule.numeric.NumericRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 11:44
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NumericRuleTest extends TestCase {
    private NumericRule mNumericRule;


    @Override
    public void setUp() throws Exception {
        mNumericRule = new NumericRule();
    }

    public void testName() throws Exception {
        assertTrue(NumericRule.Companion.getNames().contains("numeric"));
    }

    public void testRule() throws Exception {
        assertFalse(mNumericRule.check(""));
        assertFalse(mNumericRule.check("a"));
        assertFalse(mNumericRule.check("a4"));

        assertTrue(mNumericRule.check("0"));
        assertTrue(mNumericRule.check("1"));
        assertTrue(mNumericRule.check("1.0"));
        assertTrue(mNumericRule.check("1.2"));
        assertTrue(mNumericRule.check("1.02"));
        assertTrue(mNumericRule.check("1.02"));
        assertTrue(mNumericRule.check("0.0"));
    }
}
