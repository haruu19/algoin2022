package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1916_최소비용구하기_G5_다익스트라 {
    static int N,M,S,E;
    static List<Node>[] list;
    static int[] dist;
    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // set adjacency list
        list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // start dijkstra
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dist[i] = 987654321;
        }
        dist[S] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(); //
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node cNode = pq.poll();
            if(dist[cNode.idx] < cNode.cost) continue; // 최단거리가 아닌 경우 스킵
            for(Node nNode : list[cNode.idx]) {
                if (dist[nNode.idx] > dist[cNode.idx] + nNode.cost) {
                    dist[nNode.idx] = dist[cNode.idx] + nNode.cost;
                    pq.offer(nNode);
                }
            }
        }

        System.out.println(dist[E]);
    }
}
