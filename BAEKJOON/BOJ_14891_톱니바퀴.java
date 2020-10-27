// 2020_10_27_화

/*

    1. 최종 톱니바퀴 상태에서 네 톱니바퀴 12시방향 값들로 점수 구하기

    2. 1 ≤ 회전 횟수(K) ≤ 100   /   방향 1 : 시계, 2 : 반시계   /  자석 N = 0, S = 1

    2. 삼성 기출과 비슷한 시뮬레이션 문제

       1) getScore()에서 n s/n 값 잘못 봐서 시간 날림

       2) 메소드별 구현하는데 시간 오래걸렸음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (input.charAt(j) == '1') {
                    arr[i][j] = 1;
                } else{
                    arr[i][j] = 0;
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            checkRotate(num, dir);
        }

        System.out.println(getScore());
    }


    public static void checkRotate(int num, int dir) {
        ArrayList<int[]> commandList = new ArrayList<>();
        commandList.add(new int[]{num, dir});

        int tempDir = dir;
        int targetWheel = num;
        int targetWheelRight = arr[num][2];
        while (targetWheel + 1 < 4) {
            if (targetWheelRight != arr[targetWheel + 1][6]) {
                targetWheel++;
                tempDir *= -1;
                targetWheelRight = arr[targetWheel][2];
                commandList.add(new int[]{targetWheel, tempDir});
            } else {
                break;
            }
        }

        tempDir = dir;
        targetWheel = num;
        int targetWheelLeft = arr[num][6];
        while (targetWheel - 1 >= 0) {
            if (targetWheelLeft != arr[targetWheel - 1][2]) {
                targetWheel--;
                tempDir *= -1;
                targetWheelLeft = arr[targetWheel][6];
                commandList.add(new int[]{targetWheel, tempDir});
            } else {
                break;
            }
        }

        for (int i = 0; i < commandList.size(); i++) {
            rotate(commandList.get(i)[0], commandList.get(i)[1]);
        }
    }


    public static void rotate(int num, int dir) {
        int[] copy = arr[num].clone();

        if (dir == 1) {
            for (int i = 1; i < 8; i++) {
                arr[num][i] = copy[i - 1];
            }

            arr[num][0] = copy[7];
        } else {
            for (int i = 1; i < 8; i++) {
                arr[num][i - 1] = copy[i];
            }

            arr[num][7] = copy[0];
        }
    }


    public static int getScore() {
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                if (i == 0) {
                    answer += 1;
                } else if (i == 1) {
                    answer += 2;
                } else if (i == 2) {
                    answer += 4;
                } else {
                    answer += 8;
                }
            }
        }

        return answer;
    }
}
