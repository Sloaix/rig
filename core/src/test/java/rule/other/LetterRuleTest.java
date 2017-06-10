package rule.other;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.other.LetterRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-10 09:51
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class LetterRuleTest extends TestCase {

    public void testName() throws Exception {
        assertTrue(LetterRule.Companion.getNames().contains("letter"));
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(LetterRule.class));
    }

    public void testRule() throws Exception {
        assertFalse(new LetterRule().check(null));
        assertFalse(new LetterRule().check(""));
        assertTrue(new LetterRule().check("a"));
        assertTrue(new LetterRule().check("abc"));
        assertTrue(new LetterRule().check("abccccccccccccccccccccccccccccccccc"));
    }

}
