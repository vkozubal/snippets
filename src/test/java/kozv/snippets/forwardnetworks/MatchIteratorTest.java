package kozv.snippets.forwardnetworks;

import kozv.snippets.forwardnetworks.MatchIterator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class MatchIteratorTest {
    @Test
    public void test_1() {
        List<String> strings = Arrays.asList("test 1", "test 2");
        MatchIterator textIterable = createIterator(strings);
        assertTrue(textIterable.hasNext());
        assertEquals("test 1", textIterable.next());
        assertTrue(textIterable.hasNext());
        assertEquals("test 2", textIterable.next());
        assertFalse(textIterable.hasNext());
    }

    @Test
    public void test_2() {
        List<String> strings = Arrays.asList("abc", " some test 1 test 2", " some text", "test 2");
        MatchIterator textIterable = createIterator(strings);
        assertTrue(textIterable.hasNext());
        assertEquals(" some test 1 test 2\n some text", textIterable.next());
        assertTrue(textIterable.hasNext());
        assertEquals("test 2", textIterable.next());
        assertFalse(textIterable.hasNext());
    }

    @Test
    public void test_3() {
        Iterator<String> textIterable = createIterator(Arrays.asList("test 1","test 2"));
        assertTrue(textIterable.hasNext());
        assertTrue(textIterable.hasNext());
        assertEquals("test 1", textIterable.next());
    }

    private static MatchIterator createIterator(List<String> strings) {
        return new MatchIterator(strings.iterator(), "test");
    }
}