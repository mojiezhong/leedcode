package main.com.molingxi.i1658;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> sums = new HashMap<>();

        int sum = 0;
        sums.put(0, -1);
        for (int i =0;i < nums.length;i++) {
            sum += nums[i];
            sums.put(sum, i);
        }


        sum = 0;
        int minCount = sums.getOrDefault(x, Integer.MAX_VALUE - 1) + 1;
        for (int i = nums.length - 1;i > 0; i--) {
            sum += nums[i];
            if (sums.containsKey(x - sum) && sums.get(x - sum) + nums.length - i + 1<= nums.length) {
                minCount = Math.min(minCount, sums.get(x - sum) + nums.length - i + 1);
            }
        }

        return minCount == Integer.MAX_VALUE ? -1: minCount;
    }
}
