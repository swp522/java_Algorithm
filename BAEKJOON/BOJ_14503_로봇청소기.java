/*
1. 아이디어
- dfs 로 가능 (2022.02.16)
- 시뮬레이션 - while 으로 특정조건 종료될때까지 반복
- 4방향을 for 문으로 탐색
- 더이상 탐색이 불가능할 경우, 뒤로 한칸 후진
- 후진이 불가능하면 종료

2. 시간복잡도
- O(NM) = (4(방향)) x N x M = 50^2 < 2억
- 가능

3. 자료구조
- map : int[][]
- 로봇청소기 위치, 방향, 전체 청소한 곳 수

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기  {

    static int n, m, r, c, d, count;
    static int[][] map;
    static int[][] dir = {{-1,0},{0, 1},{1, 0},{0, -1}};    // 북, 동, 남, 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        count = 0;
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);

        System.out.println(count);

    }

    public static void clean(int x, int y, int direction){
        if(map[x][y] == 0){
            map[x][y] = 2;
            count++;
        }

        boolean isNotCleanYet = false;
        int initialDirection = direction;
        for(int i = 0; i < 4; i++){
            int dd = (direction + 3) % 4;
            int dx = x + dir[dd][0];
            int dy = y + dir[dd][1];

            if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
            if(map[dx][dy] == 0){
                clean(dx, dy, dd);
                isNotCleanYet = true;
                break;
            }

            direction = (direction + 3) % 4;
        }

        if(!isNotCleanYet) {
            int dd = (initialDirection + 2) % 4;
            int dx = x + dir[dd][0];
            int dy = y + dir[dd][1];

            if(dx > 0 && dy > 0 && dx < n && dy < m){
                if(map[dx][dy] != 1){
                    clean(dx, dy, initialDirection);
                }
            }
        }
    }
}
