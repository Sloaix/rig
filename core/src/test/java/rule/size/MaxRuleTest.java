package rule.size;

import com.lsxiao.rig.core.rule.size.MaxRule;
import com.lsxiao.rig.core.rule.size.MinRule;

import junit.framework.TestCase;

public class MaxRuleTest extends TestCase {
    private MaxRule mMaxRule;

    @Override
    public void setUp() throws Exception {
        mMaxRule = new MaxRule(new String[]{"3"});
    }

//    public void testName() throws Exception {
//        assertTrue(MaxRule.Companion.getNames().contains("max"));
//    }

    public void testParameters() throws Exception {
        assertTrue(mMaxRule.getParams().length == 1);
        assertSame(mMaxRule.getParams()[0], "3");
        assertNotNull(mMaxRule.getParams());
        assertTrue(mMaxRule.checkParams());


        assertFalse(new MinRule(new String[]{}).checkParams());
        assertFalse(new MinRule(new String[]{""}).checkParams());
        assertFalse(new MinRule(new String[]{"abc"}).checkParams());
    }
//
//    public void testRule() throws Exception {
//        assertTrue(mMaxRule.check(""));
//        assertTrue(mMaxRule.check("a"));
//        assertTrue(mMaxRule.check("ab"));
//        assertTrue(mMaxRule.check("abc"));
//        assertFalse(mMaxRule.check("abcd"));
//        assertFalse(mMaxRule.check("abcde"));
//        assertFalse(mMaxRule.check("abcdef"));
//    }
}
