// 2020_06_10_수_디저트 카페

/*
 * 1. 디저트 가장 많이 먹을 때 디저트 수 구하기
 *
 * 2. 4 <= n <= 20,  1 <= 디저트 수 <= 100
 *
 * 3. dfs, 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {

    static int n, answer;
    static int[][] map, dir = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            answer = -1;
            n = Integer.parseInt(br.readLine());
            check = new boolean[101];
            map = new int[n][n];


            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    check[map[i][j]] = true;
                    dfs(i, j, 0, i, j, 1);
                    check[map[i][j]] = false;
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }


    public static void dfs(int x, int y, int startDir, int startX, int startY, int count) {
        for (int i = 0; i < 2; i++) {

            if (startDir + i == 4) {
                return;
            }

            int d = startDir + i;
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (isRange(dx, dy)) {
                if (dx == startX && dy == startY) {
                    answer = Math.max(answer, count);
                    return;
                }

                if (!check[map[dx][dy]]) {

                    check[map[dx][dy]] = true;
                    dfs(dx, dy, d, startX, startY, count + 1);
                    check[map[dx][dy]] = false;
                }
            }
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        } else {
            return false;
        }
    }

}
