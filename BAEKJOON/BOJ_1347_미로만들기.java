// 2020_05_13_수_과제_15회차_미로 만들기

/*
 * 1.
 *
 * 2. 0 < n < 50
 *
 * 3. 구현, 맵 초기값 깔아 놓고 시작하는거랑
 *
 *    왜 start값 end값 받아야 대소 비교해야하는지 생각 못했음
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1347_미로만들기 {

    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static char[][] map;
    static int n, startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        map = new char[101][101];
        startX = 50;
        startY = 50;
        endX = 50;
        endY = 50;

        makeMaze(input, 50, 50, 2);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (map[i][j] != '.') {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

    }

    private static void makeMaze(String input, int x, int y, int d) {
        map[50][50] = '.';

        for (int i = 0; i < n; i++) {
            char move = input.charAt(i);

            if (move == 'F') {
                x = x + dir[d][0];
                y = y + dir[d][1];
                map[x][y] = '.';
                startX = Math.min(x, startX);
                startY = Math.min(y, startY);
                endX = Math.max(x, endX);
                endY = Math.max(y, endY);
            } else if (move == 'L') {
                if (d == 0) {
                    d = 3;
                } else if (d == 1) {
                    d = 2;
                } else if (d == 2) {
                    d = 0;
                } else if (d == 3) {
                    d = 1;
                }
            } else if (move == 'R') {
                if (d == 0) {
                    d = 2;
                } else if (d == 1) {
                    d = 3;
                } else if (d == 2) {
                    d = 1;
                } else if (d == 3) {
                    d = 0;
                }
            }
        }
    }

}
