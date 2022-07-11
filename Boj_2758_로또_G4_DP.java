package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_2758_로또_G4_DP {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T,N,M;
    static long[][] d;
    
    public static void main(String[] args) throws IOException {
        solution();
    }
    
    private static void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            d = new long[N+1][M+1];
            solve();
            System.out.println(d[N][M]);
        }
    }
    
    private static void solve() {
        for(int i=1;i<=M;i++) {
            d[1][i] = i;
        }
        for(int i=2;i<=N;i++) {
            for(int j=(int)Math.pow(2,i-1);j<=M;j++) {
                d[i][j] += d[i][j-1] + d[i-1][j/2];
            }
        }
    }
}