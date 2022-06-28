package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_17069_파이프옮기기2_G4_DP {
    static int N;
    static int[][] map;
    // dp[x][y][dir] = (x,y)에 dir방향의 파이프를 이동시킬 수 있는 경우의 수
    // dir : 0-세로, 1-대각선, 2-가로
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N][3];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][1][2] = 1;
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if((i==0 && j==1) || map[i][j] == 1) continue;
                if(i-1 >= 0 && map[i-1][j] == 0) {
                    dp[i][j][0] = dp[i-1][j][1] + dp[i-1][j][0];
                }
                if(i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] == 0 && map[i][j-1] == 0 && map[i-1][j] == 0) {
                    dp[i][j][1] = dp[i-1][j-1][2] + dp[i-1][j-1][1] + dp[i-1][j-1][0];
                }
                if(j-1 >= 0 && map[i][j-1] == 0) {
                    dp[i][j][2] = dp[i][j-1][2] + dp[i][j-1][1];
                }
            }
        }
        
        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
    }
}