package algoin2022;


import java.io.*;
import java.util.*;

public class Boj_1595_북쪽나라의도로_G3_트리지름 {
    static int N,ans;
    static List<Node>[] list;
    static class Node {
        int idx;
        int cost;
        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        String input = "";
        List<String> inputList = new ArrayList<>();
        while((input = br.readLine()) != null && !input.isEmpty()) {
            inputList.add(input);
        }
        N = inputList.size() + 1;
        list = new List[N+1];
        v = new boolean[N+1];
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(String s : inputList) {
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        for(int i=1;i<=N;i++) {
            dfs(i,0);
        }
        System.out.println(ans);
    }
    private static void dfs(int idx, int cost) {
        v[idx] = true;
        ans = Math.max(ans,cost);
        for(Node n : list[idx]) {
            if(!v[n.idx]) dfs(n.idx, cost + n.cost);
        }
        v[idx] = false;
    }
}