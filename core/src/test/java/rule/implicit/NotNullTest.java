package rule.implicit;

import com.lsxiao.loki.core.rule.implicit.NotNullRule;

import junit.framework.TestCase;

public class NotNullTest extends TestCase {
    private NotNullRule mNotNull;

    @Override
    public void setUp() throws Exception {
        mNotNull = new NotNullRule();
    }

    public void testName() throws Exception {
        assertEquals(NotNullRule.Companion.getName(), "notnull");
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
