// 2020_05_06_수_문풀_14회차_캐슬 디펜스

/*
 * 1. 제거할 수 있는 적의 최대 수?
 *
 * 2. 궁수 3명, 3 ≤ N, M ≤ 15, 1 ≤ D ≤ 10
 *
 * 3. dfs, 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {

    static int n, m, d;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



    }


    public static void solve() {

    }
}
