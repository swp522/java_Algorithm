// 2020_04_24_월_과제_29회차_거북이

/*
 * 1. 가장 작은 직사각형 넓이 구하기
 *
 * 2. (0 , 0) 에서 출발
 *
 * 3. 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9811_거북이 {

    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            int x = 0, y = 0, direction = 0;
            int maxX = 0, maxY = 0, minX = 0, minY = 0;

            String input = br.readLine();
            char[] arr = input.toCharArray();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'F') {
                    x += dir[direction][0];
                    y += dir[direction][1];

                } else if (arr[i] == 'B') {
                    x -= dir[direction][0];
                    y -= dir[direction][1];

                } else if (arr[i] == 'L') {
                    direction = (direction + 1) % 4;
                } else if (arr[i] == 'R') {
                    direction = (direction + 3) % 4;
                }
                maxX = Math.max(x, maxX);
                minX = Math.min(x, minX);
                maxY = Math.max(y, maxY);
                minY = Math.min(y, minY);

                System.out.println((maxX - minX) * (maxY - minY));
            }
        }
    }
}
