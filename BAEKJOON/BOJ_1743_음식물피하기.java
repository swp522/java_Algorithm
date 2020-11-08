// 2020_11_08_일

/*

    1. 가장 큰 음식물 크기 출력

    2. 1 ≤ N ≤ 100  /  1 ≤ M ≤ 100  /  1 ≤ K ≤ 10,000

    3. bfs 로 음식물 붙어있는거 세주도록 구현하고 최대값 갱신하기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기 {

    static int n, m, k, count;
    static int[][] map, dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static boolean[][] visited;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    answer = Math.max(answer, count);
                }
            }
        }

        System.out.println(answer);
    }


    public static void bfs(int x, int y) {
        count = 1;
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int d = 0; d < 4; d++) {
                int dx = now[0] + dir[d][0];
                int dy = now[1] + dir[d][1];

                if (isRange(dx, dy) && map[dx][dy] == 1 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    count++;
                    q.add(new int[]{dx, dy});
                }
            }
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            return true;
        } else {
            return false;
        }
    }
}
