package algoin2022;

import java.io.*;
import java.util.*;
public class Boj_16938_캠프준비_G5_백트래킹 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,L,R,X,ans,sum;
    static int[] arr;
    static boolean[] v;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        init();
        backtracking(0);
        System.out.println(ans);
    }
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];
        v = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    private static void backtracking(int depth) {
        if(depth == N) {
            solve();
            return;
        }
        v[depth] = true;
        backtracking(depth+1);
        v[depth] = false;
        backtracking(depth+1);
    }
    
    private static void solve() {
        list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            if(v[i]) list.add(arr[i]);
        }
        Collections.sort(list);
        sum = 0;
        list.stream().forEach(x -> sum += x);
        if(list.size() < 2) return;
        if(sum < L || sum > R) return;
        if(list.get(list.size()-1) - list.get(0) < X) return;
        ans++;
    }
}