package main.com.molingxi.i546;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

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