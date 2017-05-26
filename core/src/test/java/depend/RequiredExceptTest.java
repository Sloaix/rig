package depend;

import com.lsxiao.loki.core.rule.depend.RequiredExcept;
import com.lsxiao.loki.core.rule.depend.RequiredWhen;

import junit.framework.TestCase;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 01:31
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class RequiredExceptTest extends TestCase {
    private RequiredExcept requiredExcept;

    @Override
    public void setUp() throws Exception {
        requiredExcept = new RequiredExcept(new String[]{"value", "value"});
    }

    public void testName() throws Exception {
        assertEquals(RequiredExcept.Companion.getName(), "requiredExcept");
    }


    public void testParameters() throws Exception {
        assertTrue(requiredExcept.getParameters().length == 2);
        assertSame(requiredExcept.getParameters()[0], "value");
        assertSame(requiredExcept.getParameters()[1], "value");
        assertNotNull(requiredExcept.getParameters());
        assertTrue(requiredExcept.hasParameters());
        assertTrue(requiredExcept.validateParameters());

        assertFalse(new RequiredWhen(new String[]{}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{""}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"ab"}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"abcd"}).validateParameters());
        assertFalse(new RequiredWhen(new String[]{"a", "a", "abcd"}).validateParameters());
        assertTrue(new RequiredWhen(new String[]{"a", "b"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(requiredExcept.validate(""));
        assertTrue(requiredExcept.validate("a"));

        assertTrue(new RequiredWhen(new String[]{"test", "d"}).validate(""));
        assertFalse(new RequiredWhen(new String[]{"test", "test"}).validate(""));

        assertTrue(new RequiredWhen(new String[]{"test", "test"}).validate("required"));
        assertFalse(new RequiredWhen(new String[]{"test", "test"}).validate(""));
    }
}
