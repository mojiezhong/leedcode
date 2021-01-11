package main.com.molingxi.i1579;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static Map<String, Integer> priorityMap = new HashMap<>();

    static {
        priorityMap.put("++", 1);
        priorityMap.put("+-", 1);
        priorityMap.put("-+", 1);
        priorityMap.put("--", 1);
        priorityMap.put("**", 1);
        priorityMap.put("*/", 1);
        priorityMap.put("/*", 1);
        priorityMap.put("//", 1);
        priorityMap.put("/+", 1);
        priorityMap.put("/-", 1);
        priorityMap.put("*+", 1);
        priorityMap.put("*=", 1);
        priorityMap.put("+)", 1);
        priorityMap.put("-)", 1);
        priorityMap.put("*)", 1);
        priorityMap.put("/)", 1);
        priorityMap.put("))", 1);
        priorityMap.put("+*", -1);
        priorityMap.put("-*", -1);
        priorityMap.put("+/", -1);
        priorityMap.put("-/", -1);
        priorityMap.put("+(", -1);
        priorityMap.put("-(", -1);
        priorityMap.put("*(", -1);

        priorityMap.put("/(", -1);
        priorityMap.put("(/", -1);
        priorityMap.put("(*", -1);
        priorityMap.put("(+", -1);
        priorityMap.put("(-", -1);
        priorityMap.put("((", -1);
        priorityMap.put("()", 0);
    }

    Stack<Character> operators = new Stack<>() ;
    Stack<Node> values = new Stack<>();
    public Node expTree(String s) {
        for(int i = 0;i < s.length();i++) {
            if (isNumber(s.charAt(i))) {
                values.push(new Node(s.charAt(i)));
            } else if (s.charAt(i) != ' ') {

                while (! operators.isEmpty() && compare(operators.peek(), s.charAt(i)) > 0) {
                    Character cc = operators.pop();

                    Node n1 , n2;
                    n1 = values.pop();
                    n2 = values.pop();
                    values.push(new Node(cc, n2, n1));
                }

                if (!operators.isEmpty() && compare(operators.peek(), s.charAt(i)) == 0) {
                    operators.pop();
                } else {
                    operators.push(s.charAt(i));
                }
            }
        }


        while (!operators.isEmpty()) {
            Character c = operators.pop();
            Node n1 = values.pop(), n2 = values.pop() ;
            values.push(new Node(c, n2 , n1));
        }

        return values.pop();
    }

    int compare(char a, char b) {
        return priorityMap.getOrDefault("" + a + b, 1);
    }

    boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }


      class Node {
          char val;
          Node left;
          Node right;
          Node() {this.val = ' ';}
          Node(char val) { this.val = val; }
          Node(char val, Node left, Node right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}