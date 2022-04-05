package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_12896_스크루지민호_G3_트리지름 {
    static int xs,ys;
    static long ans;
    static int[][] a = new int[7][2];
    static boolean[] v = new boolean[7];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        xs = sc.nextInt();
        ys = sc.nextInt();
        ans = Long.MAX_VALUE;
        for(int i=0;i<7;i++) {
            for(int j=0;j<2;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        dfs(xs,ys,0);
        System.out.println(ans);
    }
    private static void dfs(int x, int y, long cnt) {
        if(x == a[0][0] && y == a[0][1]) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int i=0;i<7;i++) {
            if(!v[i]) {
                if(i == 0) {
                    v[i] = true;
                    dfs(a[0][0], a[0][1], cnt + Math.abs(a[0][0] - x) + Math.abs(a[0][1] - y));
                    v[i] = false;
                } else {
                if(i % 2 == 1) {
                    v[i] = true;
                    v[i+1] = true;
                    dfs(a[i+1][0], a[i+1][1], cnt + Math.abs(a[i][0] - x) + Math.abs(a[i][1] - y) + 10);
                    v[i] = false;
                    v[i+1] = false;    
                } else {
                    v[i] = true;
                    v[i-1] = true;
                    dfs(a[i-1][0], a[i-1][1], cnt + Math.abs(a[i][0] - x) + Math.abs(a[i][1] - y) + 10);
                    v[i] = false;
                    v[i-1] = false;    
                    }
                }
            }
        }
    }
}