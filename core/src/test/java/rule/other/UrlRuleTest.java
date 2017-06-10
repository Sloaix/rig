package rule.other;

import com.lsxiao.rig.core.rule.other.UrlRule;

import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-06-10 09:58
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class UrlRuleTest extends TestCase {
    public void testName() throws Exception {
        assertTrue(UrlRule.Companion.getNames().contains("url"));
    }

    public void testRule() throws Exception {
        assertTrue(new UrlRule().check("http://RegExr.com?2rjl6"));
        assertTrue(new UrlRule().check("https://google.com"));
        assertTrue(new UrlRule().check("http://www.cool.com.au"));
        assertTrue(new UrlRule().check("http://www.cool.com.au/ersdfs"));
        assertTrue(new UrlRule().check("http://www.cool.com.au/ersdfs?dfd=dfgd@s=1"));
        assertTrue(new UrlRule().check("http://www.cool.com:81/index.html"));

        assertFalse(new UrlRule().check("://www.baidu.com"));
        assertFalse(new UrlRule().check("//www.baidu.com"));
        assertFalse(new UrlRule().check("www.baidu.com"));
        assertFalse(new UrlRule().check("http://"));
    }

}
