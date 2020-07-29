package main.com.molingxi.i1245;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        Object o = new ArrayList[100];
        Object[] a1 = new Integer[] {1,2,3,4};
        a1[0] = "abc";

        System.out.println(a1[0]);
    }


    int  max = 0;
    ArrayList<Integer>[] nodes;
    public int treeDiameter(int[][] edges) {
        max = 0;
        nodes = new ArrayList[edges.length + 1];

        for (int i = 0;i < edges.length;i++) {
            if (nodes[edges[i][0]] == null) {
                nodes[edges[i][0]] = new ArrayList<Integer>();
            }

            nodes[edges[i][0]].add(edges[i][1]);

            if (nodes[edges[i][1]] == null) {
                nodes[edges[i][1]] = new ArrayList<Integer> ();
            }

            nodes[edges[i][1]].add(edges[i][0]);
        }
        maxBranchDepth(edges[0][0], -1);

        return max;
    }

    private int maxBranchDepth(int point, int parent) {
        int m1 = 0, m2 = 0;

        for (int n : nodes[point]) {

            if (n != parent) {
                int v = maxBranchDepth(n, point) + 1;
                if (v > m2) {
                    m2 = v;
                }

                if (m2 > m1) {
                    int t = m2;
                    m2 = m1;
                    m1 = t;
                }
            }
        }
        int maxPath = m1 + m2;

        max = maxPath > max ? maxPath: max;

        return m1;
    }
}
