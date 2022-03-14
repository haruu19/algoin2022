import java.io.;
import java.util.;

public class Boj_1135_뉴스전하기_G1_트리DP {
    static int N;
    static int[] d;
    static ListInteger[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for(int i=0;iN;i++) list[i] = new ArrayList();
        d = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;iN;i++) {
            int n = Integer.parseInt(st.nextToken());
            if(i == 0) continue;
            list[n].add(i);
        }
        
        dfs(0);
        System.out.println(d[0]);
    }
    
    static void dfs(int n) {
        if(list[n].isEmpty()) {
            return;
        }
        int max = Integer.MIN_VALUE;
        ListInteger tmp = new ArrayList();
        for(int ele  list[n]) {
            dfs(ele);
            tmp.add(d[ele]);
        }
        Collections.sort(tmp, Collections.reverseOrder());
        for(int i=0;itmp.size();i++) {
            tmp.set(i, tmp.get(i) + (i+1));
        }
        for(int ele  tmp) max = Math.max(max, ele);
        d[n] = max;
    }
}