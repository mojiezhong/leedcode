package main.com.molingxi.i1235;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Solution {


    public static void main(String[] args) {
        SortedMap<Integer, Object> map = new TreeMap<>();


        map.put(1, "test");
        map.put(5, "5");
        map.put(3, "3");

        Integer[] a = new Integer[] {1,3,2,4,3,5};

        Arrays.sort(a, (a1,b1) -> b1-a1);

        Stream.of(a).forEach(System.out::println);


        System.out.println(new Solution().jobScheduling(new int[] {1,2,3,3}, new int[] {3,4,5,6}, new int[]{50,10,40,70}));

    }

    class Job{
        public int start, end;
        public int profit;

        public Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }
    }

    class AggJob{
        public int end;
        public ArrayList<int[]> startProfits = new ArrayList<>();

        public AggJob(int e) {
            end  = e;
        }
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job[] jobs = new Job[startTime.length];

        for (int i = 0;i <startTime.length;i++ ) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a, b) -> a.end - b.end);


        ArrayList<AggJob> mergedJobs = new ArrayList<>();

        AggJob cur = new AggJob(jobs[0].end);
        cur.startProfits.add(new int[]{jobs[0].start, jobs[0].profit});
        mergedJobs.add(cur);
        for (int i = 1;i < jobs.length;i++) {
            if (cur.end != jobs[i].end) {
                cur = new AggJob(jobs[i].end);
                mergedJobs.add(cur);
            }
            cur.startProfits.add(new int[] {jobs[i].start, jobs[i].profit});
        }




        int[] maxProfit = new int[mergedJobs.size()];

        int max = Integer.MIN_VALUE;

        for (int i = 0;i < mergedJobs.size();i++) {
            AggJob job = mergedJobs.get(i);

            for (int j = 0;j < job.startProfits.size();j++) {
                int preMax = 0;
                int[] sp = job.startProfits.get(j);
                if (i > 0 && mergedJobs.get(0).end <= sp[0]) {
                    int s = 0;
                    int e = i - 1;
                    if (mergedJobs.get(e).end <= sp[0]) {
                        s = e;
                    }


                    while(e > s + 1) {
                        int m = (s + e) / 2;

                        if (mergedJobs.get(m).end > sp[0] ) {
                            e = m;
                        } else if (mergedJobs.get(m).end < sp[0] ) {
                            s = m;
                        } else {
                            s = m;
                            e = m;
                        }
                    }


                    preMax = maxProfit[s];
                }

                int curProfit = preMax + sp[1];

                if (curProfit > max) {
                    max = curProfit;
                }
            }

            maxProfit[i] = max;
        }

        return max;

    }
}
