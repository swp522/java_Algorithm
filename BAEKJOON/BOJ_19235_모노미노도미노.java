// 2020_06_09_화_39회차_문풀_삼성역태_모노미노도미노

/*
 * 1. 얻은 점수와 파,초 보드에 들어있는 칸의 개수 구하기
 *
 * 2. 1 ≤ N ≤ 10,000
 *
 * 3. 뿌요뿌요에서 많이 복잡해준 구현 문제
 *
 * 4. 아직 미완성
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19235_모노미노도미노 {

    static int n, t, x, y;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[10][10];

        for (int i = 4; i < 10; i++) {
            for (int j = 4; j < 10; j++) {
                map[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if (t == 1) {
                map[x][y] = 1;
            } else if (t == 2) {
                map[x][y] = 2;
                map[x][y + 1] = 2;
            } else if (t == 3) {
                map[x][y] = 3;
                map[x + 1][y] = 3;
            }

            getDown();
            getRight();



        }
    }


    public static void getDown() {
        for (int j = 0; j < 4; j++) {
            int index = 9;
            for (int i = 9; i >= 0; i--) {
                if (map[i][j] != 0) {
                    int target = map[i][j];
                    map[i][j] = 0;
                    map[index][j] = target;
                    index--;
                }
            }
        }
    }


    public static void getRight() {
        for (int i = 0; i < 4; i++) {
            int index = 9;
            for (int j = 9; j >= 0; j--) {
                int target = map[i][j];
                map[i][j] = 0;
                map[i][index] = target;
                index--;
            }
        }
    }


    public static void downCheck() {
        for (int j = 0; j < 4; j++) {
            if (map[4][j] > 0) {
                for (int i = 4; i < 8; i++) {
                    map[i + 2][j] = map[i][j];
                }
                map[4][j] = 0;
                map[5][j] = 0;
            }
        }
    }


    public static void rightCheck() {
        for (int i = 0; i < 4; i++) {
            if (map[i][4] > 0) {
                for (int j = 4; j < 8; j++) {
                    map[i][j + 2] = map[i][j];
                }
                map[i][4] = 0;
                map[i][5] = 0;
            }
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n && map[x][y] != 1) {
            return true;
        } else {
            return false;
        }
    }

}
