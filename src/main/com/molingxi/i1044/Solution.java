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
            buckets[i] = new LinkedList<>();
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

        for (int i = s.length() - 1; i >= 0; i--) {


            char c = s.charAt(i);
            List<Integer> is = buckets[c - 'a'];
            if (is.size() >= 2) {
                is.remove(0);


                Iterator<Integer> iter = is.iterator();


                while (iter.hasNext()) {
                    int x = iter.next();

                    if ((i < s.length() - 1 && s.charAt(i + 1) == s.charAt(x +1)) || visited[x] == i) {
                        continue;
                    }

                    visited[x] = i;

//
//                    if (i < s.length() - 1 && s.charAt(x + 1) == s.charAt(i + 1)) {
//                        maxLength[x] = maxLength[x + 1] + 1;
//                    } else {
//                        maxLength[x] = 1;
//                    }
//
//                    if (maxLength[x] > mx) {sz
//                        start = x;
//                        mx = maxLength[x];
//                    }
                    int l = 1;
                    while (x - l >= 0 && s.charAt(x - l) == s.charAt(i - l)) {
                        visited[x - l] = i;
                        visited[i - l] = i;
                        l++;

                    }

                    if (l > mx) {
                        start = x - l + 1;
                        mx = l;
                    }

                }
            }
        }

        if (start >= 0)
            return s.substring(start, start + mx);
        else
            return "";
    }
}
