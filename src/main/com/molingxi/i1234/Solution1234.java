package main.com.molingxi.i1234;

public class Solution1234 {

    public static void main(String[] args) {

        System.out.println((new Solution1234()).balancedString("QWER"));
    }

    public int balancedString(String s) {
        int[]  count = new int[26];


        int quat = s.length() / 4;


        for (int i = s.length() - 1;i >= 0; i--) {
            count[s.charAt(i) - 'A']++;
        }

        if ((count['Q' - 'A'] == quat) &&
                count['R' - 'A'] == quat &&
                count['W' - 'A'] == quat &&
                count['E' - 'A'] == quat) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int tail = s.length() - 1;

        for (int head = s.length() - 1; head >= 0;head--) {
            count[s.charAt(head) - 'A'] --;
            while(count[s.charAt(tail) - 'A' ] < quat ) {
                count[s.charAt(tail) - 'A'] ++;
                tail--;
            }


            if (min != Integer.MAX_VALUE) {
                if (min > tail - head + 1) {
                    min = tail - head + 1;
                }
            } else
            if (count['Q' - 'A'] <= quat &&
                    count['R' - 'A'] <= quat &&
                    count['W' - 'A'] <= quat &&
                    count['E' - 'A'] <= quat) {
                min = tail - head + 1;
            }
        }

        return min;
    }

}
