package algoin2022;

import java.io.*;
import java.util.*;

public class Boj_18234_당근훔쳐먹기_G3_그리디 {
    static int N,T;
    static long cnt,sum;
    static class Carrot implements Comparable<Carrot> {
    	long initVal;
    	long p;
        public Carrot(long initVal, long p) {
            this.initVal = initVal;
            this.p = p;
        }
        @Override
        public int compareTo(Carrot o) {
        	if(o.p < this.p) {
        		return -1;
        	} else if(o.p == this.p) {
        		return 0;
        	} else {
        		return 1;
        	}
        }
    }
    static Carrot[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new Carrot[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Carrot(a,b);
        }
        Arrays.sort(arr);
        cnt = T - 1;
        for(int i=0;i<N;i++) {
            sum += arr[i].p * cnt + arr[i].initVal;
            cnt--;
        }
        System.out.println(sum);
    }
}