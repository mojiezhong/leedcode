package main.com.molingxi.i741;

public class Solution {

    int[][][]  cache;
    public int cherryPickup(int[][] grid) {

        cache = new int[grid.length + grid[0].length - 2][grid[0].length][grid[0].length];

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        for (int i = 0;i < cache.length;i++) {
            for (int y = 0;y < cache[i].length;y++) {
                for (int x = 0;x < cache[i][y].length; x++) {
                    cache[i][y][x] = -2;
                }
            }
        }

        int result =  cherryPickupInternal(grid, 0 , 0 , 0);
        if (result == -1) {
            result = 0 ;
        }
        return result;

    }

    int cherryPickupInternal(int[][] grid, int d, int s1, int s2) {
        int y1, y2, x1, x2;
        y1 = d < grid.length ? d - s1 :  grid.length - 1 - s1;
        x1 = d < grid.length ? s1 : d - grid.length + 1 + s1;

        y2 = d < grid.length ? d - s2 : grid.length - 1 - s2;
        x2 = d < grid.length ? s2 : d -grid.length + 1 + s2;


        if (d == cache.length) {

                return grid[grid.length - 1][grid[0].length - 1];

        }
        if (grid[y1][x1] == -1 || grid[y2][x2] == -1) {
            return -1;
        } else {

            if (cache[d][s1][s2] >= -1) {
                return cache[d][s1][s2];
            } else {
                {
                    int result = -1;

                    int current = s1 == s2 ? grid[y1][x1] : grid[y1][x1] + grid[y2][x2];


                    int ss1 = d < grid.length -1 ? s1 :  s1 - 1;
                    int ss2 = d < grid.length -1  ? s2 :  s2 - 1;

                    for (int i = 0;i < 2 ; i++) {
                        if (inScope(grid, d + 1, ss1 + i) ) {
                            for (int j = 0;j < 2;j++) {
                                if (inScope(grid, d+ 1, ss2 + j) && ss2 + j >= ss1 + i) {
                                    int value = cherryPickupInternal(grid, d + 1, ss1 + i, ss2 + j);
                                    if (value >= 0 )
                                        result =Math.max(result,   current + value);
                                }
                            }
                        }
                    }


                    cache[d][s1][s2]= result;
                    return result;
                }
            }
        }
    }

    boolean inScope(int[][] grid, int d, int s) {
        return d < grid.length && s <= d || d >= grid.length && d - grid.length + 1 + s < grid[0].length  && s >= 0;
    }
}
