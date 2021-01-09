package main.com.molingxi.i936;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void movesToStamp() {

//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(4);
//
//        for (int i = 0 ;i < a.size();i++) {
//            System.out.println(a.get(i));
//        }
//        Assertions.assertTrue(new Solution().movesToStamp("abc", "abcbc").length == 2);

        int[] r = new Solution().movesToStamp("abc", "abcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabcabcbcabaabbccabc");
        r = new Solution().movesToStamp("abc", "abcbc");
        r = new Solution().movesToStamp("abc", "abccbabc");


        System.out.println(r);
    }
}