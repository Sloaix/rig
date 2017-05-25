package implicit;

import com.lsxiao.loki.core.rule.implicit.Accepted;

import junit.framework.TestCase;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 00:54
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class AcceptedTest extends TestCase {
    private Accepted accepted;

    @Override
    public void setUp() throws Exception {
        accepted = new Accepted();
    }

    public void testName() throws Exception {
        assertEquals(accepted.getName(), "accepted");
    }

    public void testNoParameters() throws Exception {
        assertFalse(accepted.hasParameter());
        assertFalse(accepted.isParameterValid());
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
