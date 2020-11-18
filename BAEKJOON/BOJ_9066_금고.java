// 2020_11_17_화

/*

    1. 모든 손잡이 수평으로 만드는 최소 횟수 구하기

    2. 2 <= n(짝수) <= 20

    3. 시간초과 -> 가우스 소거법(?)이나 오델로 게임 방식으로 푸는 거라고 하는데 잘 모르겠음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9066_금고 {

    static int n, min;
    static int[][] map;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            min = Integer.MAX_VALUE;
            check = true;
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                st = new StringTokenizer(input);
                for (int j = 0; j < n; j++) {
                    if (st.nextToken().equals("V")) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }

            for (int i = 1; i <= n * n && check; i++) {
                dfs(0, 0, i);
            }

            System.out.println(min);
        }
    }


    public static void dfs(int index, int depth, int end) {
        if (depth == end) {
            if (isPossibleOpen()) {
                min = Math.min(min, depth);
                check = false;
            }

            return;
        }

        for (int i = index; i < n * n && check; i++) {
            int x = i / n;
            int y = i % n;
            rotate(x, y);
            dfs(i + 1, depth + 1, end);
            rotate(x, y);
        }
    }


    public static void rotate(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (map[i][y] == 1) {
                map[i][y] = 0;
                continue;
            }

            map[i][y] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (y == i) {
                continue;
            }
            if (map[x][i] == 1) {
                map[x][i] = 0;
                continue;
            }

            map[x][i] = 1;
        }
    }


    public static boolean isPossibleOpen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
