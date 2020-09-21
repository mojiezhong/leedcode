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
        if (cache.containsKey(boxes)) {
            return cache.get(boxes);
        } else {

        }


    }
}
