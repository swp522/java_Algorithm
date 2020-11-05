// 2020_11_04_수

/*

    1. 모든 칸 방문하는데 필요한 사다리 설치비용의 최솟값 구하기

    2. , <= height <= 10,000

    3. bfs + union/find

 */

import java.util.LinkedList;

public class PRO_LV4_지형이동 {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] land;
    static boolean[][] visited;
    static int len, cost, height, answer;

    public static void main(String[] args) {
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        height = 3;

        System.out.println(solution(land, height));
    }


    public static int solution(int[][] land, int height) {
        int n = land.length;
        int[][] color = new int[n][n];
        int colorCount = 0;
        LinkedList<int[]> queue;
        int[] now;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (color[i][j] == 0) {
                    colorCount++;
                    queue = new LinkedList<int[]>();
                    queue.add(new int[]{i, j});
                    color[i][j] = colorCount;
                    while (!queue.isEmpty()) {
                        now = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int dx = now[0] + dir[d][0];
                            int dy = now[1] + dir[d][1];

                            if (isRange(dx, dy) && color[dx][dy] == 0 && Math.abs(land[now[0]][now[1]] - land[dx][dy]) <= height) {
                                queue.add(new int[]{dx, dy});
                                color[dx][dy] = colorCount;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(colorCount);

        return answer;
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 9 && x < len && y < len) {
            return true;
        } else {
            return false;
        }
    }

}
