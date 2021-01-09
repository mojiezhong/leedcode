package main.com.molingxi.i1591;

import javax.naming.ldap.StartTlsRequest;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

class Solution {

    private final int NONTVISITED = 0;
    private final int EXPLORED = 2;
    private final int VISITED = 3;
    public boolean isPrintable(int[][] targetGrid) {

        if (targetGrid == null || targetGrid.length < 1 || targetGrid[0].length < 1) {
            return true;
        }
        int[] maxX = create(-1), minX = create(Integer.MAX_VALUE), maxY = create(-1), minY = create(Integer.MAX_VALUE);

        for (int x = 0;x < targetGrid.length;x++) {
            for (int y = 0; y < targetGrid[0].length;y++) {
                int c = targetGrid[x][y];
                maxX[c] = Math.max(maxX[c], x);
                maxY[c] = Math.max(maxY[c], y);
                minX[c] = Math.min(minX[c], x);
                minY[c] = Math.min(minY[c], y);
            }
        }


        Set<Integer>[] graph = new Set[61];


        IntStream.range(1, 61).forEach(i -> graph[i] = new HashSet<>());

        for (int x = 0;x < targetGrid.length;x++) {
            for (int y = 0;y < targetGrid[0].length;y++) {
                for(int c = 1;c <= 60;c++) {
                    if (targetGrid[x][y] != c &&
                            maxX[c] >= 0 &&
                    maxX[c] >= x &&
                    maxY[c] >= y &&
                    minX[c] <= x &&
                    minY[c] <= y) {
                        graph[targetGrid[x][y]].add(c);
                    }
                }
            }
        }


        int[] visited = new int[61];

        for (int i = 1;i < 61;i++) {
            if (visited[i] == NONTVISITED) {

                LinkedList<Integer> queue = new LinkedList<>();
                queue.push(i);

                while(!queue.isEmpty()) {
                    while (!queue.isEmpty() && visited[queue.peek()] == EXPLORED) {
                        visited[ queue.pop()] = VISITED;
                    }

                    if (queue.isEmpty()) {
                        break;
                    }

                    int e = queue.peek();
                    visited[e] = EXPLORED;

                    for (int n : graph[e]) {
                        if (visited[n] == EXPLORED) {
                            return false;
                        } else if (visited[n] == NONTVISITED) {
                            queue.push(n);
                        }
                    }
                }
            }
        }

        return true;
    }

    private static int[] create(int d) {
        int[] result = new int[61];
        IntStream.range(0, 61).forEach(i -> result[i] = d);
        return result;
    }
}