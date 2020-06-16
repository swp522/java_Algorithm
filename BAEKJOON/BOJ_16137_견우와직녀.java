// 2020_06_16_화_40회차_과제1_견우와 직녀

/*
 * 1. 견우가 직녀에게 도착하는 최소 시간 구하기
 *
 * 2. 2 ≤ N ≤ 10,  2 ≤ M ≤ 20,  0 <= 각 칸 값 <= 20
 *
 * 3. 1). bfs 탐색 전에 절벽이 교차하는지 체크
 *
 *    2). 골랐으면 주기 m 설정하고 bfs() 시작
 *
 *    3). (0, 0) 부터 시작해서 탐색 시작
 *
 *    4). 그냥 길 / 두번 연속 오작교 못 건넘 / 주기가 있을 조건 구현
 *
 * 4. 문제 이해가 너무 오래 걸렸다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16137_견우와직녀 {

    static int n, m, answer;
    static int[][] map, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};   // 남 동 북 서
    static boolean[][] visited;
    static Queue<Place> q;

    static class Place {
        int x, y, time;

        public Place(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        map = new int[n][n];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkIfTheCliffsCross();

        System.out.println(answer);
    }


    public static void checkIfTheCliffsCross() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    boolean[] cliffs = new boolean[4];

                    for (int d = 0; d < 4; d++) {
                        int dx = i + dir[d][0];
                        int dy = j + dir[d][1];

                        if (isRange(dx, dy) && map[dx][dy] == 0) {
                            cliffs[d] = true;
                        }
                    }

                    if ((cliffs[0] && cliffs[1]) || (cliffs[1] && cliffs[2]) ||
                            (cliffs[2] && cliffs[3]) || (cliffs[3] && cliffs[0])) {
                        continue;
                    }

                    map[i][j] = m;
                    visited = new boolean[n][n];
                    bfs();
                    map[i][j] = 0;
                }
            }
        }
    }


    public static void bfs() {
        visited[0][0] = true;
        q.add(new Place(0, 0, 0));

        while (!q.isEmpty()) {
            Place position = q.poll();

            if (position.x == n - 1 && position.y == n - 1) {
                answer = Math.min(answer, position.time);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int dx = position.x + dir[i][0];
                int dy = position.y + dir[i][1];

                if (isRange(dx, dy) && !visited[dx][dy]) {
                    if (map[dx][dy] == 1) {
                        visited[dx][dy] = true;
                        q.add(new Place(dx, dy, position.time + 1));
                    }

                    if (map[dx][dy] > 1 && map[position.x][position.y] == 1) {
                        if ((position.time + 1) % map[dx][dy] == 0) {
                            visited[dx][dy] = true;
                            q.add(new Place(dx, dy, position.time + 1));
                        } else {
                            q.add(new Place(position.x, position.y, position.time + 1));
                        }
                    }
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
