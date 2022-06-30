package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_14921_용액합성하기_G5_투포인터 {
    static final int MAX = 200000000;
    static int N;
    static long[] a;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        a = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Long.parseLong(st.nextToken());
    }
    
    private static void solve() {
        int l = 0;
        int r = N-1;
        long closest_to_zero = MAX;
        
        while(l < r) {
            long sum = a[l] + a[r];
            if(Math.abs(closest_to_zero) > Math.abs(sum)) closest_to_zero = sum;
            long l_move_sum = a[l+1] + a[r];
            long r_move_sum = a[l] + a[r-1];
            if(Math.abs(l_move_sum) < Math.abs(r_move_sum)) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(closest_to_zero);
    }
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }


}