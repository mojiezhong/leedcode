package main.com.molingxi.i10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isMatch() {
        boolean r = new Solution().isMatch("abcd", "a*d");
        Assertions.assertTrue(r);
    }
}