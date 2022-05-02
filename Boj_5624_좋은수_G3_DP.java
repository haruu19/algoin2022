package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_5624_좋은수_G3_DP {
    static int N,ans;
    static int[] a;
    static boolean[] m;
    static final int C = 200000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        m = new boolean[2 * C + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        
        for(int k=0;k<N;k++) {
            // step1. x + y = k - z 이며, x,y,z는 k 앞의 모든 수
            for(int z=0;z<k;z++) {
                if(m[a[k] - a[z] + C]) {
                    ans++;
                    break;
                }
            }
            
            // step2. x ~ k 두 번만 사용하여 만들 수 있는 수 메모
            for(int i=0;i<=k;i++) {
                m[a[k] + a[i] + C] = true;
            }
        }
        
        System.out.println(ans);
    }
}