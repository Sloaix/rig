package rule.size;

import com.lsxiao.loki.core.rule.size.SizeRule;

import junit.framework.TestCase;

public class SizeRuleTest extends TestCase {
    private SizeRule mSizeRule;

    @Override
    public void setUp() throws Exception {
        mSizeRule = new SizeRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(SizeRule.Companion.getName(), "size");
    }

    public void testParameters() throws Exception {
        assertTrue(mSizeRule.getParameters().length == 1);
        assertSame(mSizeRule.getParameters()[0], "3");
        assertNotNull(mSizeRule.getParameters());
        assertTrue(mSizeRule.hasParameters());
        assertTrue(mSizeRule.validateParameters());

        assertFalse(new SizeRule(new String[]{}).validateParameters());
        assertFalse(new SizeRule(new String[]{""}).validateParameters());
        assertFalse(new SizeRule(new String[]{"ab"}).validateParameters());
        assertFalse(new SizeRule(new String[]{"abcd"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(mSizeRule.validate(""));
        assertFalse(mSizeRule.validate("a"));
        assertFalse(mSizeRule.validate("ab"));
        assertTrue(mSizeRule.validate("abc"));
        assertFalse(mSizeRule.validate("abcd"));
        assertFalse(mSizeRule.validate("abcde"));
        assertFalse(mSizeRule.validate("abcdef"));
    }
}
