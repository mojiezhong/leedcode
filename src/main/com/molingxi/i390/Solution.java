package main.com.molingxi.i390;




   public class Solution {

       public static void main(String [] args) {
           System.out.println(lastRemaining(9));
       }

       public static int lastRemaining(int n) {

           int start = 1;
           int end = n;
           int step = 2;
           boolean asc = true;
           while (end > start) {
               if (asc) {
                   if ((end - start) % step == 0) {
                       end = end - step / 2;
                   }

                   start = start + step / 2;


               } else {
                   if ((end - start) % step == 0) {
                       start = start + step / 2;
                   }

                   end = end - step / 2;

               }

               step *= 2;
               asc = !asc;
           }

           return end;
       }

    }

