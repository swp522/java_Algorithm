// 2020_06_16_화_40회차_과제1_견우와 직녀

/*
 * 1. 견우가 직녀에게 도착하는 최소 시간 구하기
 *
 * 2. 2 ≤ N ≤ 10,  2 ≤ M ≤ 20,  0 <= 각 칸 값 <= 20
 *
 * 3. bfs, 구현
 *
 * 4. 문제 이해가 어려웠다
 *
 *    아직 미완성
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16137_견우와직녀 {

    static int n, m, count;
    static int[][] map, dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visited;
    static Queue<Place> q;
    static ArrayList<Place> canMakeOjakGyo;

    static class Place {
        int x, y;

        public Place(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];
        count = 0;

        canMakeOjakGyo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0 && isoJakGyo(i, j)){
                    canMakeOjakGyo.add(new Place(i, j));
                }
            }
        }

        bfs(new Place(0, 0));

        for(int i = 0; i < canMakeOjakGyo.size(); i++){
            map[canMakeOjakGyo.get(i).x][canMakeOjakGyo.get(i).y] = m;

        }

        // 구현중

        System.out.println(count);
    }


    public static void bfs(Place place) {
        q = new LinkedList<>();
        visited[place.x][place.y] = true;
        q.add(place);

        while (!q.isEmpty()) {
            Place p = q.poll();

        }

    }


    public static boolean isoJakGyo(int x, int y) {
        int ax, ay, bx, by;
        for (int i = 0; i < 4; i++) {
            ax = x + dir[i][0];
            ay = y + dir[i][1];
            if (i == 3) {
                bx = x + dir[0][0];
                by = y + dir[0][1];
            } else {
                bx = x + dir[i + 1][0];
                by = y + dir[i + 1][1];
            }
            if (isRange(ax, ay) && isRange(bx, by) && map[ax][ay] == 0 && map[bx][by] == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        } else {
            return false;
        }
    }
}
