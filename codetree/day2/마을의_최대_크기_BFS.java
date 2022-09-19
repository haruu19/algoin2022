package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 마을의_최대_크기_BFS {
    static int N, ans;
    static int[][] map;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    bfs(i, j);
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        int cnt = 0;
        boolean[][] v = new boolean[N][N];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny] || map[nx][ny] == 0) continue;
                v[nx][ny] = true;
                q.offer(new Pos(nx, ny));
                cnt++;
            }
        }
        ans = Math.max(ans, cnt);
    }
}
