package algoin2022;

import java.util.*;

public class Boj_12931_두배더하기_G4_그리디 {
	static int N,ans;
	static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new int[N];
        for(int i=0;i<N;i++) a[i] = sc.nextInt();
        while(true) {
        	for(int i=0;i<N;i++) {
        		if(a[i] % 2 != 0) {
        			a[i]--;
        			ans++;
        		}
        		a[i] /= 2;
        	}
        	if(isAllElemsAreZero()) {
        		System.out.println(ans);
        		break;
        	} else {
        		ans++;
        	}
        }
    }
	private static boolean isAllElemsAreZero() {
		for(int i=0;i<N;i++) {
			if(a[i] != 0) return false;
		}
		return true;
	}
}