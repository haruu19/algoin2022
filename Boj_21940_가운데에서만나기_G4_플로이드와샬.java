package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_21940_가운데에서만나기_G4_플로이드와샬 {
	static int N,M,K;
	static int[][] adj;
	static int[] arr, arr2;
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i == j) continue;
				if(adj[i][j] == 0) adj[i][j] = INF;
			}
		}		

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[K];
		arr2 = new int[N+1];
		for(int i=0;i<K;i++) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
		// node 1 2 3
		// k = (1~N) adj[n][k] + adj[k][n] 맥스값 구한다
		for(int i=1;i<=N;i++) {
			int max = Integer.MIN_VALUE;
			for(int j=0;j<K;j++) {
				max = Math.max(max, adj[arr[j]][i] + adj[i][arr[j]]);
			}
			arr2[i] = max;
		}
		
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			if(min >= arr2[i]) {
				min = arr2[i];
			}
		}
		for(int i=1;i<=N;i++) {
			if(arr2[i] == min) list.add(i);
		}
		
		for(int ele : list) System.out.print(ele+" ");
	}

}
