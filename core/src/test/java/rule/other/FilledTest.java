package rule.other;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.other.FilledRule;

import junit.framework.TestCase;

/**
 * write with Rig
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

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(FilledRule.class));
    }

    public void testName() throws Exception {
        assertTrue(FilledRule.Companion.getNames().contains("filled"));
    }

    public void testRule() throws Exception {
        assertFalse(mFilled.check(null));
        assertFalse(mFilled.check(""));
        assertTrue(mFilled.check("abc"));
        assertTrue(mFilled.check("123"));
        assertTrue(mFilled.check("adc123"));
        assertTrue(mFilled.check("adc123,./"));
    }
}
