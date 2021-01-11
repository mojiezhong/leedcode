package main.com.molingxi.i1579;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void expTree() {

        Solution.Node node = new Solution().expTree("(1+2)*3");
        print(node);
    }

    void print(Solution.Node n) {
        if (n == null) {
            return;
        }

        print(n.left);
        System.out.print (" " + n.val + " ");
        print(n.right);
    }
}