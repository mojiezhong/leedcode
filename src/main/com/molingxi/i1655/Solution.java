package main.com.molingxi.i1655;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    Map<String, Boolean> cache = new HashMap<>();
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] freq = new int[1001];

        int total = 0;
        for (int i = 0;i < nums.length;i++) {
            if (freq[nums[i]] == 0) {
                total ++;
            }
            freq[nums[i]]++;

        }

        int[]  cFreq = new int[total];
        int c  = 0;
        for (int i = 0;i < freq.length;i++) {
            if (freq[i] != 0) {
                cFreq [c] = freq[i];
                c++;
            }
        }


        return canDInternal(cFreq, quantity, 0 );

    }


    boolean canDInternal(int[] freq, int[] q, int s) {
        if (s >= q.length) {
            return true;
        }

        String key = getKey(freq);
        if (cache.get(key) != null) {
            return cache.get(key);
        }

        for (int i = 0;i < freq.length;i++) {
            if (freq[i] >= q[s]) {
                freq[i] -= q[s];
                if (canDInternal(freq, q, s + 1)) {
                    cache.put(key, Boolean.TRUE);
                    return true;
                } else {
                    freq[i] += q[s];
                }
            }
        }

        cache.put(key, Boolean.FALSE);
        return false;
    }

    String getKey(int[] freq) {



        StringBuilder sb = new StringBuilder();
        Arrays.stream(freq).sorted().forEach(i ->  {sb.append(Integer.toHexString(i)); sb.append(',');});
        return sb.toString();
        //return Stream.of(freq).map(i -> Integer::toHexString).collect(Collectors.joining(","));
    }
}
