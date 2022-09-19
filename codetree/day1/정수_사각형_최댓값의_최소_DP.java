package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class 정수_사각형_최댓값의_최소_DP {
    static int N,K;
    static int[][] map;
    static int[][][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        d = new int[N][N][K+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /*
        1) (i,j)번째 칸을 색칠하지 않을 경우
        d[i-1][j][k], d[i][j-1][k]
        2) (i,j)번째 칸을 색칠할 경우
        max(d[i-1][j][k-1], map[i][j]), max(d[i][j-1][k-1], map[i][j])
        => d[i][j][k] = Math.min(d[i-1][j][k], d[i][j-1][k], Math.max(d[i-1][j][k-1], map[i][j]), Math.max(d[i][j-1][k-1], map[i][j]))
         */
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                d[i][j][0] = Integer.MIN_VALUE;
                for(int k=1;k<=K;k++) {
                    d[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        d[0][0][1] = map[0][0];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                for(int k=1;k<=K;k++) {
                    if(i == 0 && j == 0) continue;
                    if(i+j+1 < k) continue;
                    if(i == 0 && j != 0) {
                        d[i][j][k] = Math.min(Math.min(d[i][j - 1][k], map[i][j]), Math.max(d[i][j - 1][k - 1], map[i][j]));
                    }
                    if(i != 0 && j == 0) {
                        d[i][j][k] = Math.min(Math.min(d[i - 1][j][k], Math.max(d[i - 1][j][k - 1], map[i][j])), map[i][j]);
                    }
                    if(i != 0 && j != 0) {
                        d[i][j][k] = Math.min(Math.min(d[i - 1][j][k], d[i][j - 1][k]), Math.min(Math.max(d[i - 1][j][k - 1], map[i][j]), Math.max(d[i][j - 1][k - 1], map[i][j])));
                    }
                }
            }
        }
        System.out.println(d[N-1][N-1][K]);
    }
}
