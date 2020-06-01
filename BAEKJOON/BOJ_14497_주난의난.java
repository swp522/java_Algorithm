// 2020_06_01_월_과제_주난의 난_1

/*
 * 1. 주난이가 범인찾으려면 몇 번 점프해야 하는지 구하기
 *
 * 2. 1 <= N,M <= 300,  1 <= x1,x2 <= N,  1 <= y1,y2 <= M
 *
 * 3. 4방향 bomb 할 때, 300길이 만큼 * 해줘서 쭉 접근할 수 있도록 해주기
 *
 *    이걸 뭔가 dfs()로 0찾고, bomb()하고 반복해야한다고 처음에 생각했음
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497_주난의난 {

    static int n, m, count, startX, startY, endX, endY;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, map;
    static boolean[][] visited;
    static Queue<Node> q;
    static boolean flag;

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        count = 1;
        flag = false;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        while (true) {
            q = new LinkedList<>();
            visited = new boolean[n + 1][m + 1];
            q.add(new Node(startX, startY));
            visited[startX][startY] = true;
            bomb();

            if (flag) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }


    public static void bomb() {
        while (!q.isEmpty()) {
            Node target = q.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 300; j++) {
                    int dx = target.x + (dir[i][0] * j);
                    int dy = target.y + (dir[i][1] * j);

                    if (isRange(dx, dy) && !visited[dx][dy]) {
                        if (map[dx][dy] == 0) {
                            visited[dx][dy] = true;
                            q.add(new Node(dx, dy));
                        } else if (map[dx][dy] == 1) {
                            visited[dx][dy] = true;
                            map[dx][dy] = 0;
                            break;
                        } else if (dx == endX && dy == endY) {
                            flag = true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }


    private static boolean isRange(int x, int y) {
        if (x > 0 && x <= n && y > 0 && y <= m) {
            return true;
        } else {
            return false;
        }
    }
}
