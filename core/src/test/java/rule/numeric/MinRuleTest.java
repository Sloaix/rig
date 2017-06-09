package rule.numeric;

import com.lsxiao.rig.core.rule.numeric.MinRule;

import junit.framework.TestCase;

public class MinRuleTest extends TestCase {
    private MinRule mMinRule;

    @Override
    public void setUp() throws Exception {
        mMinRule = new MinRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertTrue(MinRule.Companion.getNames().contains("min"));
    }

    public void testParameters() throws Exception {
        assertTrue(mMinRule.getParams().length == 1);
        assertSame(mMinRule.getParams()[0], "3");
        assertNotNull(mMinRule.getParams());
        assertTrue(mMinRule.checkParams());

        assertFalse(new MinRule(new String[]{}).checkParams());
        assertFalse(new MinRule(new String[]{""}).checkParams());
        assertFalse(new MinRule(new String[]{"abc"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mMinRule.check(""));
        assertFalse(mMinRule.check("a"));
        assertFalse(mMinRule.check("0"));
        assertFalse(mMinRule.check("1"));
        assertFalse(mMinRule.check("2"));

        assertTrue(mMinRule.check("3"));
        assertTrue(mMinRule.check("4"));
        assertTrue(mMinRule.check("100"));
    }
}
