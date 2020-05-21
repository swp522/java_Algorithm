// 2020_05_20_수_문풀_15회차_특이한 자석

/*
 * 1. 회전 후 얻는 점수 구하기
 *
 * 2.
 *
 * 3. 구현
 *
 *    왼쪽 톱니바퀴 2번쨰랑 오른쪽 톱니바퀴 6번째가 접촉함
 *
 * 4. 미완성
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

    static int k;
    static int[][] map;
    static int[][] rotations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            k = Integer.parseInt(br.readLine());    // 회전 회수
            map = new int[4][8];
            rotations = new int[k][2];

            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());   // n 극 : 0, s 극 : 1
                }
            }

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    rotations[i][j] = Integer.parseInt(st.nextToken()); // 번호, 방향
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 8; j++) {
                    if (rotations[i][j] == 1) {
                        if (map[i][2] != map[i + 1][6]) {
                            map[i][0] = map[i][7];
                            map[i][j + 1] = map[i][j];
                        }
                    } else {
                        if (map[i][2] != map[i + 1][6]) {

                        }
                    }
                }
            }

        }

    }
}
