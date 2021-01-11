package main.com.molingxi.i772;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void calculate() {

        System.out.println("*".matches("[+-]"));

//        int x = new Solution().calculate("2*(5+5*2)/3+( 6/2+8)");
//        int x = new Solution().calculate("2*(3+5)/2+1");

        int x ; //= new Solution().calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
        x = new Solution().calculate("1*2-3/4+5*6-7*8+9/10");
        System.out.println(x);
    }
}