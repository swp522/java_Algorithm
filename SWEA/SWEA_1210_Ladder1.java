// 25(수) 강남스터디_8회차_문풀_Ladder1
// 지정된 도착점에 대응되는 출발점의 x좌표를 출력하라
// 도착점(2) 에서 시작해서 위로 올라가면서 map[dx][dy] = 0 처리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {

    static int[][] map, dir = {{0, 1}, {0, -1}, {-1, 0}};
    static int row, col, answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int testCase = Integer.parseInt(br.readLine());
            map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        row = i;
                        col = j;
                        solve(row, col);
                    }
                }
            }
            System.out.println("#" + testCase + " " + answer);
        }
    }


    public static void solve(int row, int col) {
        while (true) {

            for (int i = 0; i < 3; i++) {
                int dx = row + dir[i][0];
                int dy = col + dir[i][1];

                if (dx >= 0 && dx < 100 && dy >= 0 && dy < 100 && map[dx][dy] == 1) {
                    map[dx][dy] = 0;
                    row = dx;
                    col = dy;
                    break;
                }
            }

            if (row == 0) {
                answer = col;
                break;
            }
        }
    }
}
