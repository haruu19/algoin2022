package algoin2022;

import java.io.*;
import java.util.*;;

public class Boj_10986_나머지합_G3_누적합효율화 {
    static int N,M;
    static long ans;
    static int[] a, sum, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N+1];
        sum = new int[N+1];
        cnt = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum[i] = a[i] + sum[i-1];
            sum[i] = sum[i] % M;
            cnt[sum[i]]++;
        }
        
        for(int i=0;i<M;i++) {
            if(cnt[i] != 0) ans += (long) cnt[i] * (cnt[i] - 1) / 2;
        }
        
        System.out.println(cnt[0] + ans);
    }
}