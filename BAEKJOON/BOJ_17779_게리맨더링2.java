// 2020_07_01_수_게리맨더링2

/*
 * 1. 인구 가장 많은 선거구와 가장 적은 선거구 차이 구하기
 *
 * 2. 5 ≤ N ≤ 20 , 1 ≤ A[r][c] ≤ 100
 *
 * 3. 1). 5 번 구역의 (x, y) 기준으로 나머지 3개의 꼭지점을 이용해서 범위 구간 나타내야함
 *
 *    2). 5번 구역에 region 값 5로 넘버링
 *
 *    3). 1 ~ 4 영역은 for문 도는게 사각형범위니까 region != 5 인 곳의 값 sum 해주면 영역합 구할 수 있다
 *
 * 4. 1). 문제 조건을 이해하고 if 절에 넣는게 오래걸렸음
 *
 *    2). 5번 영역 어떻게 sum 할지 참고함
 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17779_게리맨더링2 {

    static int n, answer;
    static int[] people;
    static int[][] map, region;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        answer = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int d1 = 1; d1 <= n; d1++) {
                    for (int d2 = 1; d2 <= n; d2++) {
                        if (j - d1 > 0 && i + d1 + d2 <= n && j + d2 <= n) {
                            sumOfArea(i, j, d1, d2);
                            answer = Math.min(answer, getDifference());
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void sumOfArea(int x, int y, int d1, int d2) {
        people = new int[6];
        region = new int[n + 1][n + 1];
        int left = 0;
        int right = 0;
        boolean leftLimit = true;
        boolean rightLimit = true;

        // 5구역
        for (int i = x; i <= x + d1 + d2; i++) {

            for (int j = y + left; j <= y + right; j++) {
                region[i][j] = 5;
                people[5] += map[i][j];
            }

            if (left == -d1) {
                leftLimit = false;
            }

            if (right == d2) {
                rightLimit = false;
            }

            if (leftLimit) {
                left--;
            } else {
                left++;
            }

            if (rightLimit) {
                right++;
            } else {
                right--;
            }
        }

        // 1 구역
        for (int i = 1; i < x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if (region[i][j] != 5) {
                    people[1] += map[i][j];
                }
            }
        }
        // 2 구역
        for (int i = 1; i <= x + d2; i++) {
            for (int j = y + 1; j <= n; j++) {
                if (region[i][j] != 5) {
                    people[2] += map[i][j];
                }
            }
        }
        // 3 구역
        for (int i = x + d1; i <= n; i++) {
            for (int j = 1; j < y + d2 - d1; j++) {
                if (region[i][j] != 5) {
                    people[3] += map[i][j];
                }
            }
        }
        // 4 구역
        for (int i = x + d2 + 1; i <= n; i++) {
            for (int j = y + d2 - d1; j <= n; j++) {
                if (region[i][j] != 5) {
                    people[4] += map[i][j];
                }
            }
        }
    }

    public static int getDifference() {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int i = 1; i <= 5; i++) {
            maxNum = Math.max(maxNum, people[i]);
            minNum = Math.min(minNum, people[i]);
        }
        return maxNum - minNum;
    }
}
