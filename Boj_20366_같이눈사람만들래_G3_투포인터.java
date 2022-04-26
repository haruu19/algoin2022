package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_20366_같이눈사람만들래_G3_투포인터 {
    static int N;
    static long ans = Long.MAX_VALUE;
    static int[] a;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);
        for(int i=0;i<N-1;i++) {
            for(int j=i+1;j<N;j++) {
                v[i] = true;
                v[j] = true;
                
                long cmp1 = a[i] + a[j];
                int l = 0;
                int r = N-1;
                long sum = 0;
                while(l < r) {
                    while(v[l]) l++;
                    while(v[r]) r--;
                    if(l >= r) break;
                    sum = a[l] + a[r];
                    if(cmp1 < sum) {
                        ans = Math.min(ans, Math.abs(cmp1 - sum));
                        r--;
                    } else if(cmp1 == sum) {
                        ans = 0;
                        break;
                    } else {
                        ans = Math.min(ans, Math.abs(cmp1 - sum));
                        l++;
                    }
                }

                v[i] = false;
                v[j] = false;
            }
        }
        System.out.println(ans);
    }
}