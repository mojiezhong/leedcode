package main.com.molingxi.i480;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {
//    public double[] medianSlidingWindow(int[] numsOrigin, int k) {
//
//        if (numsOrigin == null || numsOrigin.length == 0 )
//            return new double[0];
//
//        long[] nums = new long[numsOrigin.length];
//
//        for (int i = 0;i < numsOrigin.lenght;i++) {
//            nums[i] = numsOrigin[i] * 2;
//        }
//
//
//        long[] result = new long[nums.length - k + 1];
//
//        TreeMap<Long, Integer> left = new TreeMap<>();
//        TreeMap<Long, Integer> right = new TreeMap<>();
//
//        long[] buf = Arrays.copyOf(nums, k);
//        Arrays.sort(buf);
//
//        if (k % 2 ==0 ) {
//            result[0] = ( buf[k / 2 -1] + buf[k / 2]) / 2;
//        } else {
//            result[0] = buf[k / 2];
//        }
//
//        for (int i = 0;i < k / 2;i ++) {
//            left.merge(buf[i] , 1, (pre,c) -> pre + 1);
//            right.merge(buf[ k - 1 - i], 1, (pre,c) -> pre + 1);
//        }
//
//        int cur = k;
//        int leftSize = 100;
//        int rightSize = 100;
//        for(int i = 1;i < result.length;i++) {
//
//            long removeValue = nums[i - 1];
//            long newValue = nums[i + k - 1];
//            long mid = result[i - 1];
//
//            if (mid > removeValue ) {
//                leftSize --;
//                left.compute(removeValue,  (k, v) -> v == 1 ? null : v - 1);
//
//            } if (k % 2 == 0 && mid == removeValue) {
//                mid = left.lastKey();
//                left.compute(left.lastKey(), (k, v)-> v == 1 ? null : v - 1);
//                leftSize --;
//            }else {
//                rightSize --;
//                right.compute(removeValue,  (k, v) -> v == 1 ? null : v - 1);
//            }
//
//            if (mid >= newValue) {
//                leftSize ++;
//                left.merge(newValue, 1, (p, v) -> p + 1);
//            } else {
//                rightSize ++;
//                right.merge(newValue, 1, (p, v) -> p+1);
//            }
//
//
//            if (leftSize == rightSize) {
//                if (k % 2 == 0) {
//                    result[i] = (left.lastKey() + right.firstKey() ) / 2;
//                } else {
//                    result[i] = mid;
//                }
//            } else {
//                if (k%2 == 0) {
//                    if (leftSize > rightSize) {
//                        int value = left.lastKey();
//                        left.compute(value, (k, v) -> v == 1? null : v - 1);
//                        right.merge(value, 1, (p, v) -> p + 1);
//                    } else {
//                        int value = right.firstKey();
//                        right.compute(value, (k, v) -> v == 1? null : v - 1);
//                        left.merge(value, 1, (p, v) -> p + 1);
//                    }
//
//                    result[i] = (double)(left.lastKey() + right.firstKey() ) / 2;
//                } else {
//                    if (leftSize > rightSize) {
//                        right.merge((int)result[i-1], 1, (p, v) -> p + 1);
//                        result[i] = left.lastKey();
//                        left.compute(left.lastKey(), (k, v) -> v == 1? null: v - 1);
//                    } else {
//                        left.merge((int)result[i-1], 1, (p, v) -> p + 1);
//                        result[i] = right.firstKey();
//                        right.compute(right.firstKey(), (k, v) -> v == 1? null: v - 1);
//                    }
//
//                }
//                leftSize = 100;
//                rightSize = 100;
//            }
//        }
//
//        return result;
//    }
}