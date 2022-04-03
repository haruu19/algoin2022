package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1799_비숍_G1_백트래킹 {
    static int N;
    static int[][] map, colors;
    static boolean[][] v;
    static int[] ans;
    static int[] dx = {-1,1,1,-1};
    static int[] dy = {-1,-1,1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        colors = new int[N][N];
        v = new boolean[N][N];
        ans = new int[2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if((i%2==0 && j%2==0)||(i%2==1&&j%2==1)) colors[i][j] = 1;
            }
        }
        dfs(-1,-1,0,0);
        dfs(-1,-1,0,1);
        System.out.println(ans[0] + ans[1]);
    }
    private static void dfs(int x, int y, int cnt, int color) {
        if(ans[color] < cnt) {
            ans[color] = cnt;
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i < x) continue;
                if(i == x && j <= y) continue;
                if(colors[i][j] != color) continue;
                if(map[i][j] == 1 && chk(i,j)) {
                    v[i][j] = true;
                    dfs(i,j,cnt+1,color);
                }
            }
        }
        if(x==-1 && y==-1) return;
        v[x][y] = false;
    }
    private static boolean chk(int x, int y) {
        for(int k=0;k<4;k++) {
            int nx = x;
            int ny = y;
            for(int i=0;i<N;i++) {
                if(!(nx>=0 && nx<N && ny>=0 && ny<N)) break;
                if(v[nx][ny]) return false;
                nx += dx[k];
                ny += dy[k];
            }
        }
        return true;
    }
}