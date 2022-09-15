package algoin2022.codetree.day1;

import java.io.*;
import java.util.*;

public class 학생의_등수 {
    static class Score implements Comparable<Score> {
        int idx;
        int math;
        int english;

        public Score(int idx, int math, int english) {
            this.idx = idx;
            this.math = math;
            this.english = english;
        }

        @Override
        public int compareTo(Score o) {
            if(this.math == o.math) {
                return o.english - this.english;
            }
            return o.math - this.math;
        }
    }
    static int N;
    static int[] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        List<Score> list = new ArrayList<>();
        rank = new int[N+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Score(i+1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int cnt = 1;
        for(Score s : list) {
            rank[s.idx] = cnt++;
        }
        for(int i=1;i<=N;i++) {
            System.out.println(rank[i]);
        }
    }
}
