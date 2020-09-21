package main.com.molingxi.i336;

import java.util.*;

class Solution {
    class Node {
        public Map<Character, Node> children;

        public int index;

        public Node(int i) {
            index = i;
            children = new HashMap<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node(-1);
        List<List<Integer>> result = new ArrayList<>();

        // Build trie
        for (int i = 0; i < words.length; i++) {
            Node c = root;
            if (words[i].length() == 0) {
                root.index = i;
            } else {
                for (int j = 0; j < words[i].length(); j++) {
                    c = c.children.computeIfAbsent(words[i].charAt(j),
                            (ch) -> new Node(-1));
                    if (j == words[i].length() - 1) {
                        c.index = i;
                    }
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            Node c = root;

            if (root.index == i) {
                continue;
            }

            if (root.index >= 0 && isP(words[i], 0, words[i].length() -1)) {
                result.add(Arrays.asList(root.index , i));
                result.add(Arrays.asList(i , root.index));
            }

            if (words[i].length() > 0){
                for (int j = words[i].length() - 1; j >= 0; j--) {

                    c = c.children.get(words[i].charAt(j));

                    if (c == null) {
                        break;
                    } else if (c.index >= 0 && c.index != i && isP(words[i], 0, j - 1)) {
                        result.add(Arrays.asList(c.index, i));
                    }
                }


                if (c != null) {
                    char[] path = new char[10000];
                    List<Integer> suPa = new ArrayList<>();
                    findAllP(c.children, path, -1, suPa);
                    final int last = i;
                    suPa.stream().forEach(first -> result.add(Arrays.asList(first, last)));
                }
            }
        }
        return result;
    }

    void findAllP(Map<Character, Node> children, char[] path, int end, List<Integer> para) {
        end++;
        for (Map.Entry<Character, Node> entry : children.entrySet()) {

            Node node = entry.getValue();
            path[end] = entry.getKey();
            if (node.index >= 0) {
                int s = 0;
                int e = end;
                while (s < e) {
                    if (path[s] != path[e]) {
                        break;
                    }
                    s++;
                    e--;
                }

                if (s >= e) {
                    // find
                    para.add(node.index);
                }
            }
            findAllP(node.children, path, end, para);

        }
        end--;
    }

    boolean isP(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }

        return true;
    }

}