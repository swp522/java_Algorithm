// 2020_05_13_수_과제_15회차_나무 재테크

/*
 * 1. k 년후 나무의 개수 구하기
 *
 * 2. 1 ≤ K ≤ 1,000, 1 ≤ z(나이) ≤ 10
 *
 * 3. 처음부터 끝까지 구현
 *
 *    가장 처음 야분 5씩 들어있는거 놓침
 *
 *    나무 정보 x, y, z 주어져서 기계적으로 bfs 라고 생각했음
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235_나무재테크 {

    static class Tree {
        int x, y, z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int n, m, k;
    static int[][] A, nutritions, dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1},{0, -1} ,{-1, -1}};
    static ArrayList<Integer>[][] treeAgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[n + 1][n + 1];  // 4계절 지나고 각 칸에 추가되는 영양분
        nutritions = new int[n + 1][n + 1]; // 현재 갖고 있는 영양분
        treeAgeList = new ArrayList[n + 1][n + 1]; // 각 위치마다 나무들 저장

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                treeAgeList[i][j] = new ArrayList<>();
                nutritions[i][j] = 5;
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());   // 나무 나이
            treeAgeList[x][y].add(z);  // 해당 위치 list에 나무들 저장
        }

        for (int year = 0; year < k; year++) {
            springAndSummer();
            fall();
            winter();
        }

        int answer = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                answer += treeAgeList[i][j].size();
            }
        }

        System.out.println(answer);
    }


    private static void springAndSummer() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int sum = 0;
                Collections.sort(treeAgeList[i][j], comparator);
                ArrayList<Integer> alive = new ArrayList<>();    // 죽지 않고 나이가 증가된 나무들 저장

                for (int k = 0; k < treeAgeList[i][j].size(); k++) {
                    int tree = treeAgeList[i][j].get(k);

                    if (nutritions[i][j] >= tree) {
                        nutritions[i][j] -= tree;
                        alive.add(tree + 1);
                    } else {
                        sum += (tree / 2);
                    }
                }

                treeAgeList[i][j] = alive; // (i ,j) 나무들 treeAgeList 갱신
                nutritions[i][j] += sum;
            }
        }
    }


    private static void fall() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < treeAgeList[i][j].size(); k++) {

                    int tree = treeAgeList[i][j].get(k);
                    if (tree % 5 == 0) {
                        for(int d = 0; d < 8; d++){
                            int dx = i + dir[d][0];
                            int dy = j + dir[d][1];

                            if(isRange(dx, dy)){
                                treeAgeList[dx][dy].add(1);
                            }
                        }
                    }

                }
            }
        }

    }


    private static void winter() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nutritions[i][j] += A[i][j];
            }
        }

    }


    public static boolean isRange(int x, int y) {
        if (x >= 1 && y >= 1 && x <= n && y <= n) {
            return true;
        } else {
            return false;
        }
    }


    static Comparator<Integer> comparator = new Comparator<Integer>() {

        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };

}
