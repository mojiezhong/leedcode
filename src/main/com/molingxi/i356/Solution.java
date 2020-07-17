package main.com.molingxi.i356;

import java.util.*;

class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> agg = new HashMap<>();


        for (int i = 0;i < points.length;i++) {
            agg.merge(points[i][1], new ArrayList<>(
                Arrays.asList(points[i][0])), (a, b) -> {a.addAll(b); return a;}
            );
        }


        int mid = Integer.MAX_VALUE;

        for (List<Integer> list : agg.values()) {
            if (mid == Integer.MAX_VALUE) {
                mid = findMid(list);
            }

            if (mid == Integer.MIN_VALUE || mid != findMid(list) ){
                return false;
            }
        }

        return true;
    }

    private int findMid(List<Integer> list) {
        Collections.sort(list);

        int mid = (list.get(0) + list.get(list.size() - 1)) / 2;


        for (int i = 1;i < list.size() / 2 - 1; i ++) {
            if ((list.get(i) + list.get(list.size() - i - 1)) / 2 != mid) {
                return Integer.MIN_VALUE;
            }
        }

        return mid;
    }
}