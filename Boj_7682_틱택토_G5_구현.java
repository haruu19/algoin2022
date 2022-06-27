package algoin2022;

import java.io.*;

public class Boj_7682_틱택토_G5_구현 {
    static int o3Cnt;
    static int x3Cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!(str = br.readLine()).equals("end")) {
            boolean valid = true;
            char[][] map = new char[3][3];
            int oCnt = 0;
            int xCnt = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    map[i][j] = str.charAt(3*i + j);
                    if(map[i][j] == 'O') oCnt++;
                    else if (map[i][j] == 'X') xCnt++;
                }
            }
            
            check(map);
            
            // 1. x가 이긴 경우
            if(xCnt == oCnt + 1 && x3Cnt >= 1 && o3Cnt == 0) valid = true;
            // 2. o가 이긴 경우
            else if(xCnt == oCnt && x3Cnt == 0 && o3Cnt >= 1) valid = true;
            // 3. 무승부
            else if (xCnt == 5 && oCnt ==4 && x3Cnt == 0 && o3Cnt == 0) valid = true;
            else valid = false;
            
            System.out.println(valid ? "valid" : "invalid");
        }
    }
    
    private static void check(char[][] map) {
        o3Cnt = 0;
        x3Cnt = 0;
        int cnt = 0;
        char cmpChar = 'O';
        
        // 가로
        LOOP1:
        for(int i=0;i<3;i++) {
            int j;
            for(j=0;j<3;j++) {
                if(map[i][j] != cmpChar) continue LOOP1;
            }
            if(j == 3) o3Cnt++;
        }
        
        // 세로
        LOOP2:
        for(int i=0;i<3;i++) {
            int j;
            for(j=0;j<3;j++) {
                if(map[j][i] != cmpChar) continue LOOP2;
            }
            if(j == 3) o3Cnt++;
        }
        
        // 대각선
        if(map[0][0] == cmpChar && map[1][1] == cmpChar && map[2][2] == cmpChar) o3Cnt++;
        if(map[0][2] == cmpChar && map[1][1] == cmpChar && map[2][0] == cmpChar) o3Cnt++;

        cmpChar = 'X';

        // 가로
        LOOP1:
        for(int i=0;i<3;i++) {
            int j;
            for(j=0;j<3;j++) {
                if(map[i][j] != cmpChar) continue LOOP1;
            }
            if(j == 3) x3Cnt++;
        }
        
        // 세로
        LOOP2:
        for(int i=0;i<3;i++) {
            int j;
            for(j=0;j<3;j++) {
                if(map[j][i] != cmpChar) continue LOOP2;
            }
            if(j == 3) x3Cnt++;
        }
        
        // 대각선
        if(map[0][0] == cmpChar && map[1][1] == cmpChar && map[2][2] == cmpChar) x3Cnt++;
        if(map[0][2] == cmpChar && map[1][1] == cmpChar && map[2][0] == cmpChar) x3Cnt++;

    }
}