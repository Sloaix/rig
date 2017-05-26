package rule.size;

import com.lsxiao.loki.core.rule.size.MaxRule;
import com.lsxiao.loki.core.rule.size.MinRule;

import junit.framework.TestCase;

public class MaxRuleTest extends TestCase {
    private MaxRule mMaxRule;

    @Override
    public void setUp() throws Exception {
        mMaxRule = new MaxRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(MaxRule.Companion.getName(), "max");
    }

    public void testParameters() throws Exception {
        assertTrue(mMaxRule.getParameters().length == 1);
        assertSame(mMaxRule.getParameters()[0], "3");
        assertNotNull(mMaxRule.getParameters());
        assertTrue(mMaxRule.hasParameters());
        assertTrue(mMaxRule.validateParameters());


        assertFalse(new MinRule(new String[]{}).validateParameters());
        assertFalse(new MinRule(new String[]{""}).validateParameters());
        assertFalse(new MinRule(new String[]{"abc"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(mMaxRule.validate(""));
        assertTrue(mMaxRule.validate("a"));
        assertTrue(mMaxRule.validate("ab"));
        assertTrue(mMaxRule.validate("abc"));
        assertFalse(mMaxRule.validate("abcd"));
        assertFalse(mMaxRule.validate("abcde"));
        assertFalse(mMaxRule.validate("abcdef"));
    }
}
