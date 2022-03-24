package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_5582_공통부분문자열_G5_DP {
    static int[][] dp;
    static String s1, s2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++) {
            for(int j=1;j<=s2.length();j++) {
                 if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;       
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=s1.length();i++) {
            for(int j=1;j<=s2.length();j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}