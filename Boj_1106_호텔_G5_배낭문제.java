package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1106_호텔_G5_배낭문제 {
    static int C,N,ans;
    static int[] cost, value, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
    
        cost = new int[N];
        value = new int[N];
        d = new int[100000 + 1];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            
            cost[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        // d[비용] = 해당 비용으로 구할 수 있는 고객 수의 최댓값
        // 비용의 최댓값 : 1000 * 100 = 100000
        for(int i=0;i<N;i++) {
            for(int k=1;k<=100000;k++) {
                if(k - cost[i] >= 0) {
                    d[k] = Math.max(d[k], d[k-cost[i]] + value[i]);
                }
            }
        }
        
        for(int k=1;k<=100000;k++) {
            if(d[k] >= C) {
                System.out.println(k);
                break;
            }
        }
    }
}