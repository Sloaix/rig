package size;

import com.lsxiao.loki.core.rule.size.Size;

import junit.framework.TestCase;

public class SizeTest extends TestCase {
    private Size size;

    @Override
    public void setUp() throws Exception {
        size = new Size(new String[]{"3"});
    }

    public void testName() throws Exception {
        assertEquals(size.getName(), "size");
    }

    public void testParameters() throws Exception {
        assertTrue(size.getParameters().length == 1);
        assertSame(size.getParameters()[0], "3");
        assertNotNull(size.getParameters());
        assertTrue(size.hasParameters());
        assertTrue(size.validateParameters());

        assertFalse(new Size(new String[]{}).validateParameters());
        assertFalse(new Size(new String[]{""}).validateParameters());
        assertFalse(new Size(new String[]{"ab"}).validateParameters());
        assertFalse(new Size(new String[]{"abcd"}).validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(size.validate(""));
        assertFalse(size.validate("a"));
        assertFalse(size.validate("ab"));
        assertTrue(size.validate("abc"));
        assertFalse(size.validate("abcd"));
        assertFalse(size.validate("abcde"));
        assertFalse(size.validate("abcdef"));
    }
}
