// 2020_07_01_수_2048 Easy

/*
 * 1. 최대 5번 이동해서 얻을 수 있는 가장 큰 블록 구하기
 *
 * 2. 1 ≤ N ≤ 20 , 2 <= 블록 값(2^n) <= 1024
 *
 * 3. 1). round마다 map 상태 갱신해줘야함 (by. copy[][])
 *
 *    2). round 마다 move() 하고 재귀로 다음 라운드 넘어가서 5 에 return
 *
 *    3). move() : 기울이는 방향(d)마다 기준 좌표(x, y) 다르게 설정해줌
 *
 *       - 화살표 '끝' 부분이 기준 좌표 시작임
 *
 *       - (dx, dy) 값이 같은 target 숫자면 2배 해주고 아니면 그 직전좌표인 (x, y) 값을 target으로 갱신
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100_2048Easy {

    static int n, answer;
    static int[][] map, dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static boolean[][] checkAdd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        answer = -1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0);

        System.out.println(answer);
    }

    private static void solve(int round) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }

        if (round == 5) {
            return;
        }

        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for (int d = 0; d < 4; d++) {
            move(d);
            solve(round + 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = copy[i][j];
                }
            }
        }
    }

    private static void move(int d) {
        checkAdd = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x, y;
                if (d == 0) {
                    x = i;
                    y = (n - 1) - j;
                } else if (d == 1) {
                    x = i;
                    y = j;
                } else if (d == 2) {
                    x = j;
                    y = i;
                } else {
                    x = (n - 1) - j;
                    y = i;
                }

                if (map[x][y] != 0 && !checkAdd[x][y]) {
                    int target = map[x][y];
                    map[x][y] = 0;
                    int dx = x + dir[d][0];
                    int dy = y + dir[d][1];

                    while (isRange(dx, dy) && map[dx][dy] == 0) {
                        x = dx;
                        y = dy;
                        dx = dx + dir[d][0];
                        dy = dy + dir[d][1];
                    }

                    if (isRange(dx, dy) && map[dx][dy] == target && !checkAdd[dx][dy]) {
                        map[dx][dy] *= 2;
                        checkAdd[dx][dy] = true;
                    } else {
                        map[x][y] = target;
                    }
                }

            }
        }
    }

    private static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        } else {
            return false;
        }
    }

}
