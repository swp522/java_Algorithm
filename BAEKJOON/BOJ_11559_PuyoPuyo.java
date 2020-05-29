// 2020_05_29_금_과제_Puyo Puyo

/*
 * 1. 몇연쇄가 일어나는지 구하기
 *
 * 2. 12 * 6 크기 map
 *
 * 3. 뿌요가 4개 이상 모이면 터짐
 *
 *    while 문에서 터뜨리고(bfs) 내리기 반복
 *
 *    내리는거 로직은 참고함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_11559_PuyoPuyo {

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][] visited;
    static int bombCount, round;

    static class Puyo {
        int x;
        int y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        round = 0;

        for (int i = 0; i < 12; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                map[i][j] = input[j];
            }
        }

        while (true) {
            visited = new boolean[12][6];
            bombCount = 0;

            for (int i = 11; i >= 0; i--) {
                for (int j = 5; j >= 0; j--) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        bfs(new Puyo(i, j));
                    }
                }
            }
            // 터질게 없는 경우
            if (bombCount == 0) {
                break;
            } else {
                round++;
            }

            // 남은 뿌요들 밑으로 내리기
            getDown();
        }

        System.out.println(round);
    }


    private static void bfs(Puyo p) {
        char target = map[p.x][p.y];
        int count = 0;
        Queue<Puyo> q = new LinkedList<Puyo>();
        ArrayList<Puyo> puyoList = new ArrayList<Puyo>();
        visited[p.x][p.y] = true;
        q.add(p);

        while (!q.isEmpty()) {
            Puyo t = q.poll();
            puyoList.add(t);
            count++;

            for (int i = 0; i < 4; i++) {
                int dx = t.x + dir[i][0];
                int dy = t.y + dir[i][1];

                if (isRange(dx, dy) && !visited[dx][dy] && map[dx][dy] == target) {
                    visited[dx][dy] = true;
                    q.add(new Puyo(dx, dy));
                }
            }
        }

        // 4개 이상 연결된 경우 . 으로 바꿔주기
        if (count >= 4) {
            bombCount++;
            for (int i = 0; i < puyoList.size(); i++) {
                Puyo tempPuyo = puyoList.get(i);
                map[tempPuyo.x][tempPuyo.y] = '.';
            }
        }

    }

    private static void getDown() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 5; j >= 0; j--) {
                if (map[i][j] != '.') {

                    int target = -1;

                    // 해당 열에서 가장 밑에 있는 . 의 행 index 찾아서 target 으로 설정
                    for (int k = 11; k > i; k--) {
                        if (map[k][j] == '.') {
                            target = k;
                            break;
                        }
                    }

                    // target 가 존재하면 (i, j)에 있는 Puyo 를 (target, j) 로 내리기
                    if (target != -1) {
                        char temp = map[i][j];
                        map[i][j] = map[target][j];
                        map[target][j] = temp;
                    }

                }
            }
        }

    }


    private static boolean isRange(int x, int y) {
        if (x >= 0 && x < 12 && y >= 0 && y < 6) {
            return true;
        } else {
            return false;
        }
    }

}
