package size;

import com.lsxiao.loki.core.rule.size.Max;
import com.lsxiao.loki.core.rule.size.Min;

import junit.framework.TestCase;

public class MinTest extends TestCase {
    private Min min;

    @Override
    public void setUp() throws Exception {
        min = new Min(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(min.getName(), "min");
    }

    public void testParameters() throws Exception {
        assertTrue(min.getParameters().length == 1);
        assertSame(min.getParameters()[0], "3");
        assertNotNull(min.getParameters());
        assertTrue(min.hasParameters());
        assertTrue(min.validateParameters());

        assertFalse(new Max(new String[]{}).validateParameters());
        assertFalse(new Max(new String[]{""}).validateParameters());
        assertFalse(new Max(new String[]{"abc"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(min.validate(""));
        assertFalse(min.validate("a"));
        assertFalse(min.validate("ab"));
        assertTrue(min.validate("abc"));
        assertTrue(min.validate("abcd"));
        assertTrue(min.validate("abcde"));
        assertTrue(min.validate("abcdef"));
    }
}
