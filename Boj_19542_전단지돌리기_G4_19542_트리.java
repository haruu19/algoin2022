package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_19542_전단지돌리기_G4_19542_트리 {
    static int N,S,D,ans;
    static List<Integer>[] list;
    static int[] toLeaf;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        toLeaf = new int[N+1];
        v = new boolean[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        
        getToLeaf(S);
        
        v = new boolean[N+1];
        
        dfs(S);
        
        System.out.println(ans * 2);
    }
    
    private static void dfs(int x) {
        v[x] = true;
        
        for(int idx : list[x]) {
            if(!v[idx] && toLeaf[idx] >= D) {
                ans++;
                dfs(idx);
            }
        }
    }
    
    private static int getToLeaf(int x) {
        v[x] = true;
        
        for(int idx : list[x]) {
            if(!v[idx]) {
                toLeaf[x] = Math.max(toLeaf[x], getToLeaf(idx) + 1);
            }
        }
        
        return toLeaf[x];
    }
}