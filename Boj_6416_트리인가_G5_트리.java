package algoin2022;

import java.util.*;
public class Boj_6416_트리인가_G5_트리 {
    static boolean isTree;
    static boolean[] v;
    static List<Integer>[] list;
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int maxIdx = 0;
        int tc = 1;
        
        while(true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if(a == -1 && b == -1) break;
            
            if(a == 0 && b == 0) {
                list = new List[maxIdx+1];
                
                for(int i=1;i<=maxIdx;i++) list[i] = new ArrayList<>();
                for(int i=0;i<list1.size();i++) {
                    list[list1.get(i)].add(list2.get(i));
                }
                int[] inEdgeChk = new int[maxIdx+1];
                v = new boolean[maxIdx+1];
                for(int i=0;i<list2.size();i++) inEdgeChk[list2.get(i)]++;
                isTree = true;
                int rootIdx = -1;
                Iterator<Integer> it = set.iterator();
                while(it.hasNext()) {
                    int inEdgeZeroCnt = 0;
                    int idx = it.next();
                    
                    if(inEdgeChk[idx] == 0) {
                        inEdgeZeroCnt++;
                        rootIdx = idx;
                        
                        if(inEdgeZeroCnt > 1) {
                            isTree = false;
                            break;
                        }
                    }
                    if(inEdgeChk[idx] > 1) {
                        isTree = false;
                        break;
                    }
                }
                if(rootIdx == -1) {
                    if(set.size() != 0) {
                        isTree = false;
                    }
                } else if(rootIdx != -1 && isTree) {
                    v[rootIdx] = true;
                    dfs(rootIdx);
                    
                    for(int i=0;i<=maxIdx;i++) {
                        if(set.contains(i) && !v[i]) {
                            isTree = false;
                            break;
                        }
                    }
                }
                if(isTree) System.out.println("Case " + tc + " is a tree.");
                else System.out.println("Case " + tc + " is not a tree."); 
                list1 = new ArrayList<>();
                list2 = new ArrayList<>();
                maxIdx = 0;
                tc++;
                set = new HashSet<>();
                
                continue;
            }
            
            list1.add(a);
            list2.add(b);
            set.add(a);
            set.add(b);
            maxIdx = Math.max(maxIdx, a);
            maxIdx = Math.max(maxIdx, b);
        }
    }
    
    private static void dfs(int idx) {
        for(Integer i : list[idx]) {
            if(v[i]) continue;
            v[i] = true;
            dfs(i);
        }
    }
}