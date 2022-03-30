package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_1509_펠린드롬분할_G1_DP2번 {
    static String s;
    static int ans;
    static int[] dp;
    static boolean[][] ip;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        dp = new int[s.length()];
        ip = new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();j++) {
            for(int i=0;i<=j;i++) {
                if(i == j) {
                    ip[i][j] = true;
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        ip[i][j] = true;
                        if(j-i >= 2 && !ip[i+1][j-1]) ip[i][j] = false;
                    } else {
                        ip[i][j] = false;
                    }
                }
            }
        }
        
        dp[0] = 1;
        for(int i=1;i<dp.length;i++) {
            int min = dp[i-1] + 1;
            for(int j=i;j>=0;j--) {
                if(ip[j][i]) {
                    min = Math.min(min, (j-1 < 0) ? 1 : (dp[j-1] + 1));
                }
            }
            dp[i] = min;
        }
        System.out.println(dp[dp.length-1]);
    }
}