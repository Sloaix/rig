package rule.depend;

import com.lsxiao.loki.core.rule.depend.RequiredWhenRule;

import junit.framework.TestCase;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NotNullWhenTest extends TestCase {
    private RequiredWhenRule requiredWhen;

    @Override
    public void setUp() throws Exception {
        requiredWhen = new RequiredWhenRule(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(RequiredWhenRule.Companion.getName(), "requiredWhen");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredWhen.getParameters().length == 2);
        assertSame(requiredWhen.getParameters()[0], "value");
        assertSame(requiredWhen.getParameters()[1], "value");
        assertNotNull(requiredWhen.getParameters());
        assertTrue(requiredWhen.hasParameters());
        assertTrue(requiredWhen.validateParameters());

        assertFalse(new RequiredWhenRule(new String[]{}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhenRule(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(requiredWhen.validate(""));
        assertTrue(requiredWhen.validate("a"));

        assertTrue(new RequiredWhenRule(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhenRule(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhenRule(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhenRule(new String[]{"test", "test"}).validate(""));
    }
}
