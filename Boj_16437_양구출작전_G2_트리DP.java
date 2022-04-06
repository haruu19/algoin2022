package algoin2022;


import java.io.*;
import java.util.*;

public class Boj_16437_양구출작전_G2_트리DP {
    static int N;
    static List<Integer>[] list;
    static long[][] info;
    static long[] dp;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        info = new long[N+1][2];
        dp = new long[N+1];
        v = new boolean[N+1];
        for(int i=2;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            info[i][0] = s.equals("W") ? 0 : 1;
            info[i][1] = Long.parseLong(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            list[i].add(a);
            list[a].add(i);
        }
        dfs(1);
        System.out.println(dp[1]);
    }
    
    private static void dfs(int idx) {
        v[idx] = true;
        
        for(int i : list[idx]) {
            if(!v[i]) {
                dfs(i);
                dp[idx] += dp[i];
            }
        }
        
        if(info[idx][0] == 1) dp[idx] += info[idx][1];
        else dp[idx] = Math.max(0, dp[idx] - info[idx][1]);
        
        v[idx] = false;
    }
}