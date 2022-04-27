package algoin2022;

import java.util.*;

public class Boj_20442_ㅋㅋ루ㅋㅋ_G3_투포인터 {
    static int N,ans;
    static String s;
    static int[] lk, rk;
    static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        N = s.length();
        lk = new int[N];
        rk = new int[N];
        
        setData(); // lk, rk, deque 생성
        
        if(dq.isEmpty()) {
            System.out.println(0);
            System.exit(0);
        }
        
        int l = 0;
        int r = N-1;
        
        // 포인터 초기 위치 셋팅
        if(dq.size() == 1) {
            l = dq.poll();
            r = l;
        } else {
            l = dq.pollFirst();
            r = dq.pollLast();
        }
        
        while(l <= r) {
            ans = Math.max(ans, 
                          ((l == r) ? 1 : 2) + dq.size() + 2 * Math.min(lk[l], rk[r]));
            
            if(l == r) break;
            
            if(lk[l] > rk[r]) {
                if(dq.isEmpty()) r = l;
                else r = dq.pollLast();
            } else {
                if(dq.isEmpty()) l = r;
                else l = dq.pollFirst();
            }
        }
        
        System.out.println(ans);
    }
    
    static void setData() {
        int cnt = 0;
        for(int i=0;i<N;i++) {
            if(s.charAt(i) == 'R') dq.offer(i);
            
            if(s.charAt(i) == 'K') cnt++;
            else lk[i] = cnt;
        }
        
        cnt = 0;
        
        for(int i=N-1;i>=0;i--) {
            if(s.charAt(i) == 'K') cnt++;
            else rk[i] = cnt;
        }
    }
}