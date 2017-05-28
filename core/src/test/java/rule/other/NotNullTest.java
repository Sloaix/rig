package rule.other;

import com.lsxiao.loki.core.rule.other.NotNullRule;

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
        assertNotNull(mNotNull.getParams());
        assertTrue(mNotNull.getParams().length == 0);
        assertFalse(mNotNull.needParams());
        assertFalse(mNotNull.checkParams());
    }

    public void testRule() throws Exception {
        assertFalse(mNotNull.check(null));
        assertTrue(mNotNull.check(""));
        assertTrue(mNotNull.check("abc"));
        assertTrue(mNotNull.check("123"));
        assertTrue(mNotNull.check("adc123"));
        assertTrue(mNotNull.check("adc123,./"));
    }
}
