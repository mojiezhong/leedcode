package main.com.molingxi.i1665;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a , b) ->  (a[1] - a[0]) - (b[1] - b[0]) );
        int min = 0;
        for (int i = 0;i < tasks.length;i++) {
            if (tasks[i][1] - tasks[i][0] > min) {
                min = tasks[i][1];
            } else {
                min = min + tasks[i][0];
            }

        }
        return min;
    }
//    public int minimumEffort(int[][] tasks) {
//        int[][][] results = new int[tasks.length][tasks.length][2];
//
//        for (int i = 0;i < tasks.length;i++) {
//            results[i][i][1] = tasks[i][1];
//            results[i][i][0] = tasks[i][0];
//        }
//
//        for (int l = 2;l <= tasks.length;l++) {
//            for (int i = 0;i <= tasks.length - l;i++) {
//
//
//                int m = Integer.MAX_VALUE;
//                int a = Integer.MAX_VALUE;
//
//                for (int j = i;j < i + l - 1; j++) {
//
//                    int m0 = results[i][j][1];
//                    int m1 = results[j+1][i + l - 1] [ 1];
//                    int a0 = results[i][j][0];
//                    int a1 = results[j+1][i + l - 1] [ 0];
//
//                    a = Math.min(a, a0 + a1);
//                    m = Math.min(m,
//                            Math.min(
//                               m1 > (m0 - a0) ? m1 + a0 : m0,
//                               m0 > (m1 - a1) ? m0 + a1 : m1
//                            ));
//
//                }
//
//                results[i][i + l - 1][0] = a;
//                results[i][i + l - 1][1] = m;
//
//            }
//        }
//
//        return results[0][tasks.length - 1][1];
//    }
}
