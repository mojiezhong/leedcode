package main.com.molingxi.i84;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestRectangleArea() {

        int x = new Solution().largestRectangleArea(new int[] {2,1,5,6,0,0,2,2,2,2,2,2,2,3});
        System.out.println(x);
    }
}