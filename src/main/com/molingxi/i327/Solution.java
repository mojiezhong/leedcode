package main.com.molingxi.i327;

import java.util.Arrays;

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {

        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        int[] sums = new int[nums.length + 1];
        sums[0] = 0;

        for ( int i = 0;i < nums.length;i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        Arrays.sort(sums);

        int count  = 0 ;
        int start = 0;
        int end = 1;

        while (end < sums.length) {

            while (inRange(sums[end] - sums[start], lower, upper) && end < sums.length) {
                count += (end - start);
                if (end < sums.length - 1) {
                    end++;
                }

            }

            while (start < end && !inRange(sums[end] - sums[start], lower, upper) ) {
                start++;
            }
            if (start == end) {
                end ++;
            }

        }

        return count;

    }

    boolean inRange(int value, int start, int end) {
        return value >= start && value <= end;
    }
}