package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_7569_토마토_G5_BFS {

    static int N,M,H,ans;
    static int[][][] map;
    static boolean[][][] v;
    static class Pos {
        int x;
        int y;
        int z;
        int time;
        public Pos(int x, int y, int z, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        v = new boolean[H][N][M];
        int[] count = new int[3];
        Queue<Pos> q = new LinkedList<>();
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++) {
                    int n = Integer.parseInt(st.nextToken());
                    map[k][i][j] = n;
                    if(n == 1) {
                        count[0]++;
                        q.add(new Pos(i,j,k,0));
                        v[k][i][j] = true;
                    }
                    else if(n == 0) count[1]++;
                    else if(n == -1) count[2]++;
                }
            }
        }
        if(count[1] == 0 && count[0] + count[2] == M * N) {
            System.out.println(ans);
            System.exit(0);
        } else {
            while(!q.isEmpty()) {
                Pos cur = q.poll();
                ans = Math.max(ans, cur.time);
                for(int k=0;k<6;k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    int nz = cur.z + dz[k];
                    if(nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H
                      && !v[nz][nx][ny] && map[nz][nx][ny] != -1) {
                        map[nz][nx][ny] = 1;
                        q.offer(new Pos(nx,ny,nz,cur.time+1));
                        v[nz][nx][ny] = true;
                    }
                }
            }
        }
        
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(map[k][i][j] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }
        
        System.out.println(ans);
    }

}
