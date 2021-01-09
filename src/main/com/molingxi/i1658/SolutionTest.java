package main.com.molingxi.i1658;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minOperations() {

        int x = new Solution().minOperations(new int[]{3,2,20,1,1,3}, 10);

        Assertions.assertEquals(x, 5);
    }
}