// 2020_06_17_수_등산로 조성

/*
 * 1. 가장 긴 등산로 길이 구하기
 *
 * 2. 3 ≤ N ≤ 8,  1 ≤ K ≤ 5,  1 <= 봉우리 높이 <= 20,  가장 높은 봉우리 최대 5개
 *
 * 3. DFS, 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {

    static int n, k, maxValue, answer;
    static int[][] mountain;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            mountain = new int[n][n];
            visited = new boolean[n][n];

            answer = Integer.MIN_VALUE;
            maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    mountain[i][j] = Integer.parseInt(st.nextToken());
                    maxValue = Math.max(maxValue, mountain[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mountain[i][j] == maxValue) {
                        dfs(i, j, 1, false);
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }


    public static void dfs(int x, int y, int count, boolean constructed) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if (dx >= 0 && dx < n && dy >= 0 && dy < n && !visited[dx][dy]) {
                if (mountain[dx][dy] < mountain[x][y]) {
                    dfs(dx, dy, count + 1, constructed);
                } else {
                    if (!constructed) {
                        for (int j = 1; j <= k; j++) {
                            if (mountain[dx][dy] - j < mountain[x][y]) {
                                mountain[dx][dy] -= j;
                                dfs(dx, dy, count + 1, true);
                                mountain[dx][dy] += j;
                            }
                        }
                    }
                }
            }
        }

        visited[x][y] = false;
        answer = Math.max(answer, count);
    }
}
