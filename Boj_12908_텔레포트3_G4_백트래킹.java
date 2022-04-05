package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_12908_텔레포트3_G4_백트래킹 {
    static int N, tIdx, tCnt;
    static List<Integer>[] list;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        list = new List[N+1];
        v = new boolean[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        // 임의의 노드에서 끝까지 진행
        dfs(1,0);
        tCnt = 0;
        // 끝(루트) 노드에서 끝까지 진행
        dfs(tIdx,0);
        System.out.println((tCnt % 2 == 0) ? (tCnt / 2) : (tCnt / 2 + 1));
    }
    
    static void dfs(int idx, int cnt) {
        v[idx] = true;
        if(tCnt < cnt) {
            tCnt = cnt;
            tIdx = idx;
        }
        for(int i : list[idx]) {
            if(!v[i]) dfs(i, cnt + 1);
        }
        v[idx] = false;
    }
}