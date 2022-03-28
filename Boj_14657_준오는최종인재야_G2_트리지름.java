package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_14657_준오는최종인재야_G2_트리지름 {
    static int N,T,max,ans,temp;
    static List<Node>[] adj;
    static boolean[] v;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        adj = new List[N+1];
        dist = new int[N+1];
        v = new boolean[N+1];
        ans = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++) adj[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b,c));
            adj[b].add(new Node(a,c));
        }
        
        // 트리의 지름들 중 최소비용을 구한다.
        // 1.임의의 정점 선택
        v[1] = true;
        // 2. 해당 정점에서 가장 멀리 떨어져 있는 정점들의 집합을 구한다.
        find(1,0);
        // 3. 집합 안의 모든 정점에 대해 dfs를 수행하여 최대 깊이에 위치한 정점까지의 비용 중 최소값 산출
        for(int i=1;i<=N;i++) {
            if(dist[i] == max) {
                v = new boolean[N+1];
                v[i] = true;
                dfs(i,0,0);
            }
        }
        
        System.out.println(ans / T + ((ans % T) == 0 ? 0 : 1));
    }
    
    private static void dfs(int idx, int depth, int sum) {
        if(temp < depth) {
            temp = depth;
            ans = sum;
        }
        if(depth != 0 && temp == depth) {
            ans = Math.min(ans, sum);
        }
        
        for(Node node : adj[idx]) {
            if(!v[node.idx]) {
                v[node.idx] = true;
                dfs(node.idx, depth+1, sum + node.cost);
                v[node.idx] = false;
            }
        }
    }
    
    private static void find(int idx, int depth) {
        dist[idx] = depth;
        max = Math.max(max, depth);
        
        for(Node node : adj[idx]) {
            if(!v[node.idx]) {
                v[node.idx] = true;
                find(node.idx, depth+1);
                v[node.idx] = false;
            }
        }
    }
    
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
}