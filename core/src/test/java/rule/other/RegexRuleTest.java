package rule.other;

import com.lsxiao.rig.core.rule.BaseRule;
import com.lsxiao.rig.core.rule.ParamAble;
import com.lsxiao.rig.core.rule.other.RegexRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-09 11:59
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class RegexRuleTest extends TestCase {

    public void testName() throws Exception {
        assertTrue(RegexRule.Companion.getNames().contains("regex"));

        assertTrue(new RegexRule(new String[]{".*test.*"}).checkParams());
    }

    public void testClass() throws Exception {
        assertTrue(BaseRule.class.isAssignableFrom(RegexRule.class));
        assertTrue(ParamAble.class.isAssignableFrom(RegexRule.class));
    }

    public void testRule() throws Exception {
        assertTrue(new RegexRule(new String[]{"[1-9][0-9]{4,}"}).check("99705542"));
        assertFalse(new RegexRule(new String[]{"[1-9][0-9]{4,}"}).check("abcdefg"));

        assertTrue(new RegexRule(new String[]{"[a-zA-z]+://[^\\s]*"}).check("http://www.baidu.com"));
    }

}
