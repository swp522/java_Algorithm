// 2020_06_22_월_킹

/*
 * 1. 킹, 돌의 마지막 위치 구하기
 *
 * 2. N <= 50
 *
 * 3. 굳이 맵 안그려도 될 듯
 *
 * 4. String 값 받을 떄 if 조건절 안에서 비교할 경우 equals 써야 인식한다
 *
 *    아직 미완성
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {

    static int n, kingX, kingY, rockX, rockY;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        kingX = (king.charAt(1) - '0' - 1);
        kingY = king.charAt(0) - 'A';

//        System.out.println(kingX + " " + kingY);

        String rock = st.nextToken();
        rockX = (rock.charAt(1) - '0' - 1);
        rockY = rock.charAt(0) - 'A';
//        System.out.println(rockX + " " + rockY);

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            int orderNum = getDirection(br.readLine());
            if (isRange(kingX + dir[orderNum][0], kingY + dir[orderNum][1])) {
                kingX = kingX + dir[orderNum][0];
                kingY = kingY + dir[orderNum][1];

                if (kingX == rockX && kingY == rockY) {
                    if (isRange(rockX + dir[orderNum][0], rockY + dir[orderNum][1])) {
                        rockX = rockX + dir[orderNum][0];
                        rockY = rockY + dir[orderNum][1];
                    } else {
                        continue;
                    }
                }
            } else {
                continue;
            }

//            System.out.println(kingX + " " + kingY);
//            System.out.println(rockX + " " + rockY);
        }

        String answer1 = "";
        answer1 += (char) (kingY + 65);
        System.out.println(answer1 + kingX);

        String answer2 = "";
        answer2 += (char) (rockY + 65);
        System.out.println(answer2 + rockX);
    }


    public static int getDirection(String order) {
        if (order.equals("R")) {
            return 2;
        } else if (order.equals("L")) {
            return 6;
        } else if (order.equals("B")) {
            return 4;
        } else if (order.equals("T")) {
            return 0;
        } else if (order.equals("RT")) {
            return 1;
        } else if (order.equals("LT")) {
            return 7;
        } else if (order.equals("RB")) {
            return 3;
        } else if (order.equals("LB")) {
            return 5;
        }
        return -1;
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < 8 && y < 8) {
            return true;
        } else {
            return false;
        }
    }
}
