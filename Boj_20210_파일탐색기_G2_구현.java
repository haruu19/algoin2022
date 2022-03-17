package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_20210_파일탐색기_G2_구현 {
    static int N;
    static String[] arr;
    static int[] pri = new int[123];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        
        for(int i=0;i<N;i++) {
            arr[i] = br.readLine();
        }
        
        int cnt = 0;
        for(int i=65;i<=90;i++) {
            pri[i] = cnt++;
            pri[i+32] = cnt++;
        }
        
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                List<String> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                
                // 문자열을 natural sort 단위로 나눈다
                split(o1, list1);
                split(o2, list2);
                
                int size = (list1.size() < list2.size()) ? list1.size() : list2.size();
                
                // 두 리스트 중 size가 작은 리스트의 size만큼 두 리스트 요소 인덱스 별 비교
                for(int i=0;i<size;i++) {
                    String s1 = list1.get(i);
                    String s2 = list2.get(i);
                    
                    // 같은 단어이면 continue;
                    if(s1.equals(s2)) {
                        continue;
                    } else {
                        // 숫자열 : 문자열인 경우
                        if(isNum(s1.charAt(0)) != isNum(s2.charAt(0))) {
                            return isNum(s1.charAt(0)) - isNum(s2.charAt(0));
                        } else {
                            // 둘 다 숫자열인 경우
                            if(isNum(s1.charAt(0)) == 0) {
                                // 앞에 0 제거
                                int zeroCnt1 = countPreZero(s1);
                                int zeroCnt2 = countPreZero(s2);
                                s1 = remove(s1);
                                s2 = remove(s2);
                                
                                // 같은 값이지만 앞에 붙은 0 개수가 다른 문자열
                                if(s1.equals(s2)) {
                                    return zeroCnt1 - zeroCnt2;
                                } else {
                                    // 자리수가 다른 경우
                                    if(s1.length() != s2.length()) return s1.length() - s2.length();
                                    else {
                                        for(int j=0;j<s1.length();j++) {
                                            if(s1.charAt(j) != s2.charAt(j)) return s1.charAt(j) - s2.charAt(j);
                                        }
                                    }
                                }
                            }
                            // 둘 다 문자열인 경우
                            else {
                                int len = (s1.length() < s2.length()) ? s1.length() : s2.length();
                                for(int j=0;j<len;j++) {
                                    if(s1.charAt(j) != s2.charAt(j)) return pri[s1.charAt(j)] - pri[s2.charAt(j)];
                                }
                                if(s1.length() != s2.length()) return s1.length() - s2.length();
                            }
                        }
                    }
                }
                
                // 앞에서 인덱스 별 비교값은 모두 같지만 리스트 size가 서로 다른 경우
                if(list1.size() != list2.size()) {
                    return list1.size() - list2.size();
                } else {
                    return 0;
                }
            }
            
            private int countPreZero(String s) {
                if(s.charAt(0) != '0') return 0;
                int cnt = 0;
                for(int i=0;i<s.length();i++) {
                    if(s.charAt(i) != '0') break;
                    cnt++;
                }
                return cnt;
            }
            
            private String remove(String s) {
                if(s.charAt(0) != '0') return s;
                boolean isAllZero = true;
                int idx = 0;
                for(int i=0;i<s.length();i++) {
                    if(s.charAt(i) != '0') {
                        isAllZero = false;
                        idx = i;
                        break;
                    }
                }
                return isAllZero ? "0" : s.substring(idx, s.length());
            }
            
            private void split(String s, List<String> list) {
                int prevState = 0;
                int curState = 0;
                int idx = 0;
                for(int i=0;i<s.length();i++) {
                    curState = isNum(s.charAt(i));
                    if(i == 0) prevState = curState;
                    if(prevState != curState) {
                        list.add(s.substring(idx, i));
                        idx = i;
                    }
                    prevState = curState;
                }
                
                if(s.length() != idx) list.add(s.substring(idx, s.length()));
            } 
            
            private int isNum(char ch) {
                if(ch >= '0' && ch <= '9') return 0;
                else return 1;
            }
         });
        
        for(String s : arr) System.out.println(s);
    }
    
    
}