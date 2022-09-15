package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class 정수_사각형_최댓값의_최소2 {
    static int N,K;
    static int[][] map,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        d = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        d[0][0] = map[0][0];
        for (int i = 1; i < N; i++) {
            d[0][i] = Math.max(map[0][i], d[0][i-1]);
            d[i][0] = Math.max(map[i][0], d[i - 1][0]);
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int max1 = Math.max(d[i-1][j], map[i][j]);
                int max2 = Math.max(d[i][j-1], map[i][j]);
                d[i][j] = Math.min(max1, max2);
            }
        }
        System.out.println(d[N - 1][N - 1]);
    }
}
