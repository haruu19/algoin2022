package algoin2022.codetree.day2;

import java.util.*;

public class 숫자_뒤집기_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        boolean isNotZero = false;
        for(int i=s.length()-1;i>=0;i--) {
            if(!isNotZero) {
                if(s.charAt(i) != '0') {
                    isNotZero = true;
                } else {
                    continue;
                }
            }
            sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
