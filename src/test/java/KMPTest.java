import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class KMPTest {

    private final KMP kmp = new KMP();

    @Test
    void testShortString_SingleMatch() {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        List<Integer> expected = List.of(10); // Index 10
        assertEquals(expected, kmp.KMPSearch(text, pattern), "Should find a single match in a short string");
    }

    @Test
    void testMediumString_MultipleOverlappingMatches() {
        String text = "AAAAABAAAAAAAAA";
        String pattern = "AAA";
        List<Integer> expected = List.of(0, 1, 2, 8, 9, 10, 11);
        assertEquals(expected, kmp.KMPSearch(text, pattern), "Should find all overlapping matches");
    }

    @Test
    void testLongString_NoMatch() {
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String pattern = "XYZ123";
        List<Integer> expected = List.of();
        assertTrue(kmp.KMPSearch(text, pattern).isEmpty(), "Should return an empty list when no match is found");
    }

    @Test
    void testEdgeCase_PatternAtStartAndEnd() {
        String text = "CATDOGCAT";
        String pattern = "CAT";
        List<Integer> expected = List.of(0, 6);
        assertEquals(expected, kmp.KMPSearch(text, pattern), "Should find matches at start and end");
    }

    @Test
    void testEdgeCase_LongPatternInShortText() {
        String text = "ABC";
        String pattern = "ABCD";
        List<Integer> expected = List.of();
        assertTrue(kmp.KMPSearch(text, pattern).isEmpty(), "Should return empty list if pattern is longer than text");
    }
}