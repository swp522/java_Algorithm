// 2020_11_11_수

/*

    1. 최대 점수와 최소 점수 구하기

    2. 1 ≤ N ≤ 100,000

    3. DP로 최대, 최소 각각 3가지 CASE 비교하면서 더해간다

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기 {

    static int n;
    static int[][] map, dpMax, dpMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMax() + " " + getMin());
    }

    private static int getMax() {
        dpMax = new int[n][3];
        dpMax[0][0] = map[0][0];
        dpMax[0][1] = map[0][1];
        dpMax[0][2] = map[0][2];

        for (int i = 1; i < n; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + map[i][0];
            dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]) + map[i][1];
            dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + map[i][2];
        }

        return Math.max(Math.max(dpMax[n - 1][0], dpMax[n - 1][1]), dpMax[n - 1][2]);
    }


    private static int getMin() {
        dpMin = new int[n][3];
        dpMin[0][0] = map[0][0];
        dpMin[0][1] = map[0][1];
        dpMin[0][2] = map[0][2];

        for (int i = 1; i < n; i++) {
            dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + map[i][0];
            dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]) + map[i][1];
            dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + map[i][2];
        }

        return Math.min(Math.min(dpMin[n - 1][0], dpMin[n - 1][1]), dpMin[n - 1][2]);
    }
}
