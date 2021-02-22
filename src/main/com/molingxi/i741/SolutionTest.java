package main.com.molingxi.i741;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void cherryPickup() {
        int value;
        //value = new Solution().cherryPickup(new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}});

        int [][] grid = new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
        grid = new int[][]
                {       {1,1,1,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,1},
                        {1,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,0,0,0},
                        {0,0,0,1,1,1,1}};

        grid = new int[][]
                       {{1,  1,1, 1, 1},
                        {1,  1,1, 1, 1},
                        {-1,-1,1, 1,-1},
                        {1,  1,1, 1, 1},
                        {1,  1,1,-1, 1}};


        value = new Solution().cherryPickup(grid);


        System.out.println(value);
    }


    // 0   1   1
    // 1  -1   1
}   // 1   1   1