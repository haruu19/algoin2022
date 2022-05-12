package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_10473_인간대포_G2_다익스트라 {
	static int N;
	static double[][] a;
	static double[][] map;
	
	static class Edge implements Comparable<Edge> {
		int end;
		double cost;

		public Edge(int end, double cost) {
			super();
			this.end = end;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			int ret = 0;
			
			if(this.cost > e.cost) {
				ret = 1;
			} else if(this.cost == e.cost) {
				ret = 0;
			} else {
				ret = -1;
			}
			
			return ret;
		}
	}
	static boolean[] v;
	static double[] dist;
	static final double MAX = 987654321D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sx = Double.parseDouble(st.nextToken());
		double sy = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		double ex = Double.parseDouble(st.nextToken());
		double ey = Double.parseDouble(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		N = n + 2;
		a = new double[N][2];
		map = new double[N][N];
		
		a[0][0] = sx;
		a[0][1] = sy;
		a[N-1][0] = ex;
		a[N-1][1] = ey;
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			a[i][0] = Double.parseDouble(st.nextToken());
			a[i][1] = Double.parseDouble(st.nextToken());
		}
		
		for(int i=0;i<=N-2;i++) {
			for(int j=i+1;j<=N-1;j++) {
				double len = Math.sqrt(Math.pow(a[i][0] - a[j][0], 2) + Math.pow(a[i][1] - a[j][1], 2));
				map[i][j] = (i == 0) ? len : ((len >= 50) ? (len - 50) : (50 - len));
				if(j == N-1) continue;
				map[j][i] = (len >= 50) ? (len - 50) : (50 - len);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				map[i][j] /= 5;
				if(i != 0) map[i][j] += 2;
			}
		}
		
		v = new boolean[N];
		dist = new double[N];
		Arrays.fill(dist, MAX);
		dist[0] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(0,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			v[cur.end] = true;
			
			for(int i=0;i<N;i++) {
				if(v[i] || cur.end == i) continue;
				if(dist[i] > map[cur.end][i] + dist[cur.end]) {
					dist[i] = map[cur.end][i] + dist[cur.end];
					pq.offer(new Edge(i, dist[i]));
				}
			}
		}
		
		System.out.println(dist[N-1]);
	}
}
