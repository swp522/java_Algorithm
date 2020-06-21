// 2020_06_19_금_42회차_문풀1_스타트 택시

/*
 * 1. 남은 연료양 구하기 (연료 바닥나면 이동 못하면 -1 출력)
 *
 * 2. 2 ≤ N ≤ 20,  1 ≤ M ≤ N2,  1 ≤ 초기 연료 ≤ 500,000
 *
 * 3.
 *
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238_스타트택시 {

    static int n, m, fuel, startX, startY, destX, destY, destNum;
    static int[][] map, dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited1, visited2;
    static ArrayList<Node> customerList;
    static ArrayList<Node> destinationList;
    static Queue<Node> q1, q2;
    static boolean flag;

    static class Node implements Comparable<Node> {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken()); // 승객수
        fuel = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());


        customerList = new ArrayList<>();
        destinationList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 2;
            customerList.add(new Node(a, b, i));
            destinationList.add(new Node(c, d, i));
        }

        int round = m;
        int nowX = startX;
        int nowY = startY;
        while (round != 0) {

            flag = false;
            findTheNearestMan(nowX, nowY);
            goDestination(destX, destY, destNum);
        }

        if (flag = true) {
            System.out.println(fuel);
        } else {
            System.out.println(-1);
        }
    }


    public static void findTheNearestMan(int x, int y) {
        q1 = new LinkedList<>();
        q1.add(new Node(x, y, 0));
        visited1 = new boolean[n][n];
        int cost = 0;
        int min = Integer.MAX_VALUE;

        while (!q1.isEmpty()) {
            int qSize = q1.size();
            for (int s = 0; s < qSize; s++) {
                Node taxi = q1.poll();

                if (map[taxi.x][taxi.y] == 2) {
                    min = Math.min(cost, min);
                    destX = taxi.x;
                    destY = taxi.y;
                    destNum = taxi.num;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int dx = taxi.x + dir[i][0];
                    int dy = taxi.y + dir[i][1];

                    if (isRange(dx, dy) && !visited1[dx][dy] && map[dx][dy] != 1) {
                        visited1[dx][dy] = true;
                        q1.add(new Node(dx, dy, 0));
                    }
                }
            }

            cost++;
        }

        fuel -= cost;
    }


    public static void goDestination(int x, int y, int destNum) {
        q2 = new LinkedList<>();
        q2.add(new Node(destX, destY, destNum));
        visited2 = new boolean[n][n];

        int cost = 0;

        while (!q2.isEmpty()) {
            int qSize = q2.size();
            for (int s = 0; s < qSize; s++) {
                Node taxi = q2.poll();

                if (taxi.num == destNum) {
                    fuel += cost;
                    flag = true;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int dx = taxi.x + dir[i][0];
                    int dy = taxi.y + dir[i][1];

                    if (isRange(dx, dy) && !visited2[dx][dy] && map[dx][dy] != 1) {
                        visited2[dx][dy] = true;
                        q1.add(new Node(dx, dy, taxi.num));
                    }
                }
            }

            cost++;
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
