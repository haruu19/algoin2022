package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_14950_정복자_G3_MST {
    static int N,M,T,ans;
    static int[] p;
    static class Edge {
        int s;
        int e;
        int c;
        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
    static PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>()  {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.c - o2.c;
        }
    });
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        for(int i=1;i<=N;i++) p[i] = i;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            pq.offer(new Edge(a,b,c));
         }
        
        int cnt = 0;
        while(cnt < N - 1) {
            Edge e = pq.poll();
            if(find(e.s) != find(e.e)) {
                union(Math.min(e.s, e.e), Math.max(e.s, e.e));
                ans += e.c + cnt * T;
                cnt++;
            }
        }
        
        System.out.println(ans);
    }
    
    static int find(int x) {
        while(x != p[x]) x = p[x];
        return x;
    }
    
    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        
        p[py] = px;
    }
}