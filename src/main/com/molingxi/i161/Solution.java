package main.com.molingxi.i161;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {

        int dis = 0;
        if (s.length() == t.length()) {

            for (int i = 0;i < t.length();i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (dis == 1) {
                        return false;
                    } else {
                        dis = 1;
                    }
                }
            }
        } else if (Math.abs(s.length() - t.length())  == 1 ){
            int min = Math.min(s.length(), t.length());

            String ss, ls;
            ss = s.length() > t.length() ? t : s;
            ls = s.length() > t.length() ? s : t;
            for (int i = 0;i < min;i++) {
                if (ss.charAt(i + dis) != ls.charAt(i)) {
                    if (dis == 1) {
                        return false;
                    } else {
                        dis = 1;

                    }
                }
            }
            if (dis == 0) {
                dis = 1;
            }
        } else {
            return false;
        }


        return dis == 1;
    }
}
