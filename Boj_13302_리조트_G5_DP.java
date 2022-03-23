package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_13302_리조트_G5_DP {
    static final int MAX = 987654321;
    static int N,M,ans;
    static List list;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        if(M > 0) {
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<M;i++) {
        		list.add(Integer.parseInt(st.nextToken()));
        	}
        }
        d = new int[110][110];
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=40;j++) {
                d[i][j] = MAX;
            }
        }
        d[0][0] = 0;
        
        for(int i=0;i<N;i++) {
            for(int j=0;j<=40;j++) {
                if(d[i][j] == MAX) continue;
                int result = d[i][j];
                
                if(list.contains(i+1)) {
                    d[i+1][j] = Math.min(result, d[i+1][j]);
                }
                
                if(j>=3) {
                    d[i+1][j-3] = Math.min(result, d[i+1][j-3]);
                }
                
                d[i+1][j] = Math.min(result + 10000, d[i+1][j]);
                
                for(int k=1;k<=3;k++) {
                    d[i+k][j+1] = Math.min(result + 25000, d[i+k][j+1]);
                }
                
                for(int k=1;k<=5;k++) {
                    d[i+k][j+2] = Math.min(result + 37000, d[i+k][j+2]);
                }
            }
        }
        
        int min = MAX;
        for(int j=0;j<=40;j++) {
            min = Math.min(min, d[N][j]);
        }
        System.out.println(min);
    }
}