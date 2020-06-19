// 2020_06_19_금_41회차_과제2_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유

/*
 * 1. 3, 4, 5 중에서 2가 가장 먼저 도착하는 곳까지의 최단거리 구하기 (가능 여부에 따라 문자열도 출력)
 *
 * 2. 1 ≤ n,m ≤ 3000, 4 ≤ n×m ≤ 9×10^6 , 2 3 4 5 는 1개씩만 존재함
 *
 * 3. bfs 로 최단거리 구하기 구현
 *
 * 4. 혼자서 탐색 문제 이정도 난이도는 구현 가능해짐
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17129_윌리암슨수액빨이딱따구리가_정보섬에_올라온_이유 {

    static int n, m, answer;
    static int[][] map, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean flag;
    static boolean[][] visited;
    static Queue<Place> q;

    static class Place {
        int x, y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    bfs(new Place(i, j));
                }
            }
        }

        if (flag) {
            System.out.println("TAK");
            System.out.println(answer);
        } else {
            System.out.println("NIE");
        }
    }


    public static void bfs(Place place) {
        q = new LinkedList<>();
        q.add(place);
        int count = 0;
        answer = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            int qSize = q.size();
            for (int round = 0; round < qSize; round++) {

                Place target = q.poll();

                if (map[target.x][target.y] > 2) {
                    answer = Math.min(answer, count);
                    flag = true;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int dx = target.x + dir[i][0];
                    int dy = target.y + dir[i][1];

                    if (isRange(dx, dy) && !visited[dx][dy] && map[dx][dy] != 1) {
                        visited[dx][dy] = true;
                        q.add(new Place(dx, dy));
                    }
                }
            }

            count++;
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
