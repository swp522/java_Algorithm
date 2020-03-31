// 2020_04_01_수_과제_9회차_이동하기
// 탐색쓰면 시간 초과 발생 >> DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기 {

    static int row, col, maxValue;
    static int[][] map, dir = {{1, 0}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row + 1][col + 1];
        maxValue = 0;

        for (int i = 1; i <= row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solveByDP();
//        dfs(1, 1, map[1][1]);
//        System.out.println(maxValue);
    }


    public static void dfs(int x, int y, int sum) {
        if (x == row && y == col) {
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];

            if (dx > 0 && dy > 0 && dx <= row && dy <= col) {
                dfs(dx, dy, sum + map[dx][dy]);
            }
        }
    }

    public static void solveByDP() {
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j - 1])) + map[i][j];
            }
        }
        System.out.println(dp[row][col]);
    }
}
