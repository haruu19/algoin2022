package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_2230_수고르기_G5_투포인터 {
    static int N,M;
    static long ans = Long.MAX_VALUE;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        for(int i=0;i<N;i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
        int l = 0;
        int r = 0;
        while(l<N && r<N) {
            long sub = Math.abs(a[l] - a[r]);
            if(sub < M) {
                r++;
            } else {
                ans = Math.min(ans, sub);
                l++;
            }
        }
        System.out.println(ans);
    }
}