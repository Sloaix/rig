package rule.depend;

import com.lsxiao.loki.core.rule.depend.RequiredExceptRule;
import com.lsxiao.loki.core.rule.depend.RequiredWhenRule;

import junit.framework.TestCase;

/**
 * write with LokiRule
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class NotNullExceptTest extends TestCase {
    private RequiredExceptRule requiredExcept;

    @Override
    public void setUp() throws Exception {
        requiredExcept = new RequiredExceptRule(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(RequiredExceptRule.Companion.getName(), "requiredExcept");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredExcept.getParameters().length == 2);
        assertSame(requiredExcept.getParameters()[0], "value");
        assertSame(requiredExcept.getParameters()[1], "value");
        assertNotNull(requiredExcept.getParameters());
        assertTrue(requiredExcept.hasParameters());
        assertTrue(requiredExcept.validateParameters());

        assertFalse(new RequiredWhenRule(new String[]{}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhenRule(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhenRule(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(requiredExcept.validate(""));
        assertTrue(requiredExcept.validate("a"));

        assertTrue(new RequiredWhenRule(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhenRule(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhenRule(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhenRule(new String[]{"test", "test"}).validate(""));
    }
}
