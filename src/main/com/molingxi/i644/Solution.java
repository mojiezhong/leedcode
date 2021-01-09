package main.com.molingxi.i644;

public class Solution {


    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }





        char[] chars = new char[100];
        int start = 0;
        int maxIndex = -1;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(start) != s.charAt(i)) {
                maxIndex++;
                chars[maxIndex] = s.charAt(start);
                start = i;
            }

        }

        maxIndex++;
        chars[maxIndex] = s.charAt(s.length() - 1);

        int[][] result = new int[maxIndex + 1][maxIndex + 1];

        for (int i = 0;i <= maxIndex;i++) {
            result[i][i] = 1;
        }
        for (int i = 2;i <= maxIndex + 1;i ++) {
            for (int j = 0;j <= maxIndex + 1- i ;j++) {
                int min = 1 + result[j + 1][j + i - 1];
                for (int k = j + 1; k < j+i;k++) {
                    if (chars[k] == chars[j]) {
                        min = Math.min(min, result[j + 1][k - 1] + result[k][j + i - 1]);
                    }
                }
                result[j][j + i - 1] = min;
            }
        }

        return result[0][maxIndex];
    }


}
