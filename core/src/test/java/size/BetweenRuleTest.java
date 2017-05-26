package size;

import com.lsxiao.loki.core.rule.size.BetweenRule;

import junit.framework.TestCase;

public class BetweenRuleTest extends TestCase {
    private BetweenRule mBetweenRule;

    @Override
    public void setUp() throws Exception {
        mBetweenRule = new BetweenRule(new String[]{"1", "3"});
    }

    public void testName() throws Exception {
        assertEquals(BetweenRule.Companion.getName(), "between");
    }

    public void testParameters() throws Exception {
        assertTrue(mBetweenRule.getParameters().length == 2);
        assertSame(mBetweenRule.getParameters()[0], "1");
        assertSame(mBetweenRule.getParameters()[1], "3");
        assertNotNull(mBetweenRule.getParameters());
        assertTrue(mBetweenRule.hasParameters());
        assertTrue(mBetweenRule.validateParameters());

        assertFalse(new BetweenRule(new String[]{}).validateParameters());
        assertFalse(new BetweenRule(new String[]{""}).validateParameters());
        assertFalse(new BetweenRule(new String[]{"ab"}).validateParameters());
        assertFalse(new BetweenRule(new String[]{"abcd"}).validateParameters());
        assertFalse(new BetweenRule(new String[]{"a", "a", "abcd"}).validateParameters());
        assertFalse(new BetweenRule(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(mBetweenRule.validate(""));
        assertTrue(mBetweenRule.validate("a"));
        assertTrue(mBetweenRule.validate("ab"));
        assertTrue(mBetweenRule.validate("abc"));
        assertFalse(mBetweenRule.validate("abcd"));
        assertFalse(mBetweenRule.validate("abcde"));
        assertFalse(mBetweenRule.validate("abcdef"));
    }
}
