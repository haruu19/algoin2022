package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 테트리스_블럭_안의_합_최대화하기2_백트래킹 {
    static int N, M, ans;
    static int[][] map,sum;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Pos> list = new ArrayList<>();
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        sum = new int[N][M];
        v = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                list.add(new Pos(i, j));
                backtracking(1,map[i][j]);
                list.remove(list.size() - 1);
            }
        }



        System.out.println(ans);
    }

    private static void backtracking(int depth, int sum) {
        if(depth == 5) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Pos pos = list.get(i);
            for (int k = 0; k < 4; k++) {
                int nx = pos.x + dx[k];
                int ny = pos.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || !canGo(nx, ny)) continue;
                list.add(new Pos(nx, ny));
                backtracking(depth + 1, sum + map[nx][ny]);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean canGo(int x, int y) {
        for (Pos pos : list) {
            if(pos.x == x && pos.y == y) return false;
        }
        return true;
    }
}
