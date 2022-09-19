package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 테트리스_블럭_안의_합_최대화하기2 {
    static int N, M, ans;
    static int[][] map,sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        sum = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sum[i][j] += map[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        // case 1 : 가로가 긴 직사각형
        for (int i = 2; i <= N; i++) {
            for (int j = 3; j <= M; j++) {
                int totSum = sum[i][j] - sum[i][j-3] - sum[i-2][j] + sum[i-2][j-3];
                for (int i2 = i - 1; i2 <= i; i2++) {
                    for (int j2 = j - 2; j2 <= j; j2++) {
                        int sum = totSum - map[i2][j2];
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }

        // case 2 : 세로가 긴 직사각형
        for (int i = 3; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                int totSum = sum[i][j] - sum[i][j-2] - sum[i-3][j] + sum[i-3][j-2];
                for (int i2 = i - 2; i2 <= i; i2++) {
                    for (int j2 = j - 1; j2 <= j; j2++) {
                        int sum = totSum - map[i2][j2];
//                        System.out.println(totSum+" - "+map[i2][j2]+" = "+sum);
                        ans = Math.max(ans, sum);
                    }
                }
            }
        }

        // case 3 : 십자가 모양
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 2; i <= N - 1; i++) {
            LOOP:
            for (int j = 2; j <= M - 1; j++) {
                int sum = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx < 1 || ny < 1 || nx > N || ny > M) continue LOOP;
                    sum += map[nx][ny];
                }
                ans = Math.max(ans, sum);
            }
        }

        // case 4, 5 : 직선 모양
        for (int i = 1; i <= N; i++) {
            if(M == 4) break;
            int sum = 0;
            for (int j = 1; j <= M - 4; j++) {
                for(int j2=j;j2<=j+4;j2++) {
                    sum += map[i][j2];
                }
            }
            ans = Math.max(ans, sum);
        }

        for (int j = 1; j <= M; j++) {
            if(N == 4) break;
            int sum = 0;
            for (int i = 1; i <= N - 4; i++) {
                for (int i2 = i; i2 <= i + 4; i2++) {
                    sum += map[i2][j];
                }
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}
