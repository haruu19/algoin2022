package algoin2022;

import java.util.*;

public class Boj_5569_출근경로_G5_DP {
    static int W,H;
    static int[][][][] d;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        d = new int[W+1][H+1][2][2];
        for(int i=2;i<=W;i++) {
            d[i][1][0][1] = 1;
        }
        for(int i=2;i<=H;i++) {
            d[1][i][1][1] = 1;
        }
        for(int x=2;x<=W;x++) {
            for(int y=2;y<=H;y++) {
                d[x][y][0][0] = d[x-1][y][1][1];
                d[x][y][0][1] = (d[x-1][y][0][0] + d[x-1][y][0][1])%100000;
                d[x][y][1][0] = d[x][y-1][0][1];
                d[x][y][1][1] = (d[x][y-1][1][0] + d[x][y-1][1][1])%100000;
            }
        }
        System.out.println((d[W][H][0][0] + d[W][H][0][1] + d[W][H][1][0] + d[W][H][1][1]) % 100000);
    }
}