package main.com.molingxi.i765;

class Solution {


    public int minSwapsCouples(int[] row) {

        int[] ind = new int[row.length];


        for (int i = 0;i < row.length;i++) {
            ind[row[i]] = i;
        }

        int count = 0;

        for (int i = 0;i < row.length;i += 2) {
            int mx = Math.max(row[i], row[i + 1]);
            int mi = Math.min(row[i], row[i + 1]);

            if (mi % 2 != 0) {
                row[ind[mi - 1]] = mx;
                ind[mx] = ind[mi - 1];
                count++;
            } else if (mx % 2 == 0 || mx != mi + 1) {
                row[ind[mi + 1]] = mx;
                ind[mx] = ind[mi + 1];
                count++;
            }
        }

        return count;

    }
}