// 2020_12_28_월
// version 1.0

/*

    1. 1) 검이 이기면 1, 흰이 이기면 2, 승부 결정 전이면 0 출력하기

       2) 다섯 바둑알 중에서 가장 왼쪽에 있는 알의 좌표 출력하기

    2. 검 1, 흰 2, null 0

    3. 1) 가장 왼쪽 돌을 출력하니까 4방향 확인하기

       2) bfs 로 counting 해주기

       3) 육목인 경우 필터링 처리 -> bfs while 문에서 counting = 5 일 때

          '맨 왼쪽' 의 '바로 직전 돌' 을 확인하는 로직

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2615_오목 {

    static class Pair {
        int x;
        int y;
        int count;

        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[][] map;
    static int[][] dir = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int counting;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[20][20];

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) {
                    for (int d = 0; d < 4; d++) {
                        bfs(i, j, d);

                        if (counting == 5) {
                            System.out.println(map[i][j]);
                            System.out.print((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        System.out.print(0);
    }


    private static void bfs(int x, int y, int d) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 1));

        counting = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            counting = Math.max(p.count, counting);

            int dx = p.x + dir[d][0];
            int dy = p.y + dir[d][1];

            if (isRange(dx, dy) && map[dx][dy] == map[p.x][p.y]) {
                q.add(new Pair(dx, dy, p.count + 1));
            }
        }

        if (counting == 5) {
            int dx = x - dir[d][0];
            int dy = y - dir[d][1];

            if (isRange(dx, dy) && map[dx][dy] == map[x][y]) {
                counting++;
            }

        }
    }


    private static boolean isRange(int x, int y) {
        if (x >= 0 && x < 19 && y >= 0 && y < 19) {
            return true;
        } else {
            return false;
        }
    }
}
