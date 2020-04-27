// 2020_04_27_월_과제_30회차_상범빌딩

/*
 * 1. 탈출가능한지 여부
 *
 * 2. 1 ≤ L ≤ 30 , 1 ≤ R ≤ 30, 1 ≤ C ≤ 30
 *
 * 3. dfs
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {

    static int floor, row, col, si, sj, sf, ei, ej, ef, answer;
    static int[][][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean flag;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            if (floor == 0 && row == 0 && col == 0) {
                break;
            }

            map = new int[row + 1][col + 1][floor + 1];
            visited = new boolean[row + 1][col + 1][floor + 1];
            flag = false;
            answer = 0;

            for (int f = 1; f <= floor; f++) {
                for (int i = 1; i <= row; i++) {
                    String input = br.readLine();
                    for (int j = 1; j <= col; j++) {
                        if (input.charAt(j - 1) == 'S') {
                            map[i][j][f] = 2;
                            si = i;
                            sj = j;
                            sf = f;
                        } else if (input.charAt(j - 1) == '#') {
                            map[i][j][f] = 1;
                        } else if (input.charAt(j - 1) == '.') {
                            map[i][j][f] = 0;
                        } else if (input.charAt(j - 1) == 'E') {
                            map[i][j][f] = -1;
                            ei = i;
                            ej = j;
                            ef = f;
                        }
                    }
                }
                br.readLine();
            }
            dfs(si, sj, sf, 0);

            if (answer == -2) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }

    }


    public static void dfs(int x, int y, int sf, int count) {
        if (x == ei && y == ej && sf == ef) {
            answer = count;
        } else {
            answer = -2;
        }

        visited[x][y][sf] = true;

        if ((sf + 1 <= floor && map[x][y][sf + 1] == 0) || (sf + 1 <= floor && map[x][y][sf + 1] == -1)) {
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (isRangeof(dx, dy) && !visited[dx][dy][sf + 1] && map[dx][dy][sf + 1] != 1 && sf + 1 <= floor) {
                    dfs(dx, dy, sf + 1, count + 1);
                }
            }

        } else if ((sf - 1 >= 1 && map[x][y][sf - 1] == 0) || (sf - 1 >= 1) && map[x][y][sf - 1] == -1) {
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (isRangeof(dx, dy) && !visited[dx][dy][sf - 1] && map[dx][dy][sf - 1] != 1 && sf - 1 >= 1) {
                    dfs(dx, dy, sf - 1, count + 1);
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (isRangeof(dx, dy) && !visited[dx][dy][sf] && map[dx][dy][sf] != 1) {
                    if (map[dx][dy][sf] == 0) {
                        dfs(dx, dy, sf, count + 1);
                    }
                }
            }
        }
    }


    public static boolean isRangeof(int x, int y) {
        if (x >= 1 && y >= 1 && x <= row && y <= col) {
            return true;
        } else {
            return false;
        }
    }
}
