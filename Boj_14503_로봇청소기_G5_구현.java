package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_14503_로봇청소기_G5_구현 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,M,R,C,D,ans;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        init();
        solve(R,C,D);
        System.out.println(ans);
    }
    
    private static void solve(int x, int y, int dir) {
        int nx = 0;
        int ny = 0;
        
        LOOP:
        while(true) {
            // 1. 현재 위치를 청소한다
            map[x][y] = 2;
            // 2.
            int cnt = 0;
            while(true) {
                // b. 2a 단계가 연속으로 네 번 실행되었을 경우, 바로 뒤쪽이 벽이라면 작동을 멈춘다. 그렇지 않다면 한 칸 후진한다.
                if(cnt >= 4) {
                    dir = (dir >= 2) ? (dir-2) : (dir+2);
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                    if(map[nx][ny] == 1) {
                        break LOOP;
                    } else {
                        x = nx;
                        y = ny;
                        dir = (dir >= 2) ? (dir-2) : (dir+2);
                        break;
                    }
                }
                dir = (dir == 0) ? 3 : (dir-1);
                nx = x + dx[dir];
                ny = y + dy[dir];
                // a. 현재 위치의 바로 왼쪽에 청소안한 빈칸이 존재한다면 왼쪽방향으로 회전한 다음 한 칸을 전진하고 1번으로 돌아간다.
                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    break;
                }
                cnt++;
            }
        }
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 2) ans++;
            }
        }
    }
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}