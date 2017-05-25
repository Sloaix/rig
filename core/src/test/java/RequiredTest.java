import com.lsxiao.loki.core.rule.implicit.Required;

import junit.framework.TestCase;

public class RequiredTest extends TestCase {
    private Required required;

    @Override
    public void setUp() throws Exception {
        required = new Required();
    }

    public void testName() throws Exception {
        assertEquals(required.getName(), "required");
    }

    public void testNoParameters() throws Exception {
        assertFalse(required.hasParameter());
        assertFalse(required.isParameterValid());
    }

    public void testRule() throws Exception {
        assertFalse(required.validate(""));
        assertTrue(required.validate("abc"));
        assertTrue(required.validate("123"));
        assertTrue(required.validate("adc123"));
        assertTrue(required.validate("adc123,./"));
    }
}
