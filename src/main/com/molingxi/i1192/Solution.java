package main.com.molingxi.i1192;
//https://leetcode.com/problems/critical-connections-in-a-network/
class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int graph[][] = new int[n][n];
        for ( int i = 0;i < n;i++) {
            graph[i][i] = 1;
        }

        for (List<Integer> edge: connections) {
            int x = edge.get(0);
            int y = edge.get(1);
            if (graph[x][y] == 0) {
                for (int j = 0;j < n; j++) {
                    if (graph[j][x] != 0) {
                        for (int k = 0;k < n;k++) {
                            if (graph[y][k] != 0){
                                graph[j][k] = 1;
                                graph[k][j] = 1;
                            }
                        }
                    }
                }

                graph[x][y] = -1;
                graph[y][x] = -1;

            } else {
                for (int j = 0;j < n; j++) {
                    if (graph[j][x] != 0) {

                        for (int k = 0;k < n;k++) {
                            if (graph[k][y] != 0 && graph[j][k] == -1) {
                                graph[j][k] = 1;
                                graph[k][j] = 1;
                            }
                        }
                    }
                }
            }
        }


        ArrayList<List<Integer>> result = new ArrayList<>();
        for ( int i = 0;i < n;i++) {
            for (int j = 0;j < i;j++) {
                if (graph[i][j] == -1) {
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }

        return result;
    }
}
