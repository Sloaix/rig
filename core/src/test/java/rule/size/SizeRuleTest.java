package rule.size;

import com.lsxiao.rig.core.rule.size.SizeRule;

import junit.framework.TestCase;

public class SizeRuleTest extends TestCase {
    private SizeRule mSizeRule;

    @Override
    public void setUp() throws Exception {
        mSizeRule = new SizeRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertTrue(SizeRule.Companion.getNames().contains("size"));
    }

    public void testParameters() throws Exception {
        assertTrue(mSizeRule.getParams().length == 1);
        assertSame(mSizeRule.getParams()[0], "3");
        assertNotNull(mSizeRule.getParams());
        assertTrue(mSizeRule.checkParams());

        assertFalse(new SizeRule(new String[]{}).checkParams());
        assertFalse(new SizeRule(new String[]{""}).checkParams());
        assertFalse(new SizeRule(new String[]{"ab"}).checkParams());
        assertFalse(new SizeRule(new String[]{"abcd"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mSizeRule.check(""));
        assertFalse(mSizeRule.check("a"));
        assertFalse(mSizeRule.check("ab"));
        assertTrue(mSizeRule.check("abc"));
        assertFalse(mSizeRule.check("abcd"));
        assertFalse(mSizeRule.check("abcde"));
        assertFalse(mSizeRule.check("abcdef"));
    }
}
