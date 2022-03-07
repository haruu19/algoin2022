package algoin2022;

import java.util.*;

public class Boj_20164_홀수홀릭호석_G5_재귀 {
    static int N, min, max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        divide(String.valueOf(N), countingOdds(String.valueOf(N)));
        System.out.println(min + " " + max);
    }
    
    static void divide(String str, int sum) {
        if(str.length() >= 3) {
            for(int x=1;x<=str.length()-1;x++) {
                for(int y=x+1;y<=str.length()-1;y++) {
                    String a = str.substring(0,x);
                    String b = str.substring(x,y);
                    String c = str.substring(y,str.length());
                    String nStr = String.valueOf(Integer.parseInt(a)+Integer.parseInt(b)+Integer.parseInt(c));
                    divide(nStr, sum + countingOdds(nStr));
                }
            }
        } else if(str.length() == 2) {
            String a = str.substring(0,1);
            String b = str.substring(1,2);
            String nStr = String.valueOf(Integer.parseInt(a)+Integer.parseInt(b));
            divide(nStr, sum + countingOdds(nStr));            
        } else if(str.length() == 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
    }
    
    static int countingOdds(String x) {
        int ret = 0;
        for(int i=0;i<x.length();i++) {
            if(x.charAt(i) % 2 == 1) ret++;
        }
        return ret;
    }
}