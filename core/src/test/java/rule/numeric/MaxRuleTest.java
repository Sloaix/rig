package rule.numeric;

import com.lsxiao.rig.core.rule.numeric.MaxRule;
import com.lsxiao.rig.core.rule.numeric.MinRule;

import junit.framework.TestCase;

public class MaxRuleTest extends TestCase {
    private MaxRule mMaxRule;

    @Override
    public void setUp() throws Exception {
        mMaxRule = new MaxRule(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertTrue(MaxRule.Companion.getNames().contains("max"));
    }

    public void testParameters() throws Exception {
        assertTrue(mMaxRule.getParams().length == 1);
        assertSame(mMaxRule.getParams()[0], "3");
        assertNotNull(mMaxRule.getParams());
        assertTrue(mMaxRule.checkParams());


        assertFalse(new MinRule(new String[]{}).checkParams());
        assertFalse(new MinRule(new String[]{""}).checkParams());
        assertFalse(new MinRule(new String[]{"abc"}).checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mMaxRule.check(""));
        assertFalse(mMaxRule.check("a"));
        assertFalse(mMaxRule.check("4"));
        assertFalse(mMaxRule.check("100"));
        assertTrue(mMaxRule.check("0"));
        assertTrue(mMaxRule.check("1"));
        assertTrue(mMaxRule.check("2"));
        assertTrue(mMaxRule.check("3"));
    }
}
