package rule.length;

import com.lsxiao.rig.core.rule.length.MinLengthRule;

import junit.framework.TestCase;

public class MinLengthRuleTest extends TestCase {
    private MinLengthRule mLengthRule;

    @Override
    public void setUp() throws Exception {
        mLengthRule = new MinLengthRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertTrue(MinLengthRule.Companion.getNames().contains("min_length"));
        assertTrue(MinLengthRule.Companion.getNames().contains("min_len"));
    }

    public void testParameters() throws Exception {
        assertTrue(mLengthRule.getParams().length == 1);
        assertSame(mLengthRule.getParams()[0], "3");
        assertNotNull(mLengthRule.getParams());
        assertTrue(mLengthRule.checkParams());

        assertFalse(new MinLengthRule(new String[]{}).checkParams());
        assertFalse(new MinLengthRule(new String[]{""}).checkParams());
        assertFalse(new MinLengthRule(new String[]{"ab"}).checkParams());
        assertFalse(new MinLengthRule(new String[]{"abcd"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mLengthRule.check(""));
        assertFalse(mLengthRule.check("a"));
        assertFalse(mLengthRule.check("ab"));
        assertTrue(mLengthRule.check("abc"));
        assertTrue(mLengthRule.check("abcd"));
        assertTrue(mLengthRule.check("abcde"));
        assertTrue(mLengthRule.check("abcdef"));
    }
}
