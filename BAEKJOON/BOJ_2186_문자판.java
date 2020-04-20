// 2020_04_19_월_과제_28회차_문자판

/*
 * 1. 영단어를 만들 수 있는 경로의 총 개수 구하기
 *
 * 2. 1 <= N, M <= 100  1 <= K <= 5
 *
 * 3. DP, DFS
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2186_문자판 {

    static int row, col, k;
    static char map[][];
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][][] dp;
    static char[] targetWord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        targetWord = br.readLine().toCharArray();
        int len = targetWord.length;
        dp = new int[row][col][len];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(dp[i][j], -1);  // 방문 안한곳 -1
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer += dfs(i, j, 0);
            }
        }

        System.out.println(answer);
    }

    static int dfs(int x, int y, int index) {
        // 마지막 문자열까지 다 같으면 1 리턴
        if(index == targetWord.length - 1){
            return 1;
        }

        // 방문한 곳이면 해당 index로 dp에 저장한 값 활용
        if (dp[x][y][index] != -1) {
            return dp[x][y][index];
        }

        // 문자가 맞지 타겟과 맞지 않으면 0으로 채우고 0리턴
        if (map[x][y] != targetWord[index]) {
            dp[x][y][index] = 0;
            return 0;
        }

        dp[x][y][index] = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                int dx = x + dir[i][0] * j;
                int dy = y + dir[i][1] * j;

                if (dx >= 0 && dy >= 0 && dx < row && dy < col && map[dx][dy] == targetWord[index + 1]) {
                    dp[x][y][index] += dfs(dx, dy, index + 1);
                }
            }
        }
        return dp[x][y][index];
    }
}
