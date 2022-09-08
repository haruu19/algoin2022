package algoin2022;

import java.io.*;
import java.util.*;
public class Boj_2479_경로찾기_G3_DFS {
    static int N,K,S,E;
    static int min = Integer.MAX_VALUE;
    static int[] ans;
    static List<Node>[] adjList;
    static String[] binCodes;
    static class Node {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
    static boolean isAnswerExist = false;
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = new int[N+1];
        adjList = new List[N+1];
        for(int i=1;i<=N;i++) adjList[i] = new ArrayList<>();
        binCodes = new String[N+1];
        for(int i=1;i<=N;i++) {
            binCodes[i] = br.readLine();
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i==j) continue;
                calculate(i, j);
            }
        }
        bfs(S);
        if(!isAnswerExist) System.out.println(-1);
        else {
            List<Integer> tmp = new ArrayList<>();
            int tmpIdx = E;
            tmp.add(tmpIdx);
            while(tmpIdx != S) {
                tmpIdx = p[tmpIdx];
                tmp.add(tmpIdx);
            }
            for(int i=tmp.size()-1;i>=0;i--) {
                System.out.print(tmp.get(i));
                if(i != 0) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[N+1];
        p = new int[N+1];
        q.offer(start);
        v[start] = true;
        while(!q.isEmpty()) {
           int idx = q.poll();
            for(Node node : adjList[idx]) {
                if(node.dist != 1 || v[node.idx]) continue;
                p[node.idx] = idx;
                if(node.idx == E) {
                    isAnswerExist = true;
                    return;
                }
                q.offer(node.idx);
                v[node.idx] = true;
            }
        }
    }

    private static void calculate(int x, int y) {
        int dist = 0;
        for(int i=0;i<K;i++) {
            if(binCodes[x].charAt(i) != binCodes[y].charAt(i)) dist++;
        }
        adjList[x].add(new Node(y,dist));
    }
}
