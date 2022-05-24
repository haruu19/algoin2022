package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_17396_백도어_G5_다익스트라 {
    static int N,M,ans;
    static int[] canGo;
    static long[] dist;
    static List<Node>[] list;
    static class Node implements Comparable<Node> {
        int e;
        long cost;
        public Node(int e, long cost) {
            this.e = e;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            if(this.cost < o.cost) {
                return -1;
            } else if(this.cost == o.cost) {
                return 0;
            } else {
                return 1;
            }
        }
    }
    static boolean[] v;
    static final long MAX = 10000000001L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        canGo = new int[N];
        dist = new long[N];
        list = new List[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) canGo[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, MAX);
        dist[0] = 0;
        for(int i=0;i<N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(canGo[b] == 0 || b == N-1) list[a].add(new Node(b,c));
            if(canGo[a] == 0 || a == N-1) list[b].add(new Node(a,c));
        }
        
        // do djkstra
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0));
        while(!pq.isEmpty()) {
            Node cNode = pq.poll();
            if(v[cNode.e]) continue;
            v[cNode.e] = true;
            
            for(Node nNode : list[cNode.e]) {                
                if(dist[nNode.e] > dist[cNode.e] + nNode.cost) {
                    dist[nNode.e] = dist[cNode.e] + nNode.cost;
                    pq.offer(new Node(nNode.e, dist[nNode.e]));
                }
            }
        }
        
        System.out.println(dist[N-1] != MAX ? dist[N-1] : -1);
    }
}