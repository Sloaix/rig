package size;

import com.lsxiao.loki.core.rule.size.Max;
import com.lsxiao.loki.core.rule.size.Min;

import junit.framework.TestCase;

public class MaxTest extends TestCase {
    private Max max;

    @Override
    public void setUp() throws Exception {
        max = new Max(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(max.getName(), "max");
    }

    public void testParameters() throws Exception {
        assertTrue(max.getParameters().length == 1);
        assertSame(max.getParameters()[0], "3");
        assertNotNull(max.getParameters());
        assertTrue(max.hasParameters());
        assertTrue(max.validateParameters());


        assertFalse(new Min(new String[]{}).validateParameters());
        assertFalse(new Min(new String[]{""}).validateParameters());
        assertFalse(new Min(new String[]{"abc"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertTrue(max.validate(""));
        assertTrue(max.validate("a"));
        assertTrue(max.validate("ab"));
        assertTrue(max.validate("abc"));
        assertFalse(max.validate("abcd"));
        assertFalse(max.validate("abcde"));
        assertFalse(max.validate("abcdef"));
    }
}
