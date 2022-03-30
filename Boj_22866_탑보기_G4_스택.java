package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_22866_탑보기_G4_스택 {
    static int N;
    static int[] a;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        a = new int[N];
        ans = new int[N][3]; // 0 : cnt, 1 : len, 2 : idx
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) a[i] = Integer.parseInt(st.nextToken());
        Stack<Integer[]> s = new Stack<>();
        
        // 왼쪽에서 볼 수 있는 건물 갯수
        for(int i=0;i<N;i++) {
            while(!s.isEmpty()) {
                if(s.peek()[1] <= a[i]) s.pop();
                else break;
            }
            if(!s.isEmpty()) {
                ans[i][0] += s.size();
                ans[i][1] = Math.abs((i+1) - s.peek()[0]);
                ans[i][2] = s.peek()[0];
            }
            s.add(new Integer[] {i+1, a[i]});
        }
        
        s.clear();
        
        // 오른쪽에서 볼 수 있는 건물 갯수
        for(int i=N-1;i>=0;i--) {
            while(!s.isEmpty()) {
                if(s.peek()[1] <= a[i]) s.pop();
                else break;
            }
            if(!s.isEmpty()) {
                int sub = Math.abs((i+1) - s.peek()[0]);
                if(ans[i][0] == 0) ans[i][2] = s.peek()[0];
                if(ans[i][1] > sub) {
                    ans[i][1] = sub;
                    ans[i][2] = s.peek()[0];
                }
                ans[i][0] += s.size();
            }
            s.add(new Integer[] {i+1, a[i]});
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            sb.append(ans[i][0]);
            if(ans[i][0] > 0) sb.append(" " + ans[i][2]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

}