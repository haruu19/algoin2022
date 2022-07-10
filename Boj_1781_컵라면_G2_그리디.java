package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1781_컵라면_G2_그리디 {
    static class Problem implements Comparable<Problem> {
        int deadline;
        int cnt;
        public Problem(int deadline, int cnt) {
            this.deadline = deadline;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Problem o) {
            if(this.deadline == o.deadline) {
                return o.cnt - this.cnt;
            } else {
                return this.deadline - o.deadline;
            }
        }
    }
    static PriorityQueue<Problem> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    static int N,ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    
    private static void solve() {
        // pq2에 원소 하나씩 삽입
        // pq2.size()를 회차로 생각하면,
        // pq2에 넣을 원소의 deadline > pq2.size()면 그냥 넣음
        // pq2에 넣을 원소의 deadline <= pq2.size()면 pq2.peek() < 원소.cnt 인 경우 pq2.poll(), pq2.offer(원소)
        while(!pq.isEmpty()) {
            Problem p = pq.poll();
            if(p.deadline > pq2.size()) {
                pq2.offer(p.cnt);
            } else {
                if(pq2.peek() < p.cnt) {
                    pq2.poll();
                    pq2.offer(p.cnt);
                }
            }
        }
        
        pq2.forEach(x -> ans += x);
        System.out.println(ans);
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            pq.add(new Problem(deadline, cnt));
        }
    }
}