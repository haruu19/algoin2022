package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class k번_이상_등장하는_최대 {
    static int N,K;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<N;i++) {
            if(map.get(a[i]) == null) map.put(a[i], 1);
            else map.put(a[i], map.get(a[i]) + 1);
        }
        Set<Integer> set = map.keySet();
        int max = -1;
        for(Integer i : set) {
//            System.out.println(i+" "+map.get(i));
            if(map.get(i) >= K) {
                max = Math.max(max, i);
            }
        }
        System.out.println(max);
    }
}
