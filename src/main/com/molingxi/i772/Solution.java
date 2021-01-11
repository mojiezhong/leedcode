package main.com.molingxi.i772;

import java.awt.*;
import java.util.ArrayList;
import java.util.OptionalInt;

public class Solution {


    int cur;
    ArrayList<String> tokens;


    public int calculate(String s) {
        cur = 0;
        tokens = new ArrayList<>();
        tokenize(s);
        return (int) a();
    }

    private long a() {


        return a1(m());

    }

    private long a1(long m) {
        if (cur >= tokens.size()) {
            return m;
        }

        if (tokens.get(cur).equals("+")) {
            cur++;
            return a1(m + m());
        } else if (tokens.get(cur).equals("-")) {
            cur++;
            return a1(m - m());
        } else {
            return m;
        }
    }

    private long m() {
        return m1(t());
    }

    private long m1(long t){
        if (cur >= tokens.size()) {
            return t;
        }
        if (tokens.get(cur).equals("*")) {
            cur++;
            return m1(t * t());
        } else if (tokens.get(cur).equals("/")) {
            cur++;
            return m1(t / t());
        } else {
            return t;
        }
    }

//    private int a() {
//        int m = m();
//        if (cur < tokens.size() && tokens.get(cur ).equals("+")) {
//            cur++;
//            return m + a();
//        } else if (cur < tokens.size() && tokens.get(cur ).equals("-")) {
//            cur++;
//            return m - a();
//        } else {
//            return m;
//        }
//    }
//
//    private int m() {
//
//            int t = t();
//            if (cur < tokens.size() &&  tokens.get(cur).equals("*")){
//                cur++;
//                return t * m();
//            } else if (cur < tokens.size() &&  tokens.get(cur).equals("/")) {
//                cur++;
//                return t / m();
//            } else {
//                return t;
//            }
//
//    }

    private long t() {
        long result;
        if (tokens.get(cur).equals("(")) {
            cur++;
            result = a();
            cur ++;
        } else {
            result = Long.parseLong(tokens.get(cur));
            cur++;
        }
        return result;
    }

    void tokenize(String s) {
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ' ') {

            } else if (isNumber(s.charAt(i)) ) {
                int j = i + 1;
                for (;j < s.length() && isNumber(s.charAt(j)); j++);
                tokens.add(s.substring(i, j));
                i = j - 1;
            } else {
                tokens.add(s.substring(i, i+1));
            }
        }
    }

    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}
