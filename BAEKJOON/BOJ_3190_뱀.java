// 2020_05_29_금_과제_뱀

/*
 * 1. 게임이 끝나는데 몇 초 걸리는지 구하기
 *
 * 2. 2 ≤ N ≤ 100, 0 ≤ K ≤ 100, 1 ≤ L ≤ 100
 *
 * 3. 벽이나 자기 몸에 부딪히면 종료
 *
 * 4. 초반에 L과 D를 제대로 읽지 않고 그냥 4방향 이동하는 거로 대충 파악함
 *
 *    방향 전환 왼쪽이면 + 3 하고, 오른쪽이면 + 1 해준 다으마에 %4 로 처리
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

    static int n, k, l;
    static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};   // 위, 오른, 아래, 왼
    static int[] time, direction;
    static LinkedList<Point> snake = new LinkedList<Point>();

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());    // 사과 개수
        map = new int[n][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int appleRow = Integer.parseInt(st.nextToken()) - 1;
            int appleCol = Integer.parseInt(st.nextToken()) - 1;
            map[appleRow][appleCol] = 1;
        }

        l = Integer.parseInt(br.readLine());    // 방향 변환 횟수
        time = new int[l];
        direction = new int[l];

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            direction[i] = getDirection(st.nextToken());
        }

        solve();
    }


    private static int getDirection(String s) {
        if (s.equals("D")) {
            return 1;
        } else {
            return 3;
        }
    }


    public static void solve() {
        int sec = 0;
        int snakeDir = 1;   // 초기 방향 오른쪽
        int timeIndex = 0;
        map[0][0] = 2;
        snake.add(new Point(0, 0));

        while (true) {
            // 방향 전환
            if (timeIndex < l && time[timeIndex] == sec) {
                snakeDir = (snakeDir + direction[timeIndex]) % 4;
                timeIndex++;
            }
            // 머리 위치를 한칸 전진 시킴
            int dx = snake.getFirst().x + dir[snakeDir][0];
            int dy = snake.getFirst().y + dir[snakeDir][1];

            // 벽에 부딪히면 끝
            if (!isRange(dx, dy)) {
                System.out.println(sec + 1);
                break;
            }

            // 몸에 부딪히면 끝
            if (map[dx][dy] == 2) {
                System.out.println(sec + 1);
                break;
            }

            // 사과 먹은 경우와 통로 지나는 경우
            if (map[dx][dy] == 1) {
                map[dx][dy] = 2;
                snake.addFirst(new Point(dx, dy));
            } else if (map[dx][dy] == 0) {
                map[dx][dy] = 2;
                snake.addFirst(new Point(dx, dy));

                Point tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }

            sec++;
        }
    }


    private static boolean isRange(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        } else {
            return false;
        }
    }

}
