package algoin2022.codetree.day1;

import java.util.*;

public class 문자열_수정하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char ch = s.charAt(1);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ch) {
                sb.append(s.charAt(4));
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
