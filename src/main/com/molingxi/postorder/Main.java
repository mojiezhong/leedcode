package main.com.molingxi.postorder;


import java.util.Stack;

public class Main {


    static class Node {
        public int val;
        public Node left, right;
        public Node(int _val) {
            val = _val;
        }

        public boolean visited;
    }
    public static void main(String[] args) {
        System.out.println("Do it");

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node( 3);
        root.left.right = new Node(4);

        root.right.right = new Node(5);

        ptRecursive(root);
        pt(root);
    }

    static void ptRecursive(Node root) {
        if (root == null) return;

        ptRecursive(root.left);
        ptRecursive(root.right);
        System.out.print(root.val + "   ");
    }

    static void pt(Node root) {
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.empty()) {
            Node node = stack.pop();
            node.visited = true;
            if (! isVisisted(node.left) ) {
                stack.push(node);
                stack.push(node.left);

            } else if (! isVisisted(node.right)){
                stack.push(node);
                stack.push(node.right);
            } else {
                System.out.print(node.val + "  ");
            }
        }
    }

    static boolean isVisisted(Node node ) {
        return node == null || node.visited;
    }
}
