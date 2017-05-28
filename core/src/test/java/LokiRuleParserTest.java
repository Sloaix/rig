import com.lsxiao.loki.core.LokiRuleParser;
import com.lsxiao.loki.core.rule.other.NotNullRule;
import com.lsxiao.loki.core.rule.size.BetweenRule;
import com.lsxiao.loki.core.rule.size.MaxRule;

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
        assertEquals(LokiRuleParser.INSTANCE.parse(rule1).size(), 1);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule1).get(0) instanceof NotNullRule);

        assertEquals(LokiRuleParser.INSTANCE.parse(rule2).size(), 1);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule2).get(0) instanceof MaxRule);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule2).get(0).getParams().length, 1);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule2).get(0).getParams()[0], "31");

        assertEquals(LokiRuleParser.INSTANCE.parse(rule3).size(), 1);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule3).get(0) instanceof BetweenRule);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule3).get(0).getParams().length, 2);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule3).get(0).getParams()[0], "4");
        assertEquals(LokiRuleParser.INSTANCE.parse(rule3).get(0).getParams()[1], "19");

        assertEquals(LokiRuleParser.INSTANCE.parse(rule4).size(), 2);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule4).get(0) instanceof NotNullRule);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule4).get(1) instanceof MaxRule);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule4).get(0).getParams().length, 0);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule4).get(1).getParams().length, 1);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule4).get(1).getParams()[0], "31");

        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).size(), 3);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule5).get(0) instanceof NotNullRule);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule5).get(1) instanceof MaxRule);
        assertTrue(LokiRuleParser.INSTANCE.parse(rule5).get(2) instanceof BetweenRule);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(0).getParams().length, 0);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(1).getParams().length, 1);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(2).getParams().length, 2);
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(1).getParams()[0], "31");
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(2).getParams()[0], "4");
        assertEquals(LokiRuleParser.INSTANCE.parse(rule5).get(2).getParams()[1], "19");
    }
}
