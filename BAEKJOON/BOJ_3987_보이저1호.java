// 2020_04_24_월_과제_29회차_보이저 1호

/*
 * 1. 최대 시간이 되는 방향
 *
 * 2. 1<= n, m <= 500
 *
 * 3. dfs, 구현
 *
 * 4. 배운게 많은 문제
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3987_보이저1호 {

    static int n, m, xPos, yPos, answerIndex, answer2, maxVal;
    static int[] arr;
    static String answer1;
    static boolean Flag;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        answer1 = "";
        answer2 = Integer.MIN_VALUE;
        Flag = false;
        answerIndex = -1;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1);
            }
        }
        st = new StringTokenizer(br.readLine());
        xPos = Integer.parseInt(st.nextToken());
        yPos = Integer.parseInt(st.nextToken());

        arr = new int[4];
        for (int t = 0; t < 4; t++) {
            dfs(xPos, yPos, t, 1, t);
        }

        for (int i = 0; i < 4; i++) {
            if (arr[i] == 0) {
                answerIndex = i;
                break;
            }
        }
        if (answerIndex == -1) {
            for (int i = 0; i < 4; i++) {
                if (arr[i] == maxVal) {
                    answerIndex = i;
                    break;
                }
            }
        }

        answer1 = startDir(answerIndex);
        answer2 = arr[answerIndex];

        if (arr[answerIndex] == 0) {
            System.out.println(answer1);
            System.out.println("Voyager");
        } else {
            System.out.println(answer1);
            System.out.println(answer2);
        }
    }


    public static void dfs(int x, int y, int direction, int count, int start) {
        if (count == n * m) {
            arr[start] = 0;
        } else {

            int dx = x + dir[direction][0];
            int dy = y + dir[direction][1];

            if (!isRangeof(dx, dy) || map[dx][dy] == 'C') {
                if (maxVal <= count) {
                    maxVal = Math.max(maxVal, count);
                }
                arr[start] = count;
            } else {

                if (map[dx][dy] == '/' || map[dx][dy] == '\\') {
                    int newDirection = changeDirection(dx, dy, direction);
                    dfs(dx, dy, newDirection, count + 1, start);
                } else {
                    dfs(dx, dy, direction, count + 1, start);
                }
            }
        }
    }


    private static int changeDirection(int x, int y, int d) {  //위 오른 아래 왼
        if (d == 0) {
            if (map[x][y] == '/') {
                d = 1;
            } else if (map[x][y] == '\\') {
                d = 3;
            }
        } else if (d == 1) {
            if (map[x][y] == '/') {
                d = 0;
            } else if (map[x][y] == '\\') {
                d = 2;
            }
        } else if (d == 2) {
            if (map[x][y] == '/') {
                d = 3;
            } else if (map[x][y] == '\\') {
                d = 1;
            }
        } else if (d == 3) {
            if (map[x][y] == '/') {
                d = 2;
            } else if (map[x][y] == '\\') {
                d = 0;
            }
        }
        return d;
    }


    public static boolean isRangeof(int x, int y) {
        if (x >= 1 && y >= 1 && x <= n && y <= m) {
            return true;
        } else {
            return false;
        }
    }

    public static String startDir(int t) {
        String startDir = "";
        if (t == 0) {
            startDir = "U";
        } else if (t == 1) {
            startDir = "R";
        } else if (t == 2) {
            startDir = "D";
        } else if (t == 3) {
            startDir = "L";
        }
        return startDir;
    }
}
