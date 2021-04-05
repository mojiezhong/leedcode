package main.com.molingxi.i522;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findLUSlength() {
        int x = new Solution().findLUSlength(new String[] {"aba", "cdc", "eae"});
        System.out.println(x);
    }
}