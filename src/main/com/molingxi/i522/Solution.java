package main.com.molingxi.i522;

import java.util.Arrays;

public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        for (int i = 0;i < strs.length - 1;i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (seqMatch(strs[i], strs[j]))
                {
                    found = true;
                    break;
                }
            }
            if (! found  ) {
                return strs[i].length();
            }
        }
        return -1;
    }

    // a is longer
    private static boolean seqMatch(String a, String b) {
        for (int ia = 0, ib = 0; ia < a.length() && ib < b.length(); ) {
            if (a.charAt(ia) == b.charAt(ib)) {
                ia++;
                ib++;
                if (ib >= b.length()) {
                    return true;
                }
            } else {
                ib++;
            }
        }
        return false;
    }
}
