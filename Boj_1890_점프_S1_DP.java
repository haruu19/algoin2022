package algoin2022;

import java.io.*;
import java.util.*;
/*
4
2 3 3 1
1 2 1 3
1 2 3 1
3 1 1 0
 */
public class Boj_1890_점프_S1_DP {
    public static int N;
    public static int[][] map;
    public static long[][] d;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        d = new long[N][N];
        d[N-1][N-1] = 1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt((st.nextToken()));
            }
        }

        for (int i = N-1; i >= 0; i--) {
            for(int j = N-1; j >= 0; j--) {
                if(i==N-1 && j==N-1) continue;
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k] * map[i][j];
                    int ny = j + dy[k] * map[i][j];
                    if(!isRange(nx,ny)) continue;
                    d[i][j] += d[nx][ny];
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(d[0][0]);
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
