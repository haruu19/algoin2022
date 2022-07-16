package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_2098_외판원순회_G1_DP비트마스킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] cost;
    static int[][] d; // d[cur][visit]
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(travel(0,1)); // d[0][{0001}]
    }
    
    private static int travel(int cur, int visit) {
        // d[cur][visit] = 현재 cur에서의 도시 방문 현황이 visit과 같을 때, 나머지 도시들을 모두 방문한 후 시작점으로 돌아갈 때 드는 비용
        // d[cur][visit] = Math.min(d[cur][visit], cost[cur][next] + d[next][visit | (1<<N)]);
        
        // dp가 갱신되어 있을 경우
        if(d[cur][visit] != INF)
            return d[cur][visit];
        
        // base case : 모든 마을을 방문하였을 경우 시작점으로 돌아간다.
        if(visit == (1<<N)-1)
            return d[cur][visit] = cost[cur][0] != 0 ? cost[cur][0] : INF;
        
        // substructure
        for(int i=0;i<N;i++) {
            // 이동할 수 없거나 이미 방문한 경우
            if(cost[cur][i] == 0 || (visit & (1<<i)) > 0) continue;
            d[cur][visit] = Math.min(d[cur][visit], cost[cur][i] + travel(i, visit | (1<<i)));
        }
        
        return d[cur][visit];
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        d = new int[N][1<<N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++) {
            Arrays.fill(d[i], INF);
        }   
    }
}