package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1781_컵라면_G2_그리디 {
    static class Problem implements Comparable<Problem> {
        int id;
        int deadline;
        int cnt;
        public Problem(int id, int deadline, int cnt) {
            this.id = id;
            this.deadline = deadline;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Problem o) {
            if(this.deadline == o.deadline) {
                return this.cnt - o.cnt;
            } else {
                return this.deadline - o.deadline;
            }
        }
    }
    static PriorityQueue<Problem> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(1, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });
    static int N;
    static long ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    
    private static void solve() {
        int elapsed_time = 1;
        while(!pq.isEmpty()) {
            Problem p = pq.peek();
            if(elapsed_time == p.deadline) {
                p = pq.poll();
                pq2.offer(p.cnt);
                if(pq2.size() > elapsed_time) {
                    while(pq2.size() > elapsed_time) {
                        pq2.poll();
                    }
                }
            } else {
                elapsed_time++;
            }
        }
        while(!pq2.isEmpty()) ans = (long) pq2.poll();
        if(ans > 2147483648L) ans = 2147483648L;
        System.out.println(ans);
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            pq.add(new Problem(i, deadline, cnt));
        }
    }
}