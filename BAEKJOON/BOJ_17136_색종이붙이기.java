// 2020_05_18_월_과제_35회차_색종이 붙이기

/*
 * 1. 색종이 최소개수 구하기
 *
 * 2. 10 x 10 크기 맵
 *
 * 3. 백트래킹, 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_색종이붙이기 {

    static int[][] map;
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int oneCount, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[11][11];
        oneCount = 0;

        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        if (oneCount == 0) {
            System.out.println(0);
            return;
        }

        solve();

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }


    public static void solve() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                if (map[i][j] == 1) {
                    for (int size = 1; size <= 5; size++) {
                        if (paper[size] > 0) {
                            if (check(i, j, size)) {

                                for (int ii = i; ii < i + size; ii++) {
                                    for (int jj = j; jj < j + size; jj++) {
                                        map[ii][jj] = 0;
                                    }
                                }

                                paper[size]--;

                                solve();

                                for (int ii = i; ii < i + size; ii++) {
                                    for (int jj = j; jj < j + size; jj++) {
                                        map[ii][jj] = 1;
                                    }
                                }

                                paper[size]++;
                            }
                        }
                    }

                    // 색종이 붙히기 라운드 끝났는데 1 남아있는 경우
                    if (map[i][j] == 1) {
                        return;
                    }

                }
            }
        }

        int paperCount = 25;

        for (int i = 1; i <= 5; i++) {
            paperCount -= paper[i];
        }

        answer = Math.min(answer, paperCount);
    }


    private static boolean check(int x, int y, int size) {

        if (x < 1 || y < 1 || x + size > 11 || y + size > 11) {
            return false;
        }

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

}
