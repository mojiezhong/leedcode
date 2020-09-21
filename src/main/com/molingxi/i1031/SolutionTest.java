package main.com.molingxi.i1031;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maxSumTwoNoOverlap() {

        int r= (new Solution()).maxSumTwoNoOverlap(new int[] {0,6,5,2,2,5,1,9,4}, 1,2);

        Assertions.assertEquals(20, r);
    }
}