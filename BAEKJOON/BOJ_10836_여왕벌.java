// 2020_06_26_금_43회차_문풀1_여왕벌

/*
 * 1. 마지막 애벌레들의 크기 출력하기
 *
 * 2. 2 ≤ M ≤ 700   , 1 ≤ N ≤ 1,000,000
 *
 * 3. 1). 값 바뀔 때마다 for문 돌리니까 시간초과 발생
 *
 *    2). startBug[]에 0 ,1, 2 + 해서 순서대로 들어가게 넣어줌
 *
 *    3). solve() : 맨 왼쪽 아래부터 오른쪽 위 순서대로 가면서 map 갱신해줌
 *
 *    4). 맨 위에 행 값들 밑으로 내려줌
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10836_여왕벌 {

    static int m, n;
    static int[][] map;
    static int[] startBugs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[700][700];
        startBugs = new int[2000];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 0; i < 2 * m - 1; i++) {
            startBugs[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            for (int j = zero; j < zero + one; j++) {
                startBugs[j] += 1;
            }

            for (int j = zero + one; j < 2 * m - 1; j++) {
                startBugs[j] += 2;
            }
        }

        solve();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void solve() {

        int hang = m - 1;
        int yeol = 0;

        for (int i = 0; i < 2 * m - 1; i++) {
            if (hang == 0) {
                map[hang][yeol] = startBugs[i];
                yeol++;
            } else {
                map[hang][yeol] = startBugs[i];
                hang--;
            }
        }

        for (int y = 1; y < m; y++) {
            int target = map[0][y];

            for (int h = 1; h < m; h++) {
                map[h][y] = target;
            }
        }
    }

}
