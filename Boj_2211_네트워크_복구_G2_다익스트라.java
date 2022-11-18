package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_2211_네트워크_복구_G2_다익스트라 {
    static int N,M, cnt;                // 정점(vertex)와 간선(edge)의 갯수
    static List<Node>[] adjList;        // 그래프 정보를 저장하는 인접리스트
    static int[] dist;                  // 1번노드에서 각 노드로 이동하는 최단거리를 저장하는 배열
    static final int MAX = 987654321;   // 무한대값
    static PriorityQueue<Node> pq;
    static class Node implements Comparable<Node> { // 노드번호와 해당 노드까지의 이동거리, 우선순위큐에 넣을 때 이동거리를 오름차순 정렬
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        // start init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();     // 인접리스트 초기화
        }
        dist = new int[N+1];
        Arrays.fill(dist, MAX);                 // 1번 노드에서 각 노드로 이동하는 최단거리 저장배열 무한대로 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }
        // end init

        // start dijkstra
        pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));               // 시작점 노드를 우선순위큐에 넣는다(해당 노드까지 이동거리는 0)
        dist[1] = 0;                                     // 1번 노드까지 이동하는데 걸리는 최단거리는 0
        Map<Integer, String> hMap = new HashMap<>();    // 각각의 노드까지 가는데 걸리는 최단거리가 갱신될 때 마다 갱신되는 간선 정보 저장
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(dist[curNode.idx] < curNode.dist) continue; // 여러 경로를 거쳐서 이동하는 최단거리가 다이렉트로 이동하는 거리보다 짧으면 패스
            for (Node nxtNode : adjList[curNode.idx]) {
                if (dist[nxtNode.idx] > dist[curNode.idx] + nxtNode.dist) { // 현재노드까지 최단거리보다 (이전노드까지 최단거리 + 현재노드까지 거리)가 짧으면 갱신
                    dist[nxtNode.idx] = dist[curNode.idx] + nxtNode.dist;
                    pq.offer(nxtNode);
                    hMap.put(nxtNode.idx, curNode.idx + " " + nxtNode.idx);
                }
            }
        }
        System.out.println(hMap.size());
        for (Integer key : hMap.keySet()) {
            System.out.println(hMap.get(key));
        }
    }
}