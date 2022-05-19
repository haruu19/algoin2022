package algoin2022;

import java.util.*;

public class Boj_15831_준표의조약돌_G4_투포인터 {
    static int N,B,W,ans,bCnt,wCnt,l,r;
    static String s;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();
        W = sc.nextInt();
        s = sc.next();
        
        if(s.charAt(0) == 'B') bCnt++;
        else wCnt++;
        
        while(r < N) {
            if(bCnt <= B && wCnt >= W) {
                ans = Math.max(ans, r-l+1);
            }
            
            if(bCnt <= B) {
                r++;
                
                if(r >= N) continue;
                if(s.charAt(r) == 'B') bCnt++;
                else wCnt++;
            } else {
                if(s.charAt(l) == 'B') bCnt--;
                else wCnt--;
                
                l++;
            }
        }
        
        System.out.println(ans);
    }
}