package main.com.molingxi.i936;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] movesToStamp(String stamp, String target) {
        List<Integer> result  = movesToStampInternal(stamp, target, 0, target.length(), false, false);

        if (result != null) {
            return result.stream().mapToInt(i -> i.intValue()).toArray();
        }

        return new int[0];
    }


    Map<Integer, List<Integer>> cacheResultes = new HashMap<>();

    private List<Integer> movesToStampInternal(String stamp, String target, int start, int end , boolean leftPad, boolean rightPad) {

        Integer key = start * 1000 + end + (leftPad ? 10000001: 0) + (rightPad? 10000002: 0);

        if (cacheResultes.containsKey(key)) {
            return cacheResultes.get(key);
        }

        for (int i = start  - (leftPad ? stamp.length() - 1: 0);i < end - (rightPad? 0 : stamp.length()  - 1);i++) {
            boolean match = true;
            for (int j = 0;j < stamp.length();j++) {
                if (i + j  >= start && i + j < end && target.charAt(i + j) != stamp.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {

                List<Integer> subLeft, subRight;

                if (i > start) {
                    subLeft = movesToStampInternal(stamp, target, start, i, leftPad, true);
                } else {
                    subLeft = new ArrayList<>();
                }

                if (subLeft != null && i < end - stamp.length()) {
                    subRight = movesToStampInternal(stamp, target, i + stamp.length() , end, true, rightPad);
                } else {
                    subRight = new ArrayList<>();
                }

                if (subLeft != null && subRight != null) {
                    subLeft.addAll(subRight);
                    subLeft.add(i);
                    cacheResultes.put(key, subLeft);
                    return subLeft;
                }
            }
        }

        cacheResultes.put(key, null);
        return null;
    }
}