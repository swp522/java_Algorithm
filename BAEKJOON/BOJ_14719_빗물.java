// 2020_06_09_화_39회차_과제1_빗물

/*
 * 1. 고이는 빗물의 총량 구하기
 *
 * 2. 1 ≤ H, W ≤ 500
 *
 * 3. 구현
 *
 * 4. 전에 비슷한거 풀어봄
 *
 *    기준점의 왼쪽, 오른쪽 각각 비교해서 둘다 벽이 존재하면 물이 고일 수 있으므로 answer++ 해줌
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

    static int[][] map;
    static int row, col, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < col; j++) {
            int height = Integer.parseInt(st.nextToken());
            for (int i = row - 1; i >= row - height; i--) {
                map[i][j] = -1;
            }
        }

        answer = 0;
        solve();

        System.out.println(answer);
    }


    public static void solve() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] != -1) {

                    int x = i, y = j;
                    boolean left = false;
                    boolean right = false;

                    while (true) {
                        y -= 1;

                        if (y < 0) {
                            break;
                        }

                        if (map[x][y] == -1) {
                            left = true;
                            break;
                        }
                    }

                    y = j;

                    while (true) {

                        y += 1;

                        if (y >= col) {
                            break;
                        }

                        if (map[x][y] == -1) {
                            right = true;
                            break;
                        }
                    }

                    if (left && right) {
                        answer++;
                    }
                }
            }
        }
    }

}
