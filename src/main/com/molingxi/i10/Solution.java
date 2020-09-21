package main.com.molingxi.i10;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean isMatch(String s, String p) {


        if (s == null) {
            if (p == null || p.chars().filter(c -> c != '*').findAny().isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else if (p == null) {
            return false;
        }
        return isMatchInternal(s, p, 0 , 0);
    }

    public boolean isMatchInternal(String s, String p, int ss, int sp) {

        Integer key = ss * 100000 + sp;

        Boolean  result = cache.get(key);
        if (result != null) {
            return result;
        }

        if (ss >= s.length() && sp >= p.length()) {
            result = true;
        } else if (sp >= p.length()) {
            result = false;
        } else if (p.charAt(sp) == '*') {
            while ( sp < p.length() && p.charAt(sp) == '*') {
                sp++;
            }
            if (sp >= p.length()) {
                result = true;
            } else {
                while(ss < s.length() && ! isMatchInternal(s, p, ss, sp)) {
                    ss ++;
                }
                if (ss >= s.length()) {
                    result = false;
                } else {
                    result = true;
                }
            }
        } else if (p.charAt(sp) == s.charAt(ss) || p.charAt(sp) == '.') {
            result = isMatchInternal(s, p, sp+1, ss+1);
        }

        cache.put(key, result);
        return result;
    }
}
