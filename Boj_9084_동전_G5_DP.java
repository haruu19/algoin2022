package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_9084_동전_G5_DP {
    static int T,N,price;
    static int[] a, d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());
            a = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            price = Integer.parseInt(br.readLine());
            d = new int[price+1];
            
            d[0] = 1;
            for(int j=0;j<N;j++) {
                for(int i=1;i<=price;i++) {
                    if(i-a[j] >= 0) {
                        d[i] += d[i-a[j]];
                    }
                }
            }
            System.out.println(d[price]);
        }
    }
}