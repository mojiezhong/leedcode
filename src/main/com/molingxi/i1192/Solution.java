package main.com.molingxi.i1192;
//https://leetcode.com/problems/critical-connections-in-a-network/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    class NodesSet{
        Set<Integer> nodes = new HashSet<>();

        List<List<Integer>> connections = new ArrayList<>();

        public NodesSet (int n) {
            nodes.add(n);
        }
    }



    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, NodesSet> graph = new HashMap<>();

        for (List<Integer> connection: connections) {
            final int min = Math.min(connection.get(0), connection.get(1));
            final int max = Math.max(connection.get(0), connection.get(1));

            NodesSet nodesSet = graph.computeIfAbsent(min, a ->  new NodesSet(min));

            if (nodesSet.nodes.contains(max)) {
                // ignore
            } else {

                if (!graph.containsKey(max)) {
                    NodesSet maxNode = graph.computeIfAbsent(max, a -> new NodesSet(max));
                    maxNode.connections.add(Arrays.asList(max, min));
                    nodesSet.connections.add(Arrays.asList(min, max));
                } else {
                    NodesSet node = mergePath(graph, nodesSet, max, min);

                    if (node == null) {
                        //can't, create critical path
                        NodesSet maxNode = graph.computeIfAbsent(max, a -> new NodesSet(max));
                        maxNode.connections.add(Arrays.asList(max, min));
                        nodesSet.connections.add(Arrays.asList(min, max));
                    } else {
                        node.nodes.stream().forEach(
                                index -> graph.put(index, node)
                        );
                    }
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0;i < n;i++) {
            if (!visited.contains(i)) {
                NodesSet node = graph.get(i);

                for(List<Integer> connection : node.connections) {
                    if (node.nodes.contains(Math.min(connection.get(0), connection.get(1)))) {
                        result.add(connection);
                    }
                }

                visited.addAll(node.nodes);
            }
        }

        return result;
    }

    NodesSet mergePath(HashMap<Integer, NodesSet> graph, NodesSet nodesSet, int target, int parent) {
        if (nodesSet == null) {
            return null;
        }

        if (nodesSet.nodes.contains(target)) {
            return nodesSet;
        } else {

            for (int i = 0;i < nodesSet.connections.size();i++) {


                List<Integer> connection = nodesSet.connections.get(i);
                if (connection.get(1) != parent) {
                    NodesSet subMerged = mergePath(graph, graph.get(connection.get(1)), target, connection.get(0));
                    if (subMerged != null) {

                        nodesSet.connections.remove(i);
                        for (List<Integer> c : subMerged.connections) {
                            if (!nodesSet.nodes.contains(c.get(1))) {
                                nodesSet.connections.add(c);
                            }
                        }

                        nodesSet.nodes.addAll(subMerged.nodes);

                        return nodesSet;
                    }
                }
            }
        }
        return null;
    }
}



//class Solution {
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//        int graph[][] = new int[n][n];
//        for ( int i = 0;i < n;i++) {
//            graph[i][i] = 1;
//        }
//
//        for (List<Integer> edge: connections) {
//            int x = edge.get(0);
//            int y = edge.get(1);
//            if (graph[x][y] == 0) {
//                for (int j = 0;j < n; j++) {
//                    if (graph[j][x] != 0) {
//                        for (int k = 0;k < n;k++) {
//                            if (graph[y][k] != 0){
//                                graph[j][k] = 1;
//                                graph[k][j] = 1;
//                            }
//                        }
//                    }
//                }
//
//                graph[x][y] = -1;
//                graph[y][x] = -1;
//
//            } else {
//                for (int j = 0;j < n; j++) {
//                    if (graph[j][x] != 0) {
//
//                        for (int k = 0;k < n;k++) {
//                            if (graph[k][y] != 0 && graph[j][k] == -1) {
//                                graph[j][k] = 1;
//                                graph[k][j] = 1;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//
//        ArrayList<List<Integer>> result = new ArrayList<>();
//        for ( int i = 0;i < n;i++) {
//            for (int j = 0;j < i;j++) {
//                if (graph[i][j] == -1) {
//                    result.add(Arrays.asList(new Integer[]{i, j}));
//                }
//            }
//        }
//
//        return result;
//    }
//}


/**
 * class Solution {
 *     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
 *         int graph[][] = new int[n][n];
 *         int path[] = new int[n];
 *         for ( int i = 0;i < n;i++) {
 *             graph[i][i] = 1;
 *         }
 *
 *         for (List<Integer> edge: connections) {
 *             int x = edge.get(0);
 *             int y = edge.get(1);
 *             if (graph[x][y] == 0) {
 *                 for (int j = 0;j < n; j++) {
 *                     if (graph[j][x] != 0) {
 *                         for (int k = 0;k < n;k++) {
 *                             if (graph[y][k] != 0){
 *                                 graph[j][k] = 1;
 *                                 graph[k][j] = 1;
 *                             }
 *                         }
 *                     }
 *                 }
 *
 *                 graph[x][y] = -1;
 *                 graph[y][x] = -1;
 *
 *             } else if (graph[x][y] == 1){
 *                 int cur = 0;
 *                 path[0] = x;
 *
 *                 int next = -1;
 *
 *                 while(cur >= 0) {
 *                     next++;
 *                     while(next < n && graph[path[cur]][next] == 0) {
 *                         next++;
 *                     }
 *                     if (next == n) {
 *                         next = path[cur];
 *                         cur--;
 *                     } else {
 *                         cur ++;
 *                         path[cur] = next;
 *                         if (next == n) {
 *                             brea;
 *                         } else {
 *                             next = -1;
 *                         }
 *                     }
 *                 }
 *
 *                 for (int i = 0;i < cur;i++){
 *                     graph[path[i]][path[i+1]] = 1;
 *                     graph[path[i + 1]][path[i]] = 1;
 *                 }
 *             }
 *         }
 *
 *
 *         ArrayList<List<Integer>> result = new ArrayList<>();
 *         for ( int i = 0;i < n;i++) {
 *             for (int j = 0;j < i;j++) {
 *                 if (graph[i][j] == -1) {
 *                     result.add(Arrays.asList(new Integer[]{i, j}));
 *                 }
 *             }
 *         }
 *
 *         return result;
 *     }
 * }
 */
