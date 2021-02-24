package main.com.molingxi.i1044;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String longestDupSubstring(String s) {

        int[] visited = new int[s.length()];
        List<Integer>[] buckets = new List['z' - 'a' + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = s.length() - 1; i >= 0;) {

            int l = 1;
            while (i - l >= 0 &&s.charAt(i) == s.charAt(i - l)) {
                l++;
            }
            buckets[s.charAt(i) - 'a'].add(i);
            buckets[s.charAt(i) - 'a'].add(l);
            i -= l;
        }

        int start = -1;
        int mx = 0;

        for (int i = s.length() - 1; i > 0; i--) {

            char c = s.charAt(i);
            List<Integer> is = buckets[c - 'a'];

            int blockStart = is.get(0);
            int blockLength = is.get(1);

            if (i == blockStart && blockLength > 1) {
                if (blockLength - 1 > mx) {
                    mx = blockLength - 1;
                    start = i - blockLength + 1;
                }
            }

            for (int j = 2;j < is.size();j+= 2) {
                int bs2 = is.get(j);
                int bl2 = is.get(j + 1);


                if (bl2 >= blockLength - blockStart + i) {

                    bs2 = bs2 - bl2  + blockLength - blockStart + i;

                    if (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(bs2 + 1)) {
                        continue;
                    }

                    int ll = blockLength - blockStart + i + 1;

                    while (bs2 - ll + 1>= 0 && s.charAt(bs2 - ll + 1) == s.charAt(i - ll + 1)) {
                        ll += 1;
                    }

                    ll--;
                    if (ll > mx) {
                        mx = ll;
                        start = bs2 - ll + 1;
                    }
                }
            }

            if (i == blockStart - blockLength + 1) {
                is.remove(0);
                is.remove(0);
            }


        }

        if (start >= 0)
            return s.substring(start, start + mx);
        else
            return "";
    }
}
