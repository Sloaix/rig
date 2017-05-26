package rule.depend;

import com.lsxiao.loki.core.rule.depend.RequiredWhenTulr;

import junit.framework.TestCase;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NotNullWhenTest extends TestCase {
    private RequiredWhenTulr requiredWhen;

    @Override
    public void setUp() throws Exception {
        requiredWhen = new RequiredWhenTulr(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(RequiredWhenTulr.Companion.getName(), "requiredWhen");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredWhen.getParameters().length == 2);
        assertSame(requiredWhen.getParameters()[0], "value");
        assertSame(requiredWhen.getParameters()[1], "value");
        assertNotNull(requiredWhen.getParameters());
        assertTrue(requiredWhen.hasParameters());
        assertTrue(requiredWhen.validateParameters());

        assertFalse(new RequiredWhenTulr(new String[]{}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhenTulr(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(requiredWhen.validate(""));
        assertTrue(requiredWhen.validate("a"));

        assertTrue(new RequiredWhenTulr(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhenTulr(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhenTulr(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhenTulr(new String[]{"test", "test"}).validate(""));
    }
}
