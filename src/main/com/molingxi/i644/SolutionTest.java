package main.com.molingxi.i644;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void testStrangePrinter() {
        Assertions.assertEquals(2, new Solution().strangePrinter("112211"));
    }

}