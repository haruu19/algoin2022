package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_13144_ListOfUniqueNumbers_G4_투포인터 {
    static int N;
    static long ans;
    static int[] a, numCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        numCnt = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        int r = 0;
        for(int l=0;l<N;l++) {
            while(r<N) {
                if(numCnt[a[r]] == 1) break;
                numCnt[a[r]]++;
                r++;
            }
            ans += (r-l);
            numCnt[a[l]]--;
        }
        System.out.println(ans);
    }
}