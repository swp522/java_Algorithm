// 2021_01_18_월

/*

    1. -1, 0, 1 으로만 채워진 종이의 개수 구하기

    2. 1 ≤ N ≤ 3^7  (N 은 3^k 꼴)

    3. map 크기 / 3 분할 하면서 개수 구하기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {

    static int[][] map;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        count = new int[3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(n, 0, 0);

        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }
    }

    private static void divide(int n, int x, int y) {
        if (isSameRegion(n, x, y)) {
            count[map[x][y] + 1]++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(n / 3, x + j * (n / 3), y + i * (n / 3));
            }
        }
    }

    private static boolean isSameRegion(int n, int x, int y) {
        int target = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (target != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
