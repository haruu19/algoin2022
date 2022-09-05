package algoin2022;

import java.io.*;
import java.util.Stack;

public class Boj_9012_괄호_S4_스택 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        LOOP:
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    s.push('(');
                } else {
                    if (s.isEmpty()) {
                        System.out.println("NO");
                        continue LOOP;
                    }
                    s.pop();
                }
            }
            System.out.println(s.isEmpty() ? "YES" : "NO");
        }
    }
}