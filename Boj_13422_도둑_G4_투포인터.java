package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_13422_도둑_G4_투포인터 {
    static int T,N,M,K;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            a = new int[N];
            for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
            int l = 0;
            int r = M-1;
            int sum = 0;
            int ans = 0;
            for(int i=l;i<=r;i++) sum += a[i];
            if(sum < K) ans++;
            if(N == M) {
                System.out.println(ans);
                continue;
            }
            for(int i=0;i<N-1;i++) {
                sum -= a[i];
                l++;
                r = (r+1) % N;
                sum += a[r];
                if(sum < K) ans++;
            }
            System.out.println(ans);
        }
    }
}