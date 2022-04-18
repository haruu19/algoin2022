package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_22945_팀빌딩_G4_투포인터 {
    static int N,max;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        int l = 0;
        int r = N-1;
        max = getVal(l,r);
        while(l < r) {
            if(a[l] < a[r]) l++;
            else r--;
            max = Math.max(max, getVal(l,r));
        }
        System.out.println(max);
    }
    
    static int getVal(int l, int r) {
        return Math.min(a[l], a[r]) * (r-l-1);
    }
}