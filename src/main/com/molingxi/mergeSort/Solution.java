package main.com.molingxi.mergeSort;

public class Solution {

    public int[] mergeSort(int[] arr) {
        int[] ori = new int[arr.length];

        int[] tar = arr;

        int leng = 1;

        while(leng < arr.length) {
            for (int s = 0;s < arr.length;s += 2 * leng) {
                int ms = s + leng;
                int r = (s + 2 * leng) > arr.length - 1 ? arr.length  : (s + 2 * leng);

                for (int i = s, j = ms; i < ms || j < r;) {
                    while( i < leng && (j == leng || ori[s + i] <= ori[s + leng + j])) {
                        tar[s + i + j ] = ori[s + i];
                        i++;
                    }

                    while(j < leng && (i == leng || ori[s + i] > ori[s + leng + j])) {
                        tar[s + i + j] = ori[s + leng + j];
                        j++;
                    }
                }
            }
            leng *= 2;
        }

        return tar;
    }
}
