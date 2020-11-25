// 2020_11_25_수

/*

    1. 공격수의 점수, 게임판 상태 출력하기

    2. 1 <= row, com <= 100   /   1 <= r <= 10000

    3. 1) attack 에서 만약 해당 좌표의 맵 값이 0이면 아무일도 일어나지 않으니까 return

       2) k 를 연속적으로 처리하면서 움직이도록 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20165_인내의도미노장인호석 {

    static int row, col, r, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        int[][] copy = new int[row][col];
        answer = 0;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                copy[i][j] = num;
            }
        }

        for (int i = 0; i < 2 * r; i++) {
            st = new StringTokenizer(br.readLine());
            if (i % 2 == 0) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                String d = st.nextToken();
                attack(x, y, d);
            } else {
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;

                map[x][y] = copy[x][y];
            }
        }

        System.out.println(answer);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] > 0) {
                    System.out.print("S" + " ");
                } else{
                    System.out.print("F" + " ");
                }
            }

            System.out.println();
        }
    }


    public static void attack(int x, int y, String d) {
        if(map[x][y] == 0){
            return;
        }

        int dx = 0;
        int dy = 0;
        int k;

        if (d.equals("E")) {
            dy = 1;
        } else if (d.equals("W")) {
            dy = -1;
        } else if (d.equals("S")) {
            dx = 1;
        } else {
            dx = -1;
        }

        k = map[x][y];
        while (isRange(x, y) && k >= 1) {
            if (map[x][y] > 0) {
                answer++;
            }

            k = Math.max(k - 1, map[x][y] - 1);
            map[x][y] = 0;
            x += dx;
            y += dy;
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < row && y < col) {
            return true;
        } else {
            return false;
        }
    }
}
