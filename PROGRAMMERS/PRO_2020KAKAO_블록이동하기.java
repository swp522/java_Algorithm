// 2020_07_05_일_블록 이동하기

/*
 * 1. (n, n) 위치까지 이동하는데 걸리는 최소시간 구하기
 *
 * 2. 5 <= 한 변길이 <= 100
 *
 * 3. 1). 회전할 떄 기준축 2가지 경우 각각 고려
 *
 *    2).
 *
 * 4. BOJ 통나무 옮기기랑 비슷한 듯 싶다
 *
 *    너무 어렵다
 *
 *    아직 미완성. 로직 전체적으로 다시 예정임
 */

import java.util.LinkedList;
import java.util.Queue;

public class PRO_2020KAKAO_블록이동하기 {

    static int bLength, answer;
    static int[][] visited, board;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] rotateDir = {-1, 1};
    static Queue<Robot> q;

    static class Robot {
        int ax, ay, bx, by, time;

        public Robot(int ax, int ay, int bx, int by, int time) {
            this.ax = ax;
            this.ay = ay;
            this.bx = bx;
            this.by = by;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        bLength = board.length - 1;

        System.out.println(solution(board));
    }


    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;

        bfs(new Robot(0, 0, 0, 1, 0));

        return answer;
    }


    public static void bfs(Robot robot) {

        q = new LinkedList<>();
        visited[robot.ax][robot.ay] = 1;
        visited[robot.bx][robot.by] = 1;
        q.add(robot);

        visited = new int[bLength][bLength];

        while (!q.isEmpty()) {

            int size = q.size();
            for (int s = 0; s < size; s++) {

                Robot r = q.poll();

                if ((robot.ax == bLength && robot.ay == bLength) || (robot.bx == bLength && robot.by == bLength)) {
                    answer = Math.min(answer, robot.time);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int ax = r.ax + dir[i][0];
                    int ay = r.ay + dir[i][1];
                    int bx = r.bx + dir[i][0];
                    int by = r.by = dir[i][1];
                    int rt = r.time;

                    if (isRange(ax, ay, bx, by) && board[ax][ay] == 0 && board[bx][by] == 0
                            && (visited[ax][ay] != 2 && visited[bx][by] != 2)) {
                        ++visited[ax][ay];
                        ++visited[bx][by];
                        q.add(new Robot(ax, ay, bx, by, rt + 1));
                    }
                }

                if (r.ax == r.bx) {
                    rightRotate(r);
                }

                if (r.ay == r.by) {
                    leftRotate(r);
                }
            }


        }
    }


    public static void rightRotate(Robot robot) {
        for (int r : rotateDir) {
            int ax = robot.ax + r;
            int ay = robot.ay;
            int bx = robot.bx + r;
            int by = robot.by;

            if (board[ax][ay] == 0 && board[bx][by] == 0) {

            }
        }
    }


    public static void leftRotate(Robot robot) {
        for (int r : rotateDir) {
            int ax = robot.ax;
            int ay = robot.ay + r;
            int bx = robot.bx;
            int by = robot.by + r;

            if (board[ax][ay] == 0 && board[bx][by] == 0) {

            }
        }
    }



    public static boolean isRange(int x1, int y1, int x2, int y2) {
        if (x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0 &&
                x1 <= bLength && y1 <= bLength && x2 <= bLength && y2 <= bLength) {
            return true;
        } else {
            return false;
        }
    }

}
