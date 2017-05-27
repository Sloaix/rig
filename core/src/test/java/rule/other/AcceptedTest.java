package rule.other;

import com.lsxiao.loki.core.rule.other.AcceptedRule;

import junit.framework.TestCase;

/**
 * write with LokiRule
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

    public void testNoParameters() throws Exception {
        assertNotNull(accepted.getParameters());
        assertTrue(accepted.getParameters().length == 0);
        assertFalse(accepted.hasParameters());
        assertFalse(accepted.validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(accepted.validate("yes"));
        assertTrue(accepted.validate("on"));
        assertTrue(accepted.validate("1"));
        assertTrue(accepted.validate("true"));

        assertFalse(accepted.validate("no"));
        assertFalse(accepted.validate("off"));
        assertFalse(accepted.validate("0"));
        assertFalse(accepted.validate("2"));
        assertFalse(accepted.validate("3"));
        assertFalse(accepted.validate("false"));
    }
}
