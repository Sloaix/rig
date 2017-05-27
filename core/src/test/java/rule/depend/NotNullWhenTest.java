package rule.depend;

import com.lsxiao.loki.core.rule.depend.WhenEqualRule;

import junit.framework.TestCase;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NotNullWhenTest extends TestCase {
    private WhenEqualRule requiredWhen;

    @Override
    public void setUp() throws Exception {
        requiredWhen = new WhenEqualRule(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(WhenEqualRule.Companion.getName(), "requiredWhen");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredWhen.getParameters().length == 2);
        assertSame(requiredWhen.getParameters()[0], "value");
        assertSame(requiredWhen.getParameters()[1], "value");
        assertNotNull(requiredWhen.getParameters());
        assertTrue(requiredWhen.hasParameters());
        assertTrue(requiredWhen.validateParameters());

        assertFalse(new WhenEqualRule(new String[]{}).validateParameters());
        assertFalse(new WhenEqualRule(new String[]{""}).validateParameters());
        assertFalse(new WhenEqualRule(new String[]{"ab"}).validateParameters());
        assertFalse(new WhenEqualRule(new String[]{"abcd"}).validateParameters());
        assertFalse(new WhenEqualRule(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new WhenEqualRule(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(requiredWhen.validate(""));
        assertTrue(requiredWhen.validate("a"));

        assertTrue(new WhenEqualRule(new String[]{"test", "d"}).validate(""));
        assertFalse(new WhenEqualRule(new String[]{"test", "test"}).validate(""));

        assertTrue(new WhenEqualRule(new String[]{"test", "test"}).validate("required"));
        assertFalse(new WhenEqualRule(new String[]{"test", "test"}).validate(""));
    }
}
