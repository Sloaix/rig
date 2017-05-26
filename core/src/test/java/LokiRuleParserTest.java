import com.lsxiao.loki.core.LokiRuleParser;

import junit.framework.TestCase;

/**
 * write with Loki
 * author:lsxiao
 * date:2017-05-26 22:37
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class LokiRuleParserTest extends TestCase {
    String rule1 = "notnull";
    String rule2 = "max:31";
    String rule3 = "between:4,19";
    String rule4 = "notnull|max:31";
    String rule5 = "notnull|max:31|between:4,19";


    public void testParser() throws Exception {
        System.out.println(LokiRuleParser.INSTANCE.parse(rule1));
    }
}
