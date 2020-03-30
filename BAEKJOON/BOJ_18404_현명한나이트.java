//2020_03_30_월_과제_22회차_현명한 나이트
// bfs로 나이트 기준 갈 수 있는 모든 경우 이동 횟수 time을 map에 저장함
// main 에서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chess {
    int x, y, time;

    public Chess(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class BOJ_18404_현명한나이트 {

    static int n, m, targetX, targetY;
    static int[][] map, dir = {{-2, -1}, {2, 1}, {-1, -2}, {1, 2}, {-2, 1}, {2, -1}, {-1, 2}, {1, -2}};
    static boolean[][] visited;
    static Queue<Chess> q = new LinkedList<Chess>();
//    static ArrayList<Chess> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        int xNight = Integer.parseInt(st.nextToken());
        int yNight = Integer.parseInt(st.nextToken());
        q.add(new Chess(xNight, yNight, 0));
        visited[xNight][yNight] = true;

        bfs();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            System.out.print(map[targetX][targetY] + " ");
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Chess knight = q.poll();
            for (int i = 0; i < 8; i++) {
                int dx = knight.x + dir[i][0];
                int dy = knight.y + dir[i][1];
                if (dx >= 1 && dy >= 1 && dx <= n && dy <= n) {
                    if (!visited[dx][dy]) {
                        map[dx][dy] = knight.time + 1;
                        visited[dx][dy] = true;
                        q.add(new Chess(dx, dy, knight.time + 1));
                    }
                }
            }
        }
    }
}
