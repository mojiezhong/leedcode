package main.com.molingxi.i546;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    int[][][] cache = new int[100][100][100];
    int[] length ;
    int[] color ;
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }

        length = new int[boxes.length];
        color = new int[boxes.length];


        int start = 0;
        int index = 0;
        for (int i = 0;i < boxes.length;i++) {
            if (boxes[i] != boxes[start] ) {
                length[index] = i - start;
                color[index] = boxes[start];
                start = i;
                index++;
            }

            if (i == boxes.length - 1) {
                length[index] = i - start + 1;
                color[index] = boxes[i];
            }
        }
        return remmoveBoxesInternl(0, index, 0) ;
    }

    private  int remmoveBoxesInternl(int start, int end, int left) {

        int x = left;
        if (end < start) {
            return left * left;
        }

        if (cache[start][end][left] > 0) {
            return cache[start][end][left];
        }

        left += length [start];
        int max = left * left + remmoveBoxesInternl(start + 1, end, 0) ;

        for ( int i = start + 1;i <= end;i++) {
            if (color[i] == color[start]) {
                max = Math.max(max, remmoveBoxesInternl(start + 1, i - 1, 0) + remmoveBoxesInternl(i, end, left));
            }
        }


        cache[start][end][x] = max;

        return max;
    }


}

//
//    int[][][] cache = new int[100][100][10000];
//    int[] length ;
//    int[] color ;
//
//    public int removeBoxes(int[] boxes) {
//
//        if (boxes == null || boxes.length == 0) {
//            return 0;
//        }
//
//        length = new int[boxes.length];
//        color = new int[boxes.length];
//
//        int pre = boxes[0];
//        int start = 0;
//        int index = 0;
//        for (int i = 0;i < boxes.length;i++) {
//            if (boxes[i] != pre ) {
//                length[index] = i - start;
//                color[index] = pre;
//                start = i;
//                pre = boxes[i];
//                index++;
//            }
//
//            if (i == boxes.length - 1) {
//                length[index] = i - start + 1;
//                color[index] = pre;
//            }
//        }
//
//        return removeBoxesInternal(0, index, 0, 0);
//    }
//
//
//    private int removeBoxesInternal (int s, int e, int rl, int c) {
//
//        if (e < s ) {
//            return rl * rl;
//        }
//
//        int cl = c * 100 + rl;
//        if (cache[s][e][cl] > 0) {
//            return cache[s][e][cl];
//        }
//
//        if (s == e) {
//            if (color[s] == c) {
//                cache[s][e][cl] = (rl + length[s]) * (rl + length[s]);
//            } else {
//                cache[s][e][cl] = rl * rl + length[s] * length[s];
//            }
//
//            return cache[s][e][cl];
//        }
//
//        int max = length[s] * length[s] + removeBoxesInternal(s + 1, e, rl, c);
//
//        for (int i = s + 1;i < e - 1; i++) {
//
//            max = Math.max(max,
//                   Math.max(length[i] * length[i] + removeBoxesInternal(s, i - 1, 0, 0) + removeBoxesInternal(i + 1, e, rl, c) ,
//                   length[i] * length[i] + removeBoxesInternal(s, i - 1, length[i + 1], color[i + 1]) + removeBoxesInternal(i + 2, e, rl, c) ));
//
//        }
//
//        // e - 1
//        if (color[e] == c) {
//            max = Math.max(max, length[e-1] * length[e - 1] +  removeBoxesInternal(s, e - 2, length[e] + rl, c));
//        } else {
//            max = Math.max(max, length[e-1] * length[e - 1] +  removeBoxesInternal(s, e-2, length[e], color[e]) + rl * rl);
//        }
//
//        if (color[e] == c) {
//            max = Math.max(max, (length[e] + rl) * (length[e] + rl) + removeBoxesInternal(s, e - 1, 0 , 0));
//        } else {
//            max = Math.max(max, rl * rl + removeBoxesInternal(s, e - 1, rl, c));
//        }
//
//
//
//        cache[s][e][cl] = max;
//
//        return max;
//    }
//}

//
//
//    int[][][] cache = new int[100][100][100];
//    int[] length ;
//    int[] color ;
//
//    public int removeBoxes(int[] boxes) {
//
//        if (boxes == null || boxes.length == 0) {
//            return 0;
//        }
//
//        length = new int[boxes.length];
//        color = new int[boxes.length];
//
//        int pre = boxes[0];
//        int start = 0;
//        int index = 0;
//        for (int i = 0;i < boxes.length;i++) {
//            if (boxes[i] != pre ) {
//                length[index] = i - start;
//                color[index] = pre;
//                start = i;
//                pre = boxes[i];
//                index++;
//            }
//
//            if (i == boxes.length - 1) {
//                length[index] = i - start + 1;
//                color[index] = pre;
//            }
//        }
//
//        return removeBoxesInternal(0, index, 0);
//    }
//
//
//    private int removeBoxesInternal (int s, int e, int right) {
//
//        if (e < s ) {
//            return 0;
//        }
//
//        if (cache[s][e][right] > 0) {
//            return cache[s][e][right];
//        }
//
//        if (s == e) {
//            cache[s][e][right] = (right + length[s]) * (right + length[s]);
//            return cache[s][e][right];
//        }
//
//        int max = 0;
//        for (int i = s;i <= e ;i ++) {
//            for (int j = s; j <= i; j++) {
//                if (j == s && i == e) {
//                    continue;
//                }
//
//                if (j == s) {
//                    max = Math.max(max, removeBoxesInternal(s, i, 0) + removeBoxesInternal(i + 1, e, right));
//                } else if (i == e) {
//                    max = Math.max(max, removeBoxesInternal(s, j - 1 , 0) + removeBoxesInternal(j, i, right));
//                } else {
//                    if (i == e - 1 && color[j - 1] == color[e]) {
//                        max = Math.max(max, removeBoxesInternal(s, j - 1, right + length[e]) + removeBoxesInternal(j, i, 0));
//                    } else if (color[j - 1] == color[i + 1]) {
//                        max = Math.max(max, removeBoxesInternal(s, j - 1, length[i + 1]) + removeBoxesInternal(j, i, 0) + removeBoxesInternal(i + 2, e, right));
//                    }else {
//                        max = Math.max(max, removeBoxesInternal(s, j- 1, 0) + removeBoxesInternal(j, i, 0) + removeBoxesInternal(i + 1, e, right));
//
//                    }
//                }
//            }
//        }
//
//        cache[s][e][right] = max;
//
//        return max;
//    }
//
//
//
//}

//
//    Map<ArrayList<Integer>, Integer> cache;

//
//    public int removeBoxes(int[] boxes) {
//        cache = new HashMap<>();
//
//
//        ArrayList<Integer> se = new ArrayList<>();
//
//        for(int i = 0;i < boxes.length;i++) {
//            se.add(boxes[i]);
//        }
//        return removeBoxesInternal(se);
//    }
//
//
//    public int removeBoxesInternal(ArrayList<Integer> boxes) {
//
//        if (boxes == null || boxes.isEmpty()) {
//            return 0;
//        } else if (boxes.size() == 1) {
//            return 1;
//        }
//
//
//        if (cache.containsKey(boxes)) {
//            return cache.get(boxes);
//        } else {
//            int max = Integer.MIN_VALUE;
//            ArrayList<Integer> sub = new ArrayList<>();
//            for (int s = 0;s < boxes.size();s++) {
//                sub.clear();
//                if (s > 0) {
//                    sub.addAll(boxes.subList(0, s));
//                }
//                int c = boxes.get(s);
//                for (int l = 1;l < boxes.size() - s;l++) {
//                    if (c != boxes.get(s + l)) {
//                        sub.addAll(boxes.subList(s + l, boxes.size()));
//
//                        max = Math.max(max, l * l + removeBoxesInternal(sub));
//                        s = s + l - 1;
//                        break;
//                    } else if (s + l == boxes.size() - 1) {
//                        max = Math.max(max, (l + 1) * (l + 1) + removeBoxesInternal(sub));
//                        s = s + l + 1;
//                        break;
//                    }
//                }
//            }
//            cache.put(new ArrayList<>(boxes), max);
//            return max;
//
//        }
//    }


    /**
     * class Solution {
     *
     *
     *
     *     int[][][] cache = new int[100][100][100];
     *     int[] boxes;
     *
     *     public int removeBoxes(int[] boxes) {
     *
     *
     *         this.boxes = boxes;
     *         return removeBoxesInternal(0, boxes.length, 0);
     *     }
     *
     *
     *     public int removeBoxesInternal(int s, int e, int l) {
     *         if (s == e) {
     *             return 0;
     *         } else if (cache[s][e][l] > 0 ){
     *
     *         } else {
     *             int max = -1;
     *             int ei = e - 1;
     *
     *             int c = boxes[ei];
     *             while (ei >= s && boxes[ei] == c) {
     *                 l ++;
     *                 ei--;
     *             }
     *
     *             if (ei < s) {
     *                 max = l * l;
     *             } else {
     *
     *                 while (ei >= s)
     *                 int cc = boxes[ei];
     *                 int ll = 1;
     *                 ei --;
     *                 while (ei >= 0 && boxes[ei] == cc) {
     *                     ll ++;
     *                     ei --;
     *                 }
     *
     *
     *             }
     *         }
     *
     *      return cache[s][e][l];
     *     }
     * }
     */
//}
