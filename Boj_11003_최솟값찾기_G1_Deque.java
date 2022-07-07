package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_11003_최솟값찾기_G1_Deque {
    static class Item {
        int idx;
        int val;
        public Item(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,L;
    static int[] a;
    static Deque<Item> dq = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }
    
    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            if(i >= L && dq.peekFirst().idx == (i-L)) { // 프레임 벗어난 원소 삭제
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.peekLast().val >= a[i]) { // 새로 넣을 원소보다 큰 값들 다 꺼냄
                dq.pollLast();
            }
            dq.offer(new Item(i,a[i]));
            sb.append(dq.peekFirst().val + " ");
        }
        System.out.print(sb.toString());
    }
    
    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
    }
}