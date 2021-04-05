package main.com.molingxi.buysellstock;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution s = new Solution();

    @Test
    void twoTransaction() {
    }

    @Test
    void oneTransaction() {

        System.out.println(s.oneTransaction(new int[]{8,3,2,5,3,7,1}));
    }
}