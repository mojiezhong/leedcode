package main.com.molingxi.i85;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maximalRectangle() {

        char[][] m = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        //int x = new Solution().maximalRectangle(m);

        for (int i = 0;i < m.length;i++) {
            for (int j = 0;j < m[i].length;j++) {
                System.out.print ("   " + m[i][j]);
            }
            System.out.println();
        }
    }
}