package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_13905_세부_G4_이분탐색 {
    static int N,M,S,E,ans,l,r;
    static List<Node>[] list;
    static class Node {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
    static boolean canGo;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new List[N+1];
        l = 1;
        r = 1000000;
        v = new boolean[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        while(l <= r) {
            int X = (l + r) >> 1;
            canGo = false;
            v = new boolean[N+1];
            dfs(S, X);
            if(canGo) {
                ans = Math.max(ans, X);
                l = X + 1;
            } else {
                r = X - 1;
            }
        }
        
        System.out.println(ans);
    }
    
    static void dfs(int idx, int X) {
        v[idx] = true;
        
        if(idx == E) {
            canGo = true;
            return;
        }
        
        for(Node cur : list[idx]) {
            if(v[cur.e] || cur.cost < X) continue;
            dfs(cur.e, X);
        }
    }
}