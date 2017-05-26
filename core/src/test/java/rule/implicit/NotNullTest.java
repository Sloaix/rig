package rule.implicit;

import com.lsxiao.loki.core.rule.implicit.NotNull;

import junit.framework.TestCase;

public class NotNullTest extends TestCase {
    private NotNull mNotNull;

    @Override
    public void setUp() throws Exception {
        mNotNull = new NotNull();
    }

    public void testName() throws Exception {
        assertEquals(NotNull.Companion.getName(), "notnull");
    }

    public void testNoParameters() throws Exception {
        assertNotNull(mNotNull.getParameters());
        assertTrue(mNotNull.getParameters().length == 0);
        assertFalse(mNotNull.hasParameters());
        assertFalse(mNotNull.validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(mNotNull.validate(null));
        assertTrue(mNotNull.validate(""));
        assertTrue(mNotNull.validate("abc"));
        assertTrue(mNotNull.validate("123"));
        assertTrue(mNotNull.validate("adc123"));
        assertTrue(mNotNull.validate("adc123,./"));
    }
}
