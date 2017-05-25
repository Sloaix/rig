package size;

import com.lsxiao.loki.core.rule.size.Between;

import junit.framework.TestCase;

public class BetweenTest extends TestCase {
    private Between between;

    @Override
    public void setUp() throws Exception {
        between = new Between(new String[]{"1", "3"});
    }

    public void testName() throws Exception {
        assertEquals(between.getName(), "between");
    }

    public void testParameters() throws Exception {
        assertTrue(between.getParameters().length == 2);
        assertSame(between.getParameters()[0], "1");
        assertSame(between.getParameters()[1], "3");
        assertNotNull(between.getParameters());
        assertTrue(between.hasParameter());
        assertTrue(between.isParameterValid());

        assertFalse(new Between(new String[]{}).isParameterValid());
        assertFalse(new Between(new String[]{""}).isParameterValid());
        assertFalse(new Between(new String[]{"ab"}).isParameterValid());
        assertFalse(new Between(new String[]{"abcd"}).isParameterValid());
        assertFalse(new Between(new String[]{"a", "a", "abcd"}).isParameterValid());
        assertFalse(new Between(new String[]{"a", "b"}).isParameterValid());
    }

    public void testRule() throws Exception {
        assertFalse(between.validate(""));
        assertTrue(between.validate("a"));
        assertTrue(between.validate("ab"));
        assertTrue(between.validate("abc"));
        assertFalse(between.validate("abcd"));
        assertFalse(between.validate("abcde"));
        assertFalse(between.validate("abcdef"));
    }
}
