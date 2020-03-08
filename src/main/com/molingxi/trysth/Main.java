package main.com.molingxi.trysth;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String [] args) {

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
