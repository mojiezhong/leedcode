package main.com.molingxi.i1349;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
//`
//    Map<ArrayList<Long>, Integer> cache = new HashMap<>();
//
//    private static final char TAKE = 'o';
//    private static final char VAC = '.';
//    public int maxStudents(char[][] seats) {
//
//        if (seats == null || seats.length == 0 || seats[0].length == 0) return 0;
//        return maxRemain(seats, 0 , 0);
//
//    }
//
//    int maxRemain(char[][] seats, int x, int y) {
//
//
//        if (x >= seats.length) {
//            return 0;
//        }
//
//        int nextX = -1, nextY = -1;
//
//        for (int xi = x ; xi < seats.length; xi ++)  {
//            for (int yi =( xi == x) ? y  : 0; yi < seats[xi].length;yi ++) {
//                if (seats[xi][yi] == VAC) {
//                    nextX = xi;
//                    nextY = yi;
//                    break;
//                }
//            }
//            if (nextX != -1) {
//                break;
//            }
//        }
//
//        if (nextX <= -1) {
//            return 0;
//        }
//
//        ArrayList<Long> state = createState(seats, x, y);
//
//        Integer result = cache.get(state);
//        if (result ==null) {
//
//
//            int n = 0;
//            if (isAvailable(seats, nextX, nextY)) {
//                seats[nextX][nextY] = TAKE;
//                n = 1 + maxRemain(seats, nextY >= seats[nextX].length - 1? nextX + 1: nextX, nextY < seats[nextX].length - 1? nextY + 1, 0 );
//                seats[nextX][nextY] = VAC;
//            }
//
//            int n2 =  maxRemain(seats, nextY >= seats[nextX].length - 1? nextX + 1: nextX, nextY < seats[nextX].length - 1? nextY + 1, 0 );
//
//            result = Integer.max(n1, n2);
//
//            cache.put(state, result);
//
//
//
//            return result;
//        } else {
//            return result.intValue();
//        }
//    }
//
//
//
//
//
//    boolean isAvailable(int[][] seats, int x, int y) {
//        if (y >= 1) {
//            if (x >= 0) {
//                if (seats[x - 1][y - 1] == TAKE) {
//                    return false;
//                }
//            }
//
//            if (seats[x][y - 1] == TAKE) {
//                return false;
//            }
//        }
//
//        if ( y < seats[x].length - 1) {
//            if (x >= 0 && seats[x -1][y + 1] == TAKE) {
//                return false;
//            }
//
//            if (seats[x][y + 1] == TAKE) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//    ArrayList<Long> createState(char[][] seats, int x, int y) {
//        int count = 0;
//        long state = 0;
//        ArrayList<Long> result = ArrayList<>();
//
//        if (x > 0) {
//
//
//            for (int i = y ==0 ? 0 : y -1; i < seats[x].length;i++ ) {
//
//                state |= ((seats[x - 1][i] == 'o'? 1l : 0l)<< count);
//                if (count == 63) {
//                    count = 0;
//                    result.add(state);
//                    state = 0;
//                } else {
//                    count ++;
//                }
//            }
//        }
//
//        for ( int i = 0;i < y ; i ++ ){
//            state |= ((seats[x][i] == 'o' ? 1l : 0l) << count);
//            if (count == 63) {
//                result.add(state);
//                count = 0;
//                state = 0;
//            } else {
//                count ++;
//            }
//        }
//
//        result.add(state);
//        result.add((((long)x) << 32)  | y);
//        return result;
//    }`
}



//
//
//class Solution {
//
//    Map<ArrayList<Long>, Integer> cache = new HashMap<>();
//
//    private static final char TAKE = 'o';
//    private static final char VAC = '.';
//    public int maxStudents(char[][] seats) {
//
//        if (seats == null || seats.length == 0 || seats[0].length == 0) return 0;
//        return maxRemain(seats, 0 , 0);
//
//    }
//
//    int maxRemain(char[][] seats, int x, int y) {
//
//
//        if (x >= seats.length) {
//            return 0;
//        }
//
//        int nextX = -1, nextY = -1;
//
//        for (int xi = x ; xi < seats.length; xi ++)  {
//            for (int yi =( xi == x) ? y  : 0; yi < seats[xi].length;yi ++) {
//                if (seats[xi][yi] == VAC) {
//                    nextX = xi;
//                    nextY = yi;
//                    break;
//                }
//            }
//            if (nextX != -1) {
//                break;
//            }
//        }
//
//        if (nextX <= -1) {
//            return 0;
//        }
//
//        ArrayList<Long> state = createState(seats, x, y);
//
//        Integer result = cache.get(state);
//        if (result ==null) {
//
//
//            int n = 0;
//            if (isAvailable(seats, nextX, nextY)) {
//                seats[nextX][nextY] = TAKE;
//                n = 1 + maxRemain(seats, nextY >= seats[nextX].length - 1? nextX + 1: nextX, nextY < seats[nextX].length - 1? nextY + 1, 0 );
//                seats[nextX][nextY] = VAC;
//            }
//
//            int n2 =  maxRemain(seats, nextY >= seats[nextX].length - 1? nextX + 1: nextX, nextY < seats[nextX].length - 1? nextY + 1, 0 );
//
//            result = Integer.max(n1, n2);
//
//            cache.put(state, result);
//
//
//
//            return result;
//        } else {
//            return result.intValue();
//        }
//    }
//
//
//
//
//
//    boolean isAvailable(int[][] seats, int x, int y) {
//        if (y >= 1) {
//            if (x >= 0) {
//                if (seats[x - 1][y - 1] == TAKE) {
//                    return false;
//                }
//            }
//
//            if (seats[x][y - 1] == TAKE) {
//                return false;
//            }
//        }
//
//        if ( y < seats[x].length - 1) {
//            if (x >= 0 && seats[x -1][y + 1] == TAKE) {
//                return false;
//            }
//
//            if (seats[x][y + 1] == TAKE) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//
//    ArrayList<Long> createState(char[][] seats, int x, int y) {
//        int count = 0;
//        long state = 0;
//        ArrayList<Long> result = ArrayList<>();
//
//        if (x > 0) {
//
//
//            for (int i = y ==0 ? 0 : y -1; i < seats[x].length;i++ ) {
//
//                state |= ((seats[x - 1][i] == 'o'? 1l : 0l)<< count);
//                if (count == 63) {
//                    count = 0;
//                    result.add(state);
//                    state = 0;
//                } else {
//                    count ++;
//                }
//            }
//        }
//
//        for ( int i = 0;i < y ; i ++ ){
//            state |= ((seats[x][i] == 'o' ? 1l : 0l) << count);
//            if (count == 63) {
//                result.add(state);
//                count = 0;
//                state = 0;
//            } else {
//                count ++;
//            }
//        }
//
//        result.add(state);
//        result.add((((long)x) << 32)  | y);
//        return result;
//    }
//}