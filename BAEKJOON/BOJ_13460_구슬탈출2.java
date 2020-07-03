// 2020_07_01_수_구슬탈출2

/*
 * 1. 빨강 구슬을 구멍으로 뺄 수 있는 기울이기 동작 최소 횟수 구하기 (10번 넘어가면 -1 출력)
 *
 * 2. 3 ≤ N, M ≤ 10
 *
 * 3. 1). solve() - 10개의 가능한 방향을 만들어 놓고 시작
 *
 *                - 이전 방향을 인자로 들고다녀서 가지치기 해줌
 *
 *                - ball에 R, B 시작 위치와 초기화하고 move() 실행
 *
 *    2). move() - R, B 순서로 조건에 맞게 동작
 *
 *               - R, B가 만났을 경우 한칸씩 빼주는게 중요함
 *
 *               -
 *
 * 4. 1). input 받을 때 char(i)로 한 거 늦게 발견함..
 *
 *    2). 너무 X 1000 어려운 구현 문제
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {

    static int row, col, answer, srx, sry, sbx, sby;
    static char[][] map, copy;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean errorEnd;
    static int[] directions;
    static Ball ball;

    static class Ball {
        int rx, ry, bx, by;

        Ball(int rx, int ry, int bx, int by) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        copy = new char[row][col];
        directions = new int[11];
        answer = 11;
        ball = new Ball(0, 0, 0, 0);

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'R') {
                    srx = i;
                    sry = j;
                } else if (map[i][j] == 'B') {
                    sbx = i;
                    sby = j;
                }
            }
        }

        solve(0, -1);

        if (answer == 11) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }


    public static void solve(int directionIndex, int preDir) {
        // directions[]에 방향 다 정해지면
        if (directionIndex == 10) {
            ball.rx = srx;
            ball.ry = sry;
            ball.bx = sbx;
            ball.by = sby;
            errorEnd = false;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++)
                    copy[i][j] = map[i][j];
            }

            for (int i = 0; i < 10; i++) {
                if (move(directions[i])) {
                    answer = Math.min(answer, i + 1);
                    return;
                }

                if (errorEnd) {
                    break;
                }
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            if (d != preDir) {
                directions[directionIndex] = d;
                solve(directionIndex + 1, d);
            }
        }
    }


    public static boolean move(int d) {
        int rx = ball.rx, ry = ball.ry, bx = ball.bx, by = ball.by;
        boolean RisInTheHole = false, RmeetsB = false, BmeetsR = false, BisInTheHole = false;

        while (true) {
            rx = rx + dir[d][0];
            ry = ry + dir[d][1];

            if (copy[rx][ry] != '.') {
                if (copy[rx][ry] == 'O') {
                    RisInTheHole = true;
                } else if (copy[rx][ry] == 'B') {
                    RmeetsB = true;
                    continue;
                }

                rx = rx - dir[d][0];
                ry = ry - dir[d][1];
                break;
            }
        }

        if (RmeetsB) {
            rx = rx - dir[d][0];
            ry = ry - dir[d][1];
        }

        while (true) {
            bx = bx + dir[d][0];
            by = by + dir[d][1];

            if (copy[bx][by] != '.') {
                if (copy[bx][by] == 'O') {
                    BisInTheHole = true;
                } else if (copy[bx][by] == 'R') {
                    BmeetsR = true;
                    continue;
                }

                bx = bx - dir[d][0];
                by = by - dir[d][1];
                break;
            }
        }
        //R이 B를 만난적없고, B가 R만난경우 뒤로 하나씩 미뤄주기
        if (!RmeetsB && BmeetsR) {
            bx = bx - dir[d][0];
            by = by - dir[d][1];
        }

        //B가 들어간 경우
        if (BisInTheHole) {
            errorEnd = true; //게임은 끝나지만
            return false;   //false 리턴
        }

        //R이 들어간 경우
        if (RisInTheHole) {
            return true; //게임 정상적으로 끝
        }

        copy[ball.rx][ball.ry] = '.';
        copy[rx][ry] = 'R';
        copy[ball.bx][ball.by] = '.';
        copy[bx][by] = 'B';

        ball.rx = rx;
        ball.ry = ry;
        ball.bx = bx;
        ball.by = by;

        return false;
    }

}
