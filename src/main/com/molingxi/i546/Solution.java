package main.com.molingxi.i546;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    Map<ArrayList<Integer>, Integer> cache;


    public int removeBoxes(int[] boxes) {
        cache = new HashMap<>();


        ArrayList<Integer> se = new ArrayList<>();

        for(int i = 0;i < boxes.length;i++) {
            se.add(boxes[i]);
        }
        return removeBoxesInternal(se);
    }


    public int removeBoxesInternal(ArrayList<Integer> boxes) {

        if (boxes == null || boxes.isEmpty()) {
            return 0;
        } else if (boxes.size() == 1) {
            return 1;
        }


        if (cache.containsKey(boxes)) {
            return cache.get(boxes);
        } else {
            int max = Integer.MIN_VALUE;
            ArrayList<Integer> sub = new ArrayList<>();
            for (int s = 0;s < boxes.size();s++) {
                sub.clear();
                if (s > 0) {
                    sub.addAll(boxes.subList(0, s));
                }
                int c = boxes.get(s);
                for (int l = 1;l < boxes.size() - s;l++) {
                    if (c != boxes.get(s + l)) {
                        sub.addAll(boxes.subList(s + l, boxes.size()));

                        max = Math.max(max, l * l + removeBoxesInternal(sub));
                        s = s + l - 1;
                        break;
                    } else if (s + l == boxes.size() - 1) {
                        max = Math.max(max, (l + 1) * (l + 1) + removeBoxesInternal(sub));
                        s = s + l + 1;
                        break;
                    }
                }
            }
            cache.put(new ArrayList<>(boxes), max);
            return max;

        }
    }


    /**
     * class Solution {
     *
     *
     *
     *     int[][][] cache = new int[100][100][100];
     *     int[] boxes;
     *
     *     public int removeBoxes(int[] boxes) {
     *
     *
     *         this.boxes = boxes;
     *         return removeBoxesInternal(0, boxes.length, 0);
     *     }
     *
     *
     *     public int removeBoxesInternal(int s, int e, int l) {
     *         if (s == e) {
     *             return 0;
     *         } else if (cache[s][e][l] > 0 ){
     *
     *         } else {
     *             int max = -1;
     *             int ei = e - 1;
     *
     *             int c = boxes[ei];
     *             while (ei >= s && boxes[ei] == c) {
     *                 l ++;
     *                 ei--;
     *             }
     *
     *             if (ei < s) {
     *                 max = l * l;
     *             } else {
     *
     *                 while (ei >= s)
     *                 int cc = boxes[ei];
     *                 int ll = 1;
     *                 ei --;
     *                 while (ei >= 0 && boxes[ei] == cc) {
     *                     ll ++;
     *                     ei --;
     *                 }
     *
     *
     *             }
     *         }
     *
     *      return cache[s][e][l];
     *     }
     * }
     */
}
