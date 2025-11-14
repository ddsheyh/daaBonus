import java.util.ArrayList;
import java.util.List;

public class KMP {
    private int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];

        int length = 0;
        int i = 1;
        lps[0] = 0;

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> foundIndices = new ArrayList<>();
        int N = text.length();
        int M = pattern.length();

        if (M == 0) {
            return foundIndices;
        }
        int[] lps = computeLPSArray(pattern);
        int i = 0;
        int j = 0;

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                foundIndices.add(i - j);
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return foundIndices;
    }
}
