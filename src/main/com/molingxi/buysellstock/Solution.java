package main.com.molingxi.buysellstock;

public class Solution {

    public int twoTransaction(int[] price) {

        int max = 0;


        int k  = 2;
        int[] buyPrices = new int[k];
        int[] sellPrices = new int[k];

        int totalValue = 0;
        int c = 0;
        for (int i = 0;i < k;i ++) {

        }

        return max;




    }

    public int oneTransaction(int[] prices) {
        int min, result;
        result = 0;
        min = prices[0];

        for (int i = 0;i < prices.length;i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            if (prices[i] - min > result) {
                result = prices[i] - min;
            }
        }

        return result;

    }
}
