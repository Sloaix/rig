import junit.framework.TestCase;

/**
 * write with Rig
 * author:lsxiao
 * date:2017-05-26 22:37
 * github:https://github.com/lsxiao
 * zhihu:https://zhihu.com/people/lsxiao
 */

public class RuleParserTest extends TestCase {
    String rule1 = "notnull";
    String rule2 = "max:31";
    String rule3 = "between:4,19";
    String rule4 = "notnull|max:31";
    String rule5 = "notnull|max:31|between:4,19";

    public void testParser() throws Exception {
//        assertEquals(RuleParser.INSTANCE.parse(rule1).size(), 1);
//        assertTrue(RuleParser.INSTANCE.parse(rule1).get(0) instanceof NotNullRule);
//
//        assertEquals(RuleParser.INSTANCE.parse(rule2).size(), 1);
//        assertTrue(RuleParser.INSTANCE.parse(rule2).get(0) instanceof MaxRule);
//        assertEquals(((MaxRule) RuleParser.INSTANCE.parse(rule2).get(0)).getParams().length, 1);
//        assertEquals(((MaxRule) RuleParser.INSTANCE.parse(rule2).get(0)).getParams()[0], "31");
//
//        assertEquals(RuleParser.INSTANCE.parse(rule3).size(), 1);
//        assertTrue(RuleParser.INSTANCE.parse(rule3).get(0) instanceof BetweenRule);
//        assertEquals(((BetweenRule) RuleParser.INSTANCE.parse(rule3).get(0)).getParams().length, 2);
//        assertEquals(((BetweenRule) RuleParser.INSTANCE.parse(rule3).get(0)).getParams()[0], "4");
//        assertEquals(((BetweenRule) RuleParser.INSTANCE.parse(rule3).get(0)).getParams()[1], "19");
//
//        assertEquals(RuleParser.INSTANCE.parse(rule4).size(), 2);
//        assertTrue(RuleParser.INSTANCE.parse(rule4).get(0) instanceof NotNullRule);
//        assertTrue(RuleParser.INSTANCE.parse(rule4).get(1) instanceof MaxRule);
//        assertEquals(((MaxRule) RuleParser.INSTANCE.parse(rule4).get(0)).getParams().length, 0);
//        assertEquals(((MaxRule) RuleParser.INSTANCE.parse(rule4).get(1)).getParams().length, 1);
//        assertEquals(((MaxRule) RuleParser.INSTANCE.parse(rule4).get(1)).getParams()[0], "31");
//
//        assertEquals(RuleParser.INSTANCE.parse(rule5).size(), 3);
//        assertTrue(RuleParser.INSTANCE.parse(rule5).get(0) instanceof NotNullRule);
//        assertTrue(RuleParser.INSTANCE.parse(rule5).get(1) instanceof MaxRule);
//        assertTrue(RuleParser.INSTANCE.parse(rule5).get(2) instanceof BetweenRule);
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(0).getParams().length, 0);
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(1).getParams().length, 1);
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(2).getParams().length, 2);
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(1).getParams()[0], "31");
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(2).getParams()[0], "4");
//        assertEquals(RuleParser.INSTANCE.parse(rule5).get(2).getParams()[1], "19");
    }
}
