package rule.other;

import com.lsxiao.rig.core.rule.other.AcceptedRule;

import junit.framework.TestCase;

/**
 * write with RigRule
 * author:lsxiao
 * date:2017-05-26 00:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class AcceptedTest extends TestCase {
    private AcceptedRule accepted;

    @Override
    public void setUp() throws Exception {
        accepted = new AcceptedRule();
    }

    public void testName() throws Exception {
        assertEquals(AcceptedRule.Companion.getName(), "accepted");
    }

    public void testRule() throws Exception {
        assertTrue(accepted.check("yes"));
        assertTrue(accepted.check("on"));
        assertTrue(accepted.check("1"));
        assertTrue(accepted.check("true"));

        assertFalse(accepted.check("no"));
        assertFalse(accepted.check("off"));
        assertFalse(accepted.check("0"));
        assertFalse(accepted.check("2"));
        assertFalse(accepted.check("3"));
        assertFalse(accepted.check("false"));
    }
}
