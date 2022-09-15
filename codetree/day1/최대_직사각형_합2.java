package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class 최대_직사각형_합2 {
    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 시작점 잡기
        for(int x=0;x<N;x++) {
            for(int y=0;y<N;y++) {
                solve(x,y);
            }
        }
        System.out.println(max);
    }

    private static void solve(int x, int y) {
        for(int i=0;i<N-x;i++) {
            for(int j=0;j<N-y;j++) {
                max = Math.max(max, sum(x,y,i,j));
            }
        }
    }

    private static int sum(int x, int y, int height, int width) {
        int sum = 0;
        for(int i=x;i<=x+height;i++) {
            for(int j=y;j<=y+width;j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}
