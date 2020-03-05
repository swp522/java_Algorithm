// 2020_03_02_BOJ_1520_내리막길
// DFS 탐색으로 결과값 3출력 되었으나 백준에서 시간초과
// 4 ^ (n x m) = 4 ^ 25000 -> dfs + dp 로 해결


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520_내리막길 {

    static int row, col;
    static int[][] map, dp, dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        dp[row - 1][col - 1] = 1;
        System.out.println(dfs(0, 0));
    }


    public static int dfs(int x, int y) {
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (dx >= 0 && dx < row && dy >= 0 && dy < col) {
                    if (map[dx][dy] < map[x][y]) {
                        dp[x][y] = dp[x][y] + dfs(dx, dy);
                    }
                }
            }
        }
        return dp[x][y];    //방문했던 곳은 바로 return
    }
}
