package algoin2022.codetree.day2;

import java.io.*;
import java.util.*;

public class 오직_한번만_주어진_수_해쉬맵 {
    static int N, cnt, ans =  -1, minVal = Integer.MAX_VALUE;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map1 = new HashMap<>(); // key : 숫자, val : 순서
        Map<Integer, Integer> map2 = new HashMap<>(); // key : 숫자, val : 카운트
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            map1.put(a[i], cnt++);
            map2.put(a[i], map2.getOrDefault(a[i], 0) + 1);
        }

        Set<Integer> set = map2.keySet();
        for(Integer num : set) {
            if(map2.get(num) == 1 && map1.get(num) < minVal) { // 한 번만 주어진 수이고 먼저 주어진 수이면
                minVal = map1.get(num);
                ans = num;
            }
        }
        System.out.println(ans);
    }
}
