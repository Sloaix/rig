package rule.other;

import com.lsxiao.loki.core.rule.other.FilledRule;

import junit.framework.TestCase;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 22:53
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class FilledTest extends TestCase {
    private FilledRule mFilled;

    @Override
    public void setUp() throws Exception {
        mFilled = new FilledRule();
    }

    public void testName() throws Exception {
        assertEquals(FilledRule.Companion.getName(), "filled");
    }

    public void testNoParameters() throws Exception {
        assertNotNull(mFilled.getParameters());
        assertTrue(mFilled.getParameters().length == 0);
        assertFalse(mFilled.hasParameters());
        assertFalse(mFilled.validateParameters());
    }

    public void testRule() throws Exception {
        assertFalse(mFilled.validate(null));
        assertFalse(mFilled.validate(""));
        assertTrue(mFilled.validate("abc"));
        assertTrue(mFilled.validate("123"));
        assertTrue(mFilled.validate("adc123"));
        assertTrue(mFilled.validate("adc123,./"));
    }
}
