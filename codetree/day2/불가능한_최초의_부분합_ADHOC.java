package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 불가능한_최초의_부분합_ADHOC {
    static int N, sum;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine().trim());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        for (int i = 0; i < N; i++) {
            if (sum + 1 < a[i]) {
                break;
            }
            sum += a[i];
        }
        System.out.println(sum + 1);
    }
}
