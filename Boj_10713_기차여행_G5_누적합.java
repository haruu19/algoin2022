package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_10713_기차여행_G5_누적합 {
    static int N,M,ans;
    static int[] path, a, b, c, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        path = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) path[i] = Integer.parseInt(st.nextToken());
        a = new int[N];
        b = new int[N];
        c = new int[N];
        for(int i=1;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }
        sum = new int[N+2];
        
        for(int i=0;i<M-1;i++) {
            if(path[i] < path[i+1]) {
                sum[path[i]] += 1;
                sum[path[i+1]] += -1;
            } else {
                sum[path[i+1]] += 1;
                sum[path[i]] += -1;
            }
        }
        
        for(int i=1;i<=N;i++) {
            sum[i] = sum[i] + sum[i-1];
        }

        for(int i=1;i<=N;i++) {
            if(sum[i] != 0) ans += Math.min(a[i] * sum[i], b[i] * sum[i] + c[i]);
        }
        
        System.out.println(ans);
    }
}