package algoin2022;

import java.util.*;

public class Boj_16472_고냥이_G4_투포인터 {
    static int N,max;
    static char[] a;
    static int[] apbCnt = new int[26];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        max = Integer.MIN_VALUE;
        a = sc.next().toCharArray();
        int l = 0;
        int r = -1;
        int len = a.length;
        while(l < len && r < len-1) {
            r++;
            apbCnt[a[r] - 'a']++;
            if(getCnt() > N) {
                while(l < r) {
                    apbCnt[a[l] - 'a']--;
                    l++;
                    if(getCnt() == N) break;
                }
            }
            max = Math.max(max, r-l+1);
        }
        System.out.println(max);
    }
    static int getCnt() {
        int ret = 0;
        for(int i=0;i<26;i++) {
            if(apbCnt[i] > 0) ret++;
        }
        return ret;
    }
}