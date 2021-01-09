package main.com.molingxi.i546;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {


    @Test
    void removeBoxes1() {
//        System.out.println(new Solution().removeBoxes(new int[] {1,1,2,2,1}));
        System.out.println(new Solution().removeBoxes(new int[] {1,3,2,2,2,3,4,3,1}));

        System.out.println(new Solution().removeBoxes(new int[] {
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));

//        System.out.println(new Solution().removeBoxes(new int[] {
//                3,8,8,5,5,3,9,2,4,4,6,5,8,4,8,6,9,6,2,8,6,4,1,9,5,3,10,5,3,3,9,8,8,6,5,3,7,4,9,6,3,9,4,3,5,10,7,6,10,7}));

        //
    }
    @Test
    void removeBoxes() {

        ArrayList<Integer> a1, a2;

        a1 = new ArrayList<>();

        a2 = new ArrayList<>();

        a1.add(1);
        a1.add(3);

        a2.add(1);

        System.out.println(a1.equals(a2));

        a2.add(3);

        System.out.println(a1.equals(a2));

        Map<ArrayList<Integer>, Integer> map = new HashMap<>();

        map.put(a1, 100);

        System.out.println(map.get(a2));

        a2.add(4);

        System.out.println(map.get(a2));

    }
}