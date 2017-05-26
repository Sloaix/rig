package rule.depend;

import com.lsxiao.loki.core.rule.depend.RequiredExceptRule;
import com.lsxiao.loki.core.rule.depend.RequiredWhenTulr;

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

        assertFalse(new RequiredWhenTulr(new String[]{}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhenTulr(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhenTulr(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(requiredExcept.validate(""));
        assertTrue(requiredExcept.validate("a"));

        assertTrue(new RequiredWhenTulr(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhenTulr(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhenTulr(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhenTulr(new String[]{"test", "test"}).validate(""));
    }
}
