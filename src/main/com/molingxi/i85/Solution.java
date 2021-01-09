package main.com.molingxi.i85;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int maximalRectangle(char[][] matrix) {

        int[] hight = new int[matrix[0].length];

        for (int i = 0;i < matrix[0].length;i++) {
            if (matrix[0][i] == '1') {
                hight[i] = 1;
            } else {
                hight[i] = 0;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int y = 0;y < matrix[0].length;y++) {
            List<Block> bs = new LinkedList<Block>();
            for (int x = 0; x < matrix.length; x++) {
                if (matrix[x][y] == '1') {
                    hight[x] ++;
                    if (bs.isEmpty()) {
                        bs.add(new Block(hight[x], 1));
                    } else {

                        if (hight[x] == hight[x - 1]) {
                            bs.get(0).width++;
                        } else if (hight[x] > hight[x -1]) {
                            bs.add(new Block(hight[x], 1));
                        } else {
                            int length = 0;
                            while (! bs.isEmpty() && bs.get(0).height >= hight[x]) {
                                length += bs.get(0).width;
                                bs.remove(0);
                            }

                            bs.add(new Block(hight[x], length));
                        }

                    }
                } else {
                    hight[x] = 0;
                    bs.clear();
                }

                int length = 0;
                for(Block b : bs) {
                    length += b.width;
                    max = Math.max(max, length * b.height);
                }
            }
        }

        return max;
    }


    static class Block{
        public int height, width;

        public Block(int h, int w) {
            height = h;
            width = w;
        }
    }
}
