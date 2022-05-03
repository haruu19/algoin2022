package algoin2022;


import java.io.*;
import java.util.*;

public class Boj_4485_녹색옷입은애가젤다지_G4_다익스트라 {
    static final int INF = 987654321;
    static int N, ans;
    static int[][] map, dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static class Pos implements Comparable<Pos> {
        int x,y,w;
        
        public Pos(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
        
        @Override
        public int compareTo(Pos o) {
            return this.w - o.w;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int cnt = 1;
        while((N = Integer.parseInt(br.readLine())) != 0) {
            map = new int[N][N];
            dist = new int[N][N];
            
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                
                Arrays.fill(dist[i], INF);
            }
            
            System.out.println("Problem " + cnt++ +": " + djkstra());
        }
    }
    
    public static int djkstra() {
        dist[0][0] = map[0][0];
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0,0,map[0][0]));
        
        while(!pq.isEmpty()) {
            Pos cur = pq.poll();
            
            for(int k=0;k<4;k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
                        dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
                        pq.add(new Pos(nx,ny,dist[nx][ny]));
                    }
                }
            }
        }
        
        return dist[N-1][N-1];
    }
}