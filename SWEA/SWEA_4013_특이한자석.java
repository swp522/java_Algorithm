// 2020_05_20_수_문풀_15회차_특이한 자석
// 2020_05_27_수_과제1_16회차_특이한 자석

/*
 * 1. 회전 후 얻는 점수 구하기
 *
 * 2. 톱니바퀴 1번부터 주어짐.
 *
 * 3. 구현
 *
 *    왼쪽 톱니바퀴 2번쨰랑 오른쪽 톱니바퀴 6번째가 접촉함
 *
 * 4. 참고해서 구현함. 아직 멀었다.
 *
 *    바퀴 왼쪽, 오른쪽 조건 나눠서 구현하는거 로직 생각 못했음 (While문)
 *
 *    1차원 배열에 회전정보 다시 담는 로직 참고함
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

    static int k;
    static int[][] map, rotationDirection;
    static int[] rotationCheck;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            rotationCheck = new int[4]; // Check()랑 rotate() 에서 '주어진 톱니바퀴 별로 회전 방향 정보' 담을 1차원 배열
            k = Integer.parseInt(br.readLine());    // 자석을 회전시키는 회수
            rotationDirection = new int[k][2];
            map = new int[4][8];

            for (int i = 0; i < 4; i++) {   // 톱니바퀴 4개
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {   // 8개의 톱니
                    map[i][j] = Integer.parseInt(st.nextToken());   // n 극 : 0, s 극 : 1
                }
            }

            for (int i = 0; i < k; i++) {   // 총 2번 회전함
                StringTokenizer st = new StringTokenizer(br.readLine());
                rotationDirection[i][0] = Integer.parseInt(st.nextToken()) - 1; // 회전시킬 톱니바퀴의 index, 회전방향
                rotationDirection[i][1] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                checkBeforeRotating(rotationDirection[i][0], rotationDirection[i][1]);
                rotate();
            }

            System.out.println("#" + t + " " + getScore());
        }
    }


    private static void checkBeforeRotating(int index, int direction) {
        rotationCheck[index] = direction;

        int tempIndex = index;
        int reverseDirection = -1 * direction;

        while (tempIndex >= 1) {  // 회전시킬 톱니바퀴 왼쪽에 톱니바퀴가 있는 경우
            if (map[tempIndex][6] != map[tempIndex - 1][2]) {
                rotationCheck[tempIndex - 1] = reverseDirection;    // 회전시킬 톱니 왼쪽꺼는 회전 방향 반대니까
                tempIndex--;    // 다음 왼쪽거 회전 적용을 위해서 --
                reverseDirection *= -1; // 다시 복구
            } else {    // 자석 극이 같으면 옆에 있는 톱니들 회전 안하니까
                break;
            }
        }

        tempIndex = index;
        reverseDirection = -1 * direction;

        while (tempIndex < 3) {   // 회전시킬 톱니바퀴 오른쪽에 톱니바퀴 있는 경우
            if (map[tempIndex][2] != map[tempIndex + 1][6]) {
                rotationCheck[tempIndex + 1] = reverseDirection;
                tempIndex++;    // 다음 오른쪽꺼 회전 적용을 위해서 ++
                reverseDirection *= -1;
            } else {
                break;
            }
        }
    }


    private static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (rotationCheck[i] == 0) {
                continue;
            }

            if (rotationCheck[i] == 1) {
                int temp = map[i][7];
                for (int j = 7; j > 0; j--) {
                    map[i][j] = map[i][j - 1];
                }
                map[i][0] = temp;
            } else {
                int temp = map[i][0];
                for (int j = 0; j < 7; j++) {
                    map[i][j] = map[i][j + 1];
                }
                map[i][7] = temp;
            }

            rotationCheck[i] = 0;
        }

    }


    private static int getScore() {
        int totalScore = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][0] == 1) {
                totalScore += Math.pow(2, i);
            }
        }

        return totalScore;
    }
}
