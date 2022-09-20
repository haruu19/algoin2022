package algoin2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16235_나무제태크 {
    static int N, M, K;
    static int[][] a;
    static int[][] map;
    static PriorityQueue<Tree> q = new PriorityQueue<>();
    static Queue<Tree> tmp = new LinkedList<>();
    static Queue<Tree> die = new LinkedList<>();
    static boolean[] isDead;
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(map[i], 5);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        for (int t = 0; t < K; t++) {
            // 봄
            // 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가
            // 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다
            while (!q.isEmpty()) {
                Tree tree = q.poll();
                if(map[tree.x][tree.y] < tree.age) {
                    die.add(tree);
                    continue;
                }
                map[tree.x][tree.y] -= tree.age;
                tree.age += 1;
                tmp.add(tree);
            }

            // 여름
            // 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
            while (!die.isEmpty()) {
                Tree tree = die.poll();
                map[tree.x][tree.y] += tree.age / 2;
            }

            // 가을
            // 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            while (!tmp.isEmpty()) {
                Tree tree = tmp.poll();
                q.add(tree);
                if(tree.age % 5 != 0) continue;
                for (int k = 0; k < 8; k++) {
                    int nx = tree.x + dx[k];
                    int ny = tree.y + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    q.add(new Tree(nx, ny, 1));
                }
            }

            // 겨울
            // 땅을 돌아다니면서 땅에 양분을 추가한다. 각 칸에 추가되는 양분의 양은 A[r][c]
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] += a[i][j];
                }
            }
        }
        System.out.println(q.size());
    }
}
