package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_11053_가장긴증가하는부분수열_S2_LIS {
    static int N,ans;
    static int[] a,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        d = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            d[i] = 1;
            for(int j=0;j<i;j++) {
                if(a[j] < a[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
        
        for(int i=0;i<N;i++) ans = Math.max(ans, d[i]);
        
        System.out.println(ans);
        
    }
}