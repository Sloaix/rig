package rule.size;

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
        assertTrue(mBetweenRule.getParams().length == 2);
        assertSame(mBetweenRule.getParams()[0], "1");
        assertSame(mBetweenRule.getParams()[1], "3");
        assertNotNull(mBetweenRule.getParams());
        assertTrue(mBetweenRule.needParams());
        assertTrue(mBetweenRule.checkParams());

        assertFalse(new BetweenRule(new String[]{}).checkParams());
        assertFalse(new BetweenRule(new String[]{""}).checkParams());
        assertFalse(new BetweenRule(new String[]{"ab"}).checkParams());
        assertFalse(new BetweenRule(new String[]{"abcd"}).checkParams());
        assertFalse(new BetweenRule(new String[]{"a", "a", "abcd"}).checkParams());
        assertFalse(new BetweenRule(new String[]{"a", "b"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mBetweenRule.check(""));
        assertTrue(mBetweenRule.check("a"));
        assertTrue(mBetweenRule.check("ab"));
        assertTrue(mBetweenRule.check("abc"));
        assertFalse(mBetweenRule.check("abcd"));
        assertFalse(mBetweenRule.check("abcde"));
        assertFalse(mBetweenRule.check("abcdef"));
    }
}
