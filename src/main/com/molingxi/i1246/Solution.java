package main.com.molingxi.i1246;

/**
 *
 * https://leetcode.com/problems/palindrome-removal/
 *
 *
 *
 * ard
 *
 * 145
 *
 * 4
 *
 * Add to List
 *
 * Share
 * Given an integer array arr, in one move you can select a palindromic subarray arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that subarray from the given array. Note that after removing a subarray, the elements on the left and on the right of that subarray move to fill the gap left by the removal.
 *
 * Return the minimum number of moves needed to remove all numbers from the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2]
 * Output: 2
 * Example 2:
 *
 * Input: arr = [1,3,4,1,5]
 * Output: 3
 * Explanation: Remove [4] then remove [1,3,1] then remove [5].
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 20
 */
public class Solution {

    public int minimumMoves(int[] arr) {
        int[][] values = new int[arr.length][arr.length];


        for (int i = 0;i < arr.length;i++) {
            values[i][i] = 1;
        }

        for (int i = 1;i <= arr.length-1;i++) {
            for (int j = 0;j < arr.length - i;j ++) {
                int min = Integer.MAX_VALUE;
                if (arr[j] == arr[j + i]) {
                    if (i == 1) {
                        min = 1;
                    } else {
                        min = values [ j + 1] [ j + i - 1];
                    }
                }

                for (int k = 0 ;k < i;k++) {
                    min = Math.min(min,
                            values[j][j + k] + values[j+ k + 1][j + i]);
                }

                values[j][j + i] = min;

            }
        }


        return values [0][arr.length - 1];
    }

}
