// 2020_04_27_월_과제_30회차_미로 탈출하기

/*
 * 1. 탈출가능한 칸의 개수
 *
 * 2. 3 ≤ N, M ≤ 500
 *
 * 3. dp, loop 찾기?
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17090_미로탈출하기 {

    static int row, col, answer;
    static char[][] map;
    static int[][] visited, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visited = new int[row][col];
        answer = 0;

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                visited[i][j] = -1;
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == -1) {
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }


    public static int dfs(int x, int y) {
        if (visited[x][y] != -1) {
            return visited[x][y];
        }

        char target = map[x][y];
        int value = 0;

        visited[x][y] = 0;

        if (target == 'U') {
            if (x == 0) {
                value = 1;
            } else {
                value = dfs(x - 1, y);
            }
        } else if (target == 'R') {
            if (y == col - 1) {
                value = 1;
            } else {
                value = dfs(x, y + 1);
            }
        } else if (target == 'L') {
            if (y == 0) {
                value = 1;
            } else {
                value = dfs(x, y - 1);
            }
        } else if (target == 'D') {
            if (x == row - 1) {
                value = 1;
            } else {
                value = dfs(x + 1, y);
            }
        }
        visited[x][y] = value;

        return visited[x][y];
    }
}
