// 2020_06_22_월_킹

/*
 * 1. 킹, 돌의 마지막 위치 구하기
 *
 * 2. N <= 50
 *
 * 3. 1). 굳이 맵 안그려도 될 듯해서 좌표 값만 갱신해줬따
 *
 *    2). 좌표값 처리하는게 순서가 거꾸로여서 처음에 좀 귀찮았다
 *
 *    3). 조건 구현할 때 킹 = 돌 인 경우 돌이 이동했을 때 영역밖으로 나가면
 *
 *        킹과 돌 둘다 복구시켜야 하는데 킹을 안해줬었음 !
 *
 * 4. String 값 받을 떄 if 조건절 안에서 비교할 경우 equals 써야 인식할 수 있는거 깜박하지 말기
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
        kingX = 7 - (king.charAt(1) - '0' - 1);
        kingY = king.charAt(0) - 'A';

        String rock = st.nextToken();
        rockX = 7 - (rock.charAt(1) - '0' - 1);
        rockY = rock.charAt(0) - 'A';

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
                        kingX = kingX - dir[orderNum][0];
                        kingY = kingY - dir[orderNum][1];
                        continue;
                    }
                }
            } else {
                continue;
            }
        }

        String answer1 = "";
        answer1 += (char) (kingY + 65);

        String answer2 = "";
        answer2 += (char) (rockY + 65);

        System.out.println(answer1 + (8 - kingX));
        System.out.println(answer2 + (8 - rockX));
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
