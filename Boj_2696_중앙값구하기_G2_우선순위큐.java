package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_2696_중앙값구하기_G2_우선순위큐{
    static int T,N;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
            N = Integer.parseInt(br.readLine());
            a = new int[N];
            int tmp1 = N / 10;
            int tmp2 = N % 10;
            int k;
            for(k=0;k<tmp1;k++) {
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<10;i++) a[k*10 + i] = Integer.parseInt(st.nextToken());
            }
            if(tmp2 != 0) {
                st = new StringTokenizer(br.readLine());
                for(int i=0;i<tmp2;i++) a[k*10 + i] = Integer.parseInt(st.nextToken());
            }
            PriorityQueue<Integer> pq1 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            
            PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for(int i=0;i<N;i++) {
                if(i % 2 == 0) {
                    pq1.offer(a[i]);
                } else {
                    pq2.offer(a[i]);
                }
                
                if(!pq2.isEmpty() && pq1.peek() > pq2.peek()) {
                    int tmp = pq1.poll();
                    pq1.offer(pq2.poll());
                    pq2.offer(tmp);
                }
                
                if(i % 2 == 0) {
                    sb.append(pq1.peek() + " ");
                    cnt++;
                }
            }
            System.out.println(cnt);
            System.out.println(sb.toString());
        }
    }
}