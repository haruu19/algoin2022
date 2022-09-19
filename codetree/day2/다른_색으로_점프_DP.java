package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 다른_색으로_점프_DP {
    static int N,M;
    static String[][] map;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        sum = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = st.nextToken();
            }
        }
        sum[0][0] = 1; // 초기값 set
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String curColor = map[i][j];
                for (int i2 = i + 1; i2 < N; i2++) {
                    for (int j2 = j + 1; j2 < M; j2++) {
                        if(!map[i2][j2].equals(curColor)) {
                            sum[i2][j2] += sum[i][j];   // 경우의 수를 누적시켜준다.
                        }
                    }
                }
            }
        }
        System.out.println(sum[N - 1][M - 1]);
    }
}
