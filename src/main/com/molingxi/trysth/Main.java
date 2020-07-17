package main.com.molingxi.trysth;

import java.math.BigInteger;
import java.util.*;


public class Main {


    public static void main(String[] args) {



        TreeMap<Integer, Integer> m = new TreeMap<>();

        m.merge(1,1, (k,v ) -> k + 1);
        m.merge(1,1, (k,v ) -> k + 1);
        m.merge(1,1, (k,v ) -> k + 1);
        m.merge(1,1, (k,v ) -> k + 1);
        m.merge(2,1, (k,v ) -> k + 1);
        m.merge(2,1, (k,v ) -> k + 1);
        m.merge(2,1, (k,v ) -> k + 1);
        m.merge(2,1, (k,v ) -> k + 1);
        m.merge(2,1, (k,v ) -> k + 1);

        ///m.forEach((k,v) -> System.out.println(k + ":" + v));

        m.compute(2,  (k, v) ->{ return v == 1 ? null: v - 1;});
        m.compute(2,  (k, v) ->{ return v == 1 ? null: v - 1;});
        m.compute(2,  (k, v) ->{ return v == 1 ? null: v - 1;});
        m.compute(2,  (k, v) ->{ return v == 1 ? null: v - 1;});
        m.compute(2,  (k, v) ->{ return v == 1 ? null: v - 1;});




        m.forEach((k,v) -> System.out.println(k + ":" + v));

//
//
//        Map<Character, Integer> m = new HashMap<>();
//
//        String s = "abcdabcccddcdc";
//
//        for (int i = 0;i < s.length();i++) {
//            m.merge(s.charAt(i), 1, (a, b) -> a + 1);
//        }
//
//
//        TreeMap<Integer, List<Character>> sorted = new TreeMap<>();
//
//        m.forEach((k, v) -> sorted.merge(v, new ArrayList<Character>(Arrays.asList(k)), (v1, v2) -> { v1.addAll(v2); return v1;} ));
//
//
//
//        int[][] x = new int[][] {{10,3},{40,20},{20,4},{20,5}};
//        Arrays.sort(x , (i, j) -> i[0] != j[0] ? i[0] - j[0] : i[1] - j[1]);
//
//        Arrays.stream(x).forEach(
//                System.out::println
//        );
    }


    static class IntPair {

        public int x, y;
        public IntPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x ^ y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof IntPair) {
                return ((IntPair)obj).x == this.x &&
                        ((IntPair)obj).y == this.y;
            }

            return false;
        }
    }

    public static void main1(String [] args) {




        TreeMap<Integer, int[]> map = new TreeMap<>();



        map.put(10, new int[] {2,3});
        map.put(40, new int[] {2,3});
        map.put(20, new int[] {2,3});
        map.put(100, new int[] {2,3});

        map.put(122, new int[] {2,3});
        map.put(112, new int[] {2,3});
        map.put(80, new int[] {2,3});
        map.put(50, new int[] {2,3});
        map.put(50, new int[] {2,3});
        map.put(20, new int[] {2,3});



        System.out.println(map.ceilingEntry(49));
        System.out.println(map.floorEntry(51));

        System.out.println(map.floorEntry(5));

        Map.Entry entry = map.floorEntry(5);

        System.out.println(entry);







        int[][] nums = new int[10][];
        for (int i = 0;i < nums.length;i++) {
            int x = (int )(Math.random() * 1000);
            nums[i] = new int[] {x , x +  (int) ( Math.random() * 10000) };
        }
        Arrays.stream(nums).forEach(
                (x) -> System.out.println(String.format("%d %d", x[0], x[1]))
        );

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);

        System.out.println("========================================================================");

        Arrays.stream(nums).forEach(
                (x) -> System.out.println(String.format("%d %d", x[0], x[1]))
        );
    }
    public static void main16(String [] args) {

        int[] nums  = new int[] { 2,1,3,4,23,12,12,3,4};

        Arrays.sort(nums);

        Arrays.stream(nums).forEach(System.out::println);
    }



    public  static void main15(String[] args) {
        ArrayList<Long> a1 = new ArrayList<>()
                , a2 = new ArrayList<>();

        a1.add(1l);
        a1.add(2l);

        a2.add(1l);
        a2.add(2l);

        System.out.println(a1.equals(a2));

        a2.add(3l);

        System.out.println(a1.equals(a2));


        for ( int i = 0;i <= 64;i++) {
            System.out.println(Long.toBinaryString(1l << i));
        }

        int [][] a = {{1,2}, {4,5}, {2,3}};

        p(a);
        Arrays.sort(a, new Comparator<int[]>(){

            @Override
            public int compare(int[] ints, int[] t1) {

                return ints[0] - t1[0];
            }
        });

       // Arrays.sort(a);
        p(a);
        int[] aaaa = new int[]{1,2,3,4};
        Map<Character, Integer> mm = new HashMap<>();

        mm.put('a', 1);

        System.out.println(mm.get('a'));


        String p = "werdsfwesd";
        Map<Character, Integer> pcount = new HashMap<>();

        for ( int i =0 ;i < p.length();i++) {
            pcount.merge(p.charAt(i), 1 , (o, v) -> o + 1);
        }

        pp(pcount);
        Map<Character, Integer> ppcount = new HashMap<>();

        ppcount.putAll(pcount);
        ppcount.put('w', 100);
        pp(ppcount);
        ppcount.putAll(pcount);
        pp(ppcount);

        System.out.println(pcount);

        BigInteger bi = BigInteger.valueOf(2);

        System.out.println(bi.pow(64).toString());

        System.out.println(10 ^ 10);

        System.out.println(Math.ceil( Math.log((double)24 / (60/ 15))));
        System.out.println(Math.log(6));
        System.out.println(log2(6));

        System.out.println(poorPigs(4, 15,15));




    }

    static int log2 (int n) {
        int result = 0 ;
        int value = 1;
        while( value < n) {
            value <<= 1;
            result ++;
        }
        return result;
    }

    static  <V, T> void pp(Map<V, T> m) {
        System.out.println("----------------------------");
        for (Map.Entry<V, T> entry : m.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("----------------------------");

    }

    static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;


        int result = 1;
        int total = times;
        while(total < buckets) {
            result ++;
            total *= times;
        }
        return result;
    }
    static void p(int[][] a) {
        for (int i = 0;i < a.length;i++ ) {
            for (int j = 0;j < a[i].length;j ++)
                System.out.print(a[i][j] + "    ");
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


    }
}
