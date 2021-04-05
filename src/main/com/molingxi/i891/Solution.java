package main.com.molingxi.i891;

import java.util.Arrays;

public class Solution {

    private final long MOD = 1000000007 ;


    long[] power2;
    public int sumSubseqWidths(int[] A) {


        initPower2(A.length - 1);

        Arrays.sort(A);

        long result = 0;
        for (int i = 0;i < A.length - 1;i++) {
            for (int j = i+1; j < A.length;j++) {
                result += (A[j] - A[i]) * power2[j - i - 1];
//                if (result > MOD) {
//                    result %= MOD;
//                }
                //while (result > MOD) {
                    result %= MOD;
                //}
            }
        }

        return (int) (result % MOD);
    }

    private void initPower2(int n) {
        long result = 1;
        int index = 1;
        power2 = new long[n + 1];
        power2[0] = 1;
        while (n > 0) {
            result <<= 1;
            if (result > MOD) {
                result -= MOD;
            }

            power2[index] = result;
            index++;
            n--;
        }
    }

    private long pow(int n) {

        long result = 1;
        if (n <=0 )
            return 1;


        return result ;
    }
}
