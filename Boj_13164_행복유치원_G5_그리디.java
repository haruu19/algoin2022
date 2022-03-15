package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_13164_행복유치원_G5_그리디 {
    static int N,K,ans;
    static int[] arr, diff;
    static List<List<Integer>> ll;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        diff = new int[N-1];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i >= 1) diff[i-1] = arr[i] - arr[i-1];
        }
        
        Arrays.sort(diff);
        
        for(int t=0;t<N-K;t++) {
           ans += diff[t];
        }
         
        System.out.println(ans);
    }
}