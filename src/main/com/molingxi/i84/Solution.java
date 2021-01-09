package main.com.molingxi.i84;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        int[] length = new int[heights.length];

        int max = Integer.MIN_VALUE;


        int ln = 1;
        length[0] = 1;
        for (int i = 1;i < heights.length;i++) {

             if (heights[i] > heights[i - 1]) {
                 ln = 1;
             } else if (heights[i] < heights[i - 1] ) {
                ln = 0;
                for (int j =  i - 1;j >= 0 && heights[j] >= heights[i]; j = j - length[j]) {
                    ln += length[j];
                    max = Math.max(max, ln * heights[j]);
                }
                ln++;

            } else {
                 ln ++;
             }

             length[i] = ln;
        }

        for (int i = length.length - 1;i >= 0;i -= length[i]) {
            max = Math.max(max, (length.length - i - 1 + length[i]) * heights[i] );
        }

        return max;
    }
}
