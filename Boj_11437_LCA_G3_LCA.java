package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_11437_LCA_G3_LCA {
    static int N,M;
    static List<Integer>[] list;
    static int[][] ac;
    static boolean[] v;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        ac = new int[N+1][20];
        v = new boolean[N+1];
        depth = new int[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        
        dfs(1,0);
        
        for(int i=1;i<=15;i++) {
            for(int idx=1;idx<=N;idx++) {
                ac[idx][i] = ac[ac[idx][i-1]][i-1];
            }
        }
        
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a,b)).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    private static void dfs(int idx, int d) {
        v[idx] = true;
        depth[idx] = d;
        
        for(int i : list[idx]) {
            if(!v[i]) {
                ac[i][0] = idx;
                dfs(i, d+1);
            }
        }
        
        v[idx] = false;
    }
    
    private static int lca(int a, int b) {
        if(a == b) return a;
        int ad = depth[a];
        int bd = depth[b];
        int cnt = 0;

        while(ad > bd) {
        	a = ac[a][0];
        	ad--;
        }

        while(ad < bd) {
        	b = ac[b][0];
        	bd--;
        }
        
        while(a != b) {
            a = ac[a][0];
            b = ac[b][0];
        }
        
        return a;
    }
}