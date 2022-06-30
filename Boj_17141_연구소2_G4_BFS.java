package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_17141_연구소2_G4_BFS {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M,totVirusCnt;
    static int[][] map;
    static boolean[][] v;
    static List<Pos> list = new ArrayList<>();
    static Queue<Pos> q = new LinkedList<>();
    static class Pos {
        int x;
        int y;
        int time;
        public Pos(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int[] arr;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) list.add(new Pos(i,j,0));
                if(map[i][j] != 1) totVirusCnt++;
            }
        }
        arr = new int[M];
        sol(0, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
    
    private static void sol(int prev, int depth) {
        if(depth == M) {
            bfs();
            return;
        }
        
        for(int i=prev;i<list.size();i++) {
            arr[depth] = i;
            sol(i+1, depth+1);
        }
    }
    
    private static void bfs() {
        q.clear();
        for(int i=0;i<N;i++) Arrays.fill(v[i], false);
        int curVirusCnt = 0;
        int qSize = 0;
        int tmpVirusCnt = 0;
        
        for(int i=0;i<M;i++) {
            Pos pos = list.get(arr[i]);
            q.offer(pos);
            v[pos.x][pos.y] = true;
            curVirusCnt++;
        }
        
        while(!q.isEmpty()) {
            tmpVirusCnt = curVirusCnt;
            qSize = q.size();
            Pos cur = null;
            for(int i=0;i<qSize;i++) {
                cur = q.poll();
                
                for(int k=0;k<4;k++) {
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];
                    if((nx<0||ny<0||nx>=N||ny>=N) || v[nx][ny] || map[nx][ny] == 1) continue;
                    q.offer(new Pos(nx,ny,cur.time+1));
                    v[nx][ny] = true;
                    curVirusCnt++;
                }
            }
            if(curVirusCnt == totVirusCnt) {
                if(totVirusCnt == M) ans = 0;
                else ans = Math.min(ans, cur.time+1);
                break;
            }
            if(tmpVirusCnt == curVirusCnt) {
                break;
            }
        }
    }
    
}