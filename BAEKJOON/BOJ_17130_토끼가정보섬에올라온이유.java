// 2020_06_19_금_41회차_과제3_토끼가 정보섬에 올라온 이유

/*
 * 1. 토끼가 얻을 수 있는 최대 당근 개수 구하기
 *
 * 2. 1 ≤ N,M ≤ 1000
 *
 * 3. 1). dfs, 구현(쪽문에 도착해도 다른쪽문으로 이동할 수 있음) -> 시간초과
 *
 *    2). solve : dp로 푼거 참고
 *
 * 4. 다시 풀어보기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17130_토끼가정보섬에올라온이유 {


    static int n, m, rx, ry, answer, count, exits;
    static int[][] dp, dir = {{0, 1}, {1, 1}, {-1, 1}};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        dp = new int[n][m];

        answer = Integer.MIN_VALUE;
        count = 1;
        exits = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (map[i][j] == 'O') {
                    exits++;

                }
            }
        }

        solve();

        if (answer == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }


    public static void solve() {
        dp[rx][ry] = 0;
        for (int j = ry + 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] != '#') {
                    int temp = -1;

                    for (int d = 0; d < 3; d++) {
                        int dx = i - dir[d][0];
                        int dy = j - dir[d][1];

                        if (isRange(dx, dy)) {
                            temp = Math.max(temp, dp[dx][dy]);
                        }
                    }

                    if (m != -1) {
                        if(map[i][j] == 'C'){
                            temp += 1;
                        }
                        if(map[i][j] == 'O'){
                            answer = Math.max(temp, answer);
                        }

                        dp[i][j] = temp;
                    }

                }
            }
        }
    }


    public static void dfs(int x, int y) {
        if (map[x][y] == 'O') {
            exits--;
            if(exits > 0){
                for (int i = 0; i < 3; i++) {
                    int dx = x + dir[i][0];
                    int dy = y + dir[i][1];

                    if (isRange(dx, dy) && !visited[dx][dy] && map[dx][dy] != '#') {
                        if (map[dx][dy] == 'C') {
                            count++;
                            visited[dx][dy] = true;
                            dfs(dx, dy);
                            visited[dx][dy] = false;
                            count--;
                        } else {
                            visited[dx][dy] = true;
                            dfs(dx, dy);
                            visited[dx][dy] = false;
                        }

                    }
                }
            } else if(exits == 0){
                answer = Math.max(answer, count);
                return;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (isRange(dx, dy) && !visited[dx][dy] && map[dx][dy] != '#') {
                    if (map[dx][dy] == 'C') {
                        count++;
                        visited[dx][dy] = true;
                        dfs(dx, dy);
                        visited[dx][dy] = false;
                        count--;
                    } else {
                        visited[dx][dy] = true;
                        dfs(dx, dy);
                        visited[dx][dy] = false;
                    }

                }
            }
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            return true;
        } else {
            return false;
        }
    }
}
