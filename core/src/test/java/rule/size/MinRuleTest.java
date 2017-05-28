package rule.size;

import com.lsxiao.loki.core.rule.size.MaxRule;
import com.lsxiao.loki.core.rule.size.MinRule;

import junit.framework.TestCase;

public class MinRuleTest extends TestCase {
    private MinRule mMinRule;

    @Override
    public void setUp() throws Exception {
        mMinRule = new MinRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(MinRule.Companion.getName(), "min");
    }

    public void testParameters() throws Exception {
        assertTrue(mMinRule.getParams().length == 1);
        assertSame(mMinRule.getParams()[0], "3");
        assertNotNull(mMinRule.getParams());
        assertTrue(mMinRule.needParams());
        assertTrue(mMinRule.checkParams());

        assertFalse(new MaxRule(new String[]{}).checkParams());
        assertFalse(new MaxRule(new String[]{""}).checkParams());
        assertFalse(new MaxRule(new String[]{"abc"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mMinRule.check(""));
        assertFalse(mMinRule.check("a"));
        assertFalse(mMinRule.check("ab"));
        assertTrue(mMinRule.check("abc"));
        assertTrue(mMinRule.check("abcd"));
        assertTrue(mMinRule.check("abcde"));
        assertTrue(mMinRule.check("abcdef"));
    }
}
