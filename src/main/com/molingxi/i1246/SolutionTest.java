package main.com.molingxi.i1246;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    @Test
    public void testCase1() {

        int[][] testCases = new int[][] {
                new int[]{3,1,3,4,1,5},
                new int[]{1,1,1,1},
                new int[] {2, 1,4,1,1,2,3,2,1}
        };


        for (int i = 0;i < testCases.length;i++) {
            Assertions.assertEquals(testCases[i][0],  new Solution().minimumMoves(Arrays.copyOfRange(testCases[i], 1, testCases[i].length )));
        }
    }
}