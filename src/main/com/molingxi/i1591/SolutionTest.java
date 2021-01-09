package main.com.molingxi.i1591;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1() {
        assertTrue(new Solution().isPrintable(
                new int[][]{{2,1,1}, {1,2,1},{1,1,1}}
        ));
    }
}