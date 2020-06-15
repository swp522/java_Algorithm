// 2020_06_16_화_40회차_과제2_점프왕쩰리Large

/*
 * 1. 끝점에 도달할 수 있는지 없는지 구하기
 *
 * 2. 2 ≤ N ≤ 64 , 마지막 칸 값 = -1 , 0 <= 나머지 칸 값 <= 100
 *
 * 3. dfs로 구현 -> 시간초과 -> dp 인가..
 *
 *    재귀 타면서 visited 처리할 떄 false 안해주니까 통과
 *
 *    재귀 개념 또 흔들렸는데 (x, y)와 2가지 (dx, dy) 좌표 그려놓고 뒤에서 부터 생각해보기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16174_점프왕쩰리Large {

    static int[][] map, dir = {{1, 0}, {0, 1}};
    static boolean[][] visited;
    static int n;
    static boolean arrived;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[65][65];
        arrived = false;
        visited = new boolean[65][65];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        if (arrived) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }


    public static void solve(int x, int y) {
        if (map[x][y] == -1) {
            arrived = true;
            return;
        } else {
            for (int i = 0; i < 2; i++) {
                int dx = x + (dir[i][0] * map[x][y]);
                int dy = y + (dir[i][1] * map[x][y]);

                if (isRange(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    solve(dx, dy);
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
