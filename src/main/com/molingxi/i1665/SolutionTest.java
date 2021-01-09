package main.com.molingxi.i1665;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minimumEffort() {

        int x = new Solution().minimumEffort(new int[][]{{1,7},{2,8},{3,9},{4,10},{5,11},{6,12}});
        System.out.println(x);
    }
}