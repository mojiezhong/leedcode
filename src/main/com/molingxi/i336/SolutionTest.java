package main.com.molingxi.i336;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1() {

        String[][] cases = new String[][] {
                new String[] {"a",""},
                new String[] {"bat","tab","cat"},
                new String[] {"abcd","dcba","lls","s","sssll"}
        };

        for (int i = 0;i < cases.length;i++) {
            new Solution().palindromePairs(cases[i]);
        }



    }
}