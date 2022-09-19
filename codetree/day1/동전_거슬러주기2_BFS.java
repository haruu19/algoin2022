package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class 동전_거슬러주기2_BFS {
    static int N,M;
    static int[] a;
    static boolean[] v;
    static class Item {
        int price;
        int cnt;

        public Item(int price, int cnt) {
            this.price = price;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            v = new boolean[11001];
            Queue<Item> q = new LinkedList<>();
            q.offer(new Item(a[i], 1));
            int cnt = 1;
            while(!q.isEmpty() && cnt <= 10000) {
                Item cur = q.poll();
                if (cur.price == M) {
                    min = Math.min(min, cur.cnt);
//                    System.out.println("min: "+min);
                    break;
                }
                for(int k=0;k<N;k++) {
                    int next = cur.price + a[k];
                    if(next < 1 || next > 11000 || v[next]) continue;
                    v[next] = true;
//                    System.out.println("v["+next+"]=true");
                    q.offer(new Item(next, cur.cnt+1));
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
