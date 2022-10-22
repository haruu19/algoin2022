package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1504_특정한최단경로_다익스트라 {
    static final int MAX = 987564431;
    static int N,M,v1,v2, min = MAX;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class Node implements Comparable<Node> {
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

    static List<Node>[] adjList;
    static int[] fd, v1d, v2d;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        init();
        // 1. 시작점 1 다익스트라
        fd[1] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(fd[curNode.idx] < curNode.dist) continue; // 최단거리가 아닌 경우 스킵
            for (Node nxtNode : adjList[curNode.idx]) {
                if (fd[nxtNode.idx] > fd[curNode.idx] + nxtNode.dist) {
                    fd[nxtNode.idx] = fd[curNode.idx] + nxtNode.dist;
                    pq.offer(nxtNode);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(fd[i]+" ");
        }
        System.out.println();

        // 2. 시작점 v1 다익스트라
        v1d[v1] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(v1, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(v1d[curNode.idx] < curNode.dist) continue; // 최단거리가 아닌 경우 스킵
            for (Node nxtNode : adjList[curNode.idx]) {
                if (v1d[nxtNode.idx] > v1d[curNode.idx] + nxtNode.dist) {
                    v1d[nxtNode.idx] = v1d[curNode.idx] + nxtNode.dist;
                    pq.offer(nxtNode);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(fd[i]+" ");
        }
        System.out.println();

        // 3. 시작점 v2 다익스트라
        v2d[v2] = 0;
        pq = new PriorityQueue<>();
        pq.offer(new Node(v2, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if(v2d[curNode.idx] < curNode.dist) continue; // 최단거리가 아닌 경우 스킵
            for (Node nxtNode : adjList[curNode.idx]) {
                if (v2d[nxtNode.idx] > v2d[curNode.idx] + nxtNode.dist) {
                    v2d[nxtNode.idx] = v2d[curNode.idx] + nxtNode.dist;
                    pq.offer(nxtNode);
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            System.out.print(fd[i]+" ");
        }
        System.out.println();

        // case1) 1 -> v1 -> v2 -> N, fd[v1] + v1d[v2] + v2d[N]
        if(fd[v1] < MAX && v1d[v2] < MAX && v2d[N] < MAX) min = Math.min(min, fd[v1] + v1d[v2] + v2d[N]);
        // case2) 1 -> v2 -> v1 -> N, fd[v2] + v2d[v1] + v1d[N]
        if(fd[v2] < MAX && v2d[v1] < MAX && v1d[N] < MAX) min = Math.min(min, fd[v2] + v2d[v1] + v1d[N]);

        System.out.println(min >= MAX ? -1 : min);
    }

    static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        fd = new int[N+1];
        v1d = new int[N+1];
        v2d = new int[N+1];
        Arrays.fill(fd, MAX);
        Arrays.fill(v1d, MAX);
        Arrays.fill(v2d, MAX);
    }
}
