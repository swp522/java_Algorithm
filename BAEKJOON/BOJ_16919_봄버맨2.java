// 2020_05_04_월_31회차_과제_봄버맨2

/*
 * 1. n초 후 map 상태 출력하기
 *
 * 2. 1 ≤ R, C ≤ 200, 1 ≤ N ≤ 10^9
 *
 * 3. bfs, 구현
 *
 * 4. 1). 봄버맨1이랑 똑같은데 n 범위 때문에 그대로 돌렸으면 시간초과 터짐
 *
 *    2). 혼자 추측은 했는데, n 값 모듈러 연산시키는 거 생각하는게 너무 오래걸렸음
 *
 *    3). 기계적으로 while안에 !q.isEmpty() 썼음 -> 채점 중 90% 에서 계속 틀렸습니다 나왔었음
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16919_봄버맨2 {

    static class Bomb{
        int x, y;
        public Bomb(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int row, col, n, bombTime, time;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static int[][] bombMap;
    static Queue<Bomb> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        bombMap = new int[row][col];
        q = new LinkedList<>();
        bombTime = 3;
        time = 0;

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = input.charAt(j);
                if (input.charAt(j) == 'O') {
                    q.add(new Bomb(i, j));
                    bombMap[i][j] = bombTime;
                }
            }
        }

        if (n > 1) {
            n = (n - 2) % 4 + 2;
        }

        bfs();

        printMap();
    }

    public static void bfs() {

        while (true) {
            time++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Bomb bomb = q.poll();

                if (bombMap[bomb.x][bomb.y] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int dx = bomb.x + dir[i][0];
                        int dy = bomb.y + dir[i][1];
                        if (isRange(dx, dy)) {
                            if (bombMap[dx][dy] != bombMap[bomb.x][bomb.y]) {
                                map[dx][dy] = '.';
                                bombMap[dx][dy] = 0;
                            }
                        }
                    }
                    map[bomb.x][bomb.y] = '.';
                    bombMap[bomb.x][bomb.y] = 0;
                } else if(bombMap[bomb.x][bomb.y] > 1){
                    bombMap[bomb.x][bomb.y]--;
                    q.add(bomb);
                }
            }

            if (time % 2 == 0) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bombMap[i][j] = bombTime;
                            q.add(new Bomb(i, j));
                        }
                    }
                }
            }

            if (time == n) {
                break;
            }
        }
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < row && y < col) {
            return true;
        } else {
            return false;
        }
    }


    public static void printMap() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
