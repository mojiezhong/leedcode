package main.com.molingxi.i960;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int[] length = new int[strs[0].length()];

        length[length.length - 1] = 1;
        int max = 1;
        for (int i = length.length - 2; i >= 0; i--) {
            length[i] = 1;
            for (int j = i + 1; j < length.length; j++) {

                    if (isLE(strs, i, j)) {
                        length[i] = Math.max(length[i], length[j] + 1);


                        max = Math.max(max, length[i]);
                    }

            }
        }

        return length.length - max;
    }

    boolean isLE(String[] strs, int li, int ri) {
        for (int i = 0;i < strs.length;i++) {
            if (strs[i].charAt(li) > strs[i].charAt(ri)) {
                return false;
            }
        }
        return true;
    }


}
