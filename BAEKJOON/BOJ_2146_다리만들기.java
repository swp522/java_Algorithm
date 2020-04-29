// 2020_04_28_수_과제_13회차_다리 만들기

/*
 * 1. 가장 짧은 다리로 대륙 연결하는 방법
 *
 * 2. 1 <= n <= 100
 *
 * 3. BFS 2번
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Island {
    int x, y;

    Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_2146_다리만들기 {

    static int n;
    static int[][] map, dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;
    static ArrayList<Island> list = new ArrayList<Island>();
    static Queue<Island> q = new LinkedList<Island>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    index += 1;
                    numbering(i, j, index);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Island island = list.get(i);
            makeBridges(island.x, island.y, map[island.x][island.y]);
        }

        System.out.println(min);
    }


    private static void numbering(int x, int y, int index) {
        q.add(new Island(x, y));
        visited[x][y] = true;
        map[x][y] = index;
        list.add(new Island(x, y));

        while (!q.isEmpty()) {
            Island island = q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = island.x + dir[i][0];
                int dy = island.y + dir[i][1];

                if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
                    if (map[dx][dy] == 1 && !visited[dx][dy]) {
                        map[dx][dy] = index;
                        q.add(new Island(dx, dy));
                        visited[dx][dy] = true;

                        if (map[dx][dy] != 0) {
                            list.add(new Island(dx, dy));
                        }
                    }
                }
            }
        }
    }


    private static void makeBridges(int x, int y, int index) {
        visited = new boolean[n][n];
        q.clear();
        q.add(new Island(x, y));
        visited[x][y] = true;

        int count = 0;
        boolean check = false;

        loop:
        while (!q.isEmpty()) {
            int qsize = q.size();
            for (int s = 0; s < qsize; s++) {
                Island island = q.poll();
                for (int i = 0; i < 4; i++) {
                    int dx = island.x + dir[i][0];
                    int dy = island.y + dir[i][1];

                    if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
                        if (map[dx][dy] == 0 && !visited[dx][dy]) {
                            q.add(new Island(dx, dy));
                            visited[dx][dy] = true;
                        }
                        if (map[dx][dy] != 0 && map[dx][dy] != index) {
                            check = true;   // check 되야 min 비교
                            break loop;
                        }
                    }
                }
            }

            count += 1; //전진하고 큐에 들어갔는데 그 '턴' 의 큐들 다 확인한 후에 count + 1 !! 또 큐에 있으면 다시 poll!
        }

        if (check) {
            if (min > count) {
                min = count;
            }
        }
    }
}
