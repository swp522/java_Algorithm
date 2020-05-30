// 2020_05_29_금_문풀_주난의 난

/*
 * 1.
 *
 * 2. 1 <= N,M <= 300,  1 <= x1,x2 <= N,  1 <= y1,y2 <= M
 *
 * 3. dfs()로 0 들 통해서 목적지까지 가능한지 보고
 *
 *    4방향 1 없애기
 *
 * 4. 아직 미완성, dfs 안써도 될 듯..
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14497_주난의난 {

    static int n, m, count, startX, startY, endX, endY;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, map;
    static boolean[][] visited;
    static ArrayList<Node> zeroList;

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
        visited = new boolean[n + 1][m + 1];
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        map[startX][startY] = -1;
        map[endX][endY] = -2;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                if (input.charAt(j - 1) == '#' && input.charAt(j - 1) == '*') {
                    continue;
                }
                map[i][j] = input.charAt(j - 1);
            }
        }

//        zeroList = new ArrayList<>();
//        zeroList.add(new Node(startX, startY));

        while (true) {
//            dfs(new Node(startX, startY));


            bomb();


        }


    }


//    public static void dfs(Node node) {
//
//        if(map[node.x][node.y] == 1){
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int dx = node.x + dir[i][0];
//            int dy = node.y + dir[i][1];
//
//            zeroList.remove(0);
//            zeroList.add(new Node(dx, dy));
//
//            if (isRange(dx, dy) && !visited[dx][dy]) {
//                visited[dx][dy] = true;
//                dfs(new Node(dx, dy));
//                visited[dx][dy] = false;
//            }
//
//        }
//
//    }


    public static void bomb() {
        count = 0;
        Queue<Node> q = new LinkedList<Node>();
        visited[startX][startY] = true;
        q.add(new Node(startX, startY));

        loop:
        while (!q.isEmpty()) {
            count++;
            Node target = q.poll();

            for (int i = 0; i < 4; i++) {
                int dx = target.x + dir[i][0];
                int dy = target.y + dir[i][1];

                if (isRange(dx, dy) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if (map[dx][dy] == 1) {
                        map[dx][dy] = 0;
                    } else if (map[dx][dy] == -2) {
                        break loop;
                    }
                    visited[dx][dy] = true;
                    q.add(new Node(dx, dy));
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
