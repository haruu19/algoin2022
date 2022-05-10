package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1238_파티_G3_다익스트라 {
    static int N,M,X,ans;
    static List<Edge>[] adj;
    static class Edge {
        int e;
        int cost;
        
        public Edge(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    static int[] dist, time;
    static final int MAX = 987654321;
    static PriorityQueue<Edge> pq = new PriorityQueue<>(1, new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
            if(o1.cost == o2.cost) {
                return o1.e - o2.e;
            }
            return o1.cost - o2.cost;
        }
    });
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        time = new int[N+1];
        
        for(int i=1;i<=N;i++) adj[i] = new ArrayList<>();
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            adj[a].add(new Edge(b,c));
        }
        
        for(int i=1;i<=N;i++) {
            djkstra(i);
            if(i == X) {
                for(int j=1;j<=N;j++) {
                    time[j] += dist[j]; // X에서 집으로 오는데 걸리는 시간
                }
            } else {
                time[i] += dist[X]; // N에서 X으로 가는데 걸리는 시간
            }
        }
        
        for(int i=1;i<=N;i++) {
            if(i == X) continue;
            ans = Math.max(ans, time[i]);
        }   
        
        System.out.println(ans);
    }
    
    static void djkstra(int x) {
        // init
        v = new boolean[N+1];
        pq.clear();
        pq.offer(new Edge(x,0));
        dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[x] = 0;

        // do djkstra
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int idx = edge.e;
            
            if(v[idx]) continue;
            v[idx] = true;
            for(Edge e : adj[idx]) {
                if(!v[e.e] && dist[e.e] > dist[idx] + e.cost) {
                    dist[e.e] = dist[idx] + e.cost;
                    pq.add(new Edge(e.e, dist[e.e]));
                }
            }
        }
    }    

}