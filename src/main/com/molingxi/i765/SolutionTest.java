package main.com.molingxi.i765;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void test1() {
        int out = new Solution().minSwapsCouples(new int[]{5,4,2,6,3,1,0,7});
        System.out.println(out);
    }

}