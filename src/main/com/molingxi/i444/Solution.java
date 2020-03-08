package main.com.molingxi.i444;
class Solution {
//    public int findKthNumber(int n, int k) {
//        int result = 0;
//
//        if (n < 10 && k <= n) {
//            return k;
//        }
//
//        while ( k > 0) {
//
//            for ( int i = 1;i < 9;i ++) {
//                int startWithi = countStartWithX(i, n);
//                if (startWithi < k) {
//                    k = k- startWithi;
//                } else if ( k ==startWithi) {
//                    return findMaxStartWithX(n, i);
//                } else {
//                    if (k == 1) {
//                        return i;
//                    } else {
//                        int max = findMaxStartWithX(n, i);
//                        int tail = startWithXInRange(0, removeHead(max), k - 1);
//
//                        return i * pow10(log10(tail) + 1) + tail;
//                    }
//                    return startWithXInRange(i, findMaxStartWithX(n, i), k);
//                }
//            }
//        }
//    }
//
//    int findMaxStartWithX(int n, int x) {
//
//        if (n < 10) {
//            return x;
//        }
//
//        int head = getHead(n);
//
//        int digital = log10(n);
//
//        if (head > x) {
//            return x * repeatX(10, digital) + repeatX(9, digital);
//        } else if (head == x) {
//            return x * repeatX(10, digital) + n - head * repeatX(10, digital);
//        } else {
//            return x * repeatX(10, digital - 1) + repeatX(9, digital - 1);
//        }
//    }
//
//
//
//    int removeHead(int n) {
//        return n - getHead(n) * pow10(log10(n));
//    }
//
//
//
//    // x * 10^n return n;
//    int log10(int num) {
//        int result = 0;
//        while(num > 9) {
//            num /= 10;
//            result ++;
//        }
//        return result;
//    }
//
//    int repeatX(int x, int n) {
//        int result = x;
//        while (n > 1) {
//            result = result * 10 + x;
//            n--;
//        }
//        return result;
//    }
//
//    int getHead(int n) {
//        while (n >= 10) {
//            n = n / 10;
//        }
//        return n;
//    }
//
//
//    // like   5 .. 59999  or 5 ... 52312    all number start with 5.
//    int startWithXInRange( int rangeStart, int rangeEnd, int k) {
//
//        int digital = log10(rangeEnd);
//
//
//        if (k == 0) {
//            return rangeStart * count / 10 + repeatX(9, log10(count) - 1);
//        } else if (k == 1){
//            return rangeStart * count;
//        } else {
//            return rangeStart * count + findMaxStartWithX(repeatX(9, log10(count)), k);
//        }
//    }
//
//    int countStartWithX(int x, int n ) {
//        int head = getHead(n), digital = log10(n);
//
//        if (head > x) {
//            return repeatX(1, digital + 1);
//        } else if (head == x) {
//            return repeatX(1, digital)  + 1 + n - head*power10(digital);
//        } else  {
//            return repeastX(1, digital);
//        }
//    }
//
//    int power10 (int n ) {
//        int result = 1;
//        while (n >0) {
//            n --;
//            result *= 10;
//        }
//        return result;
//    }

}