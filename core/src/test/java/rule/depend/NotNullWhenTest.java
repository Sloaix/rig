package rule.depend;

import com.lsxiao.loki.core.rule.depend.RequiredWhen;

import junit.framework.TestCase;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NotNullWhenTest extends TestCase {
    private RequiredWhen requiredWhen;

    @Override
    public void setUp() throws Exception {
        requiredWhen = new RequiredWhen(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(RequiredWhen.Companion.getName(), "requiredWhen");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredWhen.getParameters().length == 2);
        assertSame(requiredWhen.getParameters()[0], "value");
        assertSame(requiredWhen.getParameters()[1], "value");
        assertNotNull(requiredWhen.getParameters());
        assertTrue(requiredWhen.hasParameters());
        assertTrue(requiredWhen.validateParameters());

        assertFalse(new RequiredWhen(new String[]{}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhen(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(requiredWhen.validate(""));
        assertTrue(requiredWhen.validate("a"));

        assertTrue(new RequiredWhen(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhen(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhen(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhen(new String[]{"test", "test"}).validate(""));
    }
}
