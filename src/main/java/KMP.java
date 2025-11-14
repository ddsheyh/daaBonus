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


}
