package size;

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
        assertTrue(mMinRule.getParameters().length == 1);
        assertSame(mMinRule.getParameters()[0], "3");
        assertNotNull(mMinRule.getParameters());
        assertTrue(mMinRule.hasParameters());
        assertTrue(mMinRule.validateParameters());

        assertFalse(new MaxRule(new String[]{}).validateParameters());
        assertFalse(new MaxRule(new String[]{""}).validateParameters());
        assertFalse(new MaxRule(new String[]{"abc"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(mMinRule.validate(""));
        assertFalse(mMinRule.validate("a"));
        assertFalse(mMinRule.validate("ab"));
        assertTrue(mMinRule.validate("abc"));
        assertTrue(mMinRule.validate("abcd"));
        assertTrue(mMinRule.validate("abcde"));
        assertTrue(mMinRule.validate("abcdef"));
    }
}
