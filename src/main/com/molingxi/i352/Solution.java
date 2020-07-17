package main.com.molingxi.i352;

import java.util.Map;
import java.util.TreeMap;

class SummaryRanges {

    int[][] current;
    TreeMap<Integer, int[]> boundary = new TreeMap<>();
    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {



        Map.Entry<Integer, int[]> entry = boundary.floorEntry(val);
        Map.Entry<Integer, int[]> ceil = boundary.ceilingEntry(val);

        if (entry == null || entry.getValue()[1] < val - 1) {

            if (ceil != null && ceil.getValue()[0] == val + 1) {
                boundary.remove(ceil.getKey());
                boundary.put(val, new int[]{val, ceil.getValue()[1]});
            } else {
                boundary.put(val, new int[] {val, val});
            }
            rebuild();
        } else if (entry.getValue()[1] >= val ) {
            return ;
        } else if (entry.getValue()[1] == val - 1) {
            if (ceil == null || ceil.getValue()[0] > val + 1  ) {
                entry.getValue() [1] = val;
            } else {
                entry.getValue()[1] = ceil.getValue()[1];
                boundary.remove(ceil.getKey());
                rebuild();
            }
        }
    }

    private void rebuild() {
        current = new int[boundary.size()][];
        int i = 0;
        for (Integer key : boundary.navigableKeySet()) {
            current[i] = boundary.get(key);
            i++;
        }
    }

    public int[][] getIntervals() {
        return current;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */