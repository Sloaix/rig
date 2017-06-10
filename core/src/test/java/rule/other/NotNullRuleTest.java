package rule.other;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.other.NotNullRule;

import junit.framework.TestCase;

public class NotNullRuleTest extends TestCase {
    private NotNullRule mNotNull;

    @Override
    public void setUp() throws Exception {
        mNotNull = new NotNullRule();
    }
    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(NotNullRule.class));
    }


    public void testName() throws Exception {
        assertTrue(NotNullRule.Companion.getNames().contains("notnull"));
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
