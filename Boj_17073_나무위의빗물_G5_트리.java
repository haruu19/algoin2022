package algoin2022;

import java.io.*;
import java.util.*;


public class Boj_17073_나무위의빗물_G5_트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,W,leafNodeCnt;
	static List<Integer>[] list;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		init();
		dfs(1);
		System.out.println(String.format("%.10f",(double) W / leafNodeCnt));
	}
	
	private static void dfs(int x) {
		if(v[x]) return;
		v[x] = true;
		
		if(list[x].size() == 1) {
			leafNodeCnt++;
			return;
		}
		
		for(int idx : list[x]) {
			dfs(idx);
		}
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		list = new List[N+1];
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
	}
}

/*
4 1000000000
1 2
1 3
1 4

2 20
1 2
*/