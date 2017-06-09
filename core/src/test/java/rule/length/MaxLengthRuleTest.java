package rule.length;

import com.lsxiao.rig.core.rule.length.MaxLengthRule;

import junit.framework.TestCase;

public class MaxLengthRuleTest extends TestCase {
    private MaxLengthRule mMaxLengthRule;

    @Override
    public void setUp() throws Exception {
        mMaxLengthRule = new MaxLengthRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertTrue(MaxLengthRule.Companion.getNames().contains("max_length"));
        assertTrue(MaxLengthRule.Companion.getNames().contains("max_len"));
    }

    public void testParameters() throws Exception {
        assertTrue(mMaxLengthRule.getParams().length == 1);
        assertSame(mMaxLengthRule.getParams()[0], "3");
        assertNotNull(mMaxLengthRule.getParams());
        assertTrue(mMaxLengthRule.checkParams());

        assertFalse(new MaxLengthRule(new String[]{}).checkParams());
        assertFalse(new MaxLengthRule(new String[]{""}).checkParams());
        assertFalse(new MaxLengthRule(new String[]{"ab"}).checkParams());
        assertFalse(new MaxLengthRule(new String[]{"abcd"}).checkParams());
    }

    public void testRule() throws Exception {
        assertTrue(mMaxLengthRule.check(""));
        assertTrue(mMaxLengthRule.check("a"));
        assertTrue(mMaxLengthRule.check("ab"));
        assertTrue(mMaxLengthRule.check("abc"));
        assertFalse(mMaxLengthRule.check("abcd"));
        assertFalse(mMaxLengthRule.check("abcde"));
        assertFalse(mMaxLengthRule.check("abcdef"));
    }
}
