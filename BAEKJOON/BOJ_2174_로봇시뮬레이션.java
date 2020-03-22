//2020_03_23_과제_20회차_로봇 시뮬레이션
//시뮬레이션 구현 문제
//런타임 에러 해결 : System.exit(0);
//출력문 영어 문장 오타로 '틀렸습니다' 발생

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
    int x, y, direction;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}


public class BOJ_2174_로봇시뮬레이션 {

    static int row, col, n, m;
    static int[][] map;
    static Robot[] robot;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new int[row + 1][col + 1];

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        robot = new Robot[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int d = 0;
            char c = st.nextToken().charAt(0);
            if (c == 'N') {
                d = 3;
            }
            else if (c == 'W') {
                d = 1;
            }
            else if (c == 'E') {
                d = 2;
            }

            robot[i] = new Robot(x, y, d);
            map[x][y] = 1;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char order = st.nextToken().charAt(0);
            int count = Integer.parseInt(st.nextToken());

            if (order != 'F') {
                count %= 4;
            }

            for (int c = 0; c < count; c++) {
                if (order == 'R') {
                    if (robot[index].direction == 0) {
                        robot[index].direction = 1;
                    } else if (robot[index].direction == 1) {
                        robot[index].direction = 3;
                    } else if (robot[index].direction == 2) {
                        robot[index].direction = 0;
                    } else if (robot[index].direction == 3) {
                        robot[index].direction = 2;
                    }
                } else if (order == 'L') {
                    if (robot[index].direction == 0) {
                        robot[index].direction = 2;
                    } else if (robot[index].direction == 1) {
                        robot[index].direction = 0;
                    } else if (robot[index].direction == 2) {
                        robot[index].direction = 3;
                    } else if (robot[index].direction == 3) {
                        robot[index].direction = 1;
                    }
                } else if (order == 'F') {
                    int x = robot[index].x;
                    int y = robot[index].y;
                    int direction = robot[index].direction;

                    int dx = x + dir[direction][0];
                    int dy = y + dir[direction][1];

                    if (dx < 1 || dy < 1 || dx > row || dy > col) {
                        System.out.println("Robot " + index + " crashes into the wall");
                    }
                    if (map[dx][dy] == 1) {
                        int Y_robot = 0;
                        for (int t = 1; t <= n; t++) {
                            if (robot[t].x == dx && robot[t].y == dy) {
                                Y_robot = t;
                            }
                        }
                        System.out.println("Robot " + index + " crashes into robot " + Y_robot);
                    }

                    map[x][y] = 0;  //여기 생각못함
                    map[dx][dy] = 1;
                    robot[index].x = dx;
                    robot[index].y = dy;
                }
            }
        }
        System.out.println("OK");
    }

}
