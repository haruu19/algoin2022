package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_6137_문자열생성_G4_투포인터 {
    static int N;
    static char[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        a = new char[N];
        for(int i=0;i<N;i++) a[i] = br.readLine().charAt(0);
        int l = 0;
        int r = N-1;
        int cnt = 0;
        while(l <= r) {
            if(a[l] < a[r]) {
                sb.append(a[l]);
                l++;
            } else if(a[l] == a[r]) {
                int l2 = l;
                int r2 = r;
                boolean flag = false;
                while(l2 <= r2) {
                    if(a[l2] < a[r2]) {
                        flag = true;
                        sb.append(a[l++]);
                        break;
                    } else if(a[l2] == a[r2]) {
                        l2++;
                        r2--;
                    } else {
                        flag = true;
                        sb.append(a[r--]);
                        break;
                    }
                }
                if(!flag) sb.append(a[l++]);
            } else {
                sb.append(a[r]);
                r--;
            }
            cnt++;
            if(cnt % 80 == 0) sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}