// 2020_05_07_금_과제_34회차_용감한 용사 진수

/*
 * 1. k명 병사 이길 수 있는 최소의 스탯 포인트 출력
 *
 * 2. 1 ≤ K ≤ N ≤ 100, 0 ≤ 힘, 민첩, 지능 ≤ 1000000
 *
 * 3. 구현
 *
 * 4. 총점만 크면 되는줄 알았는데 각각 능력치별 3가지 ">= 조건" 만족한 상태로 커야함
 *
 *    그냥 모든 경우의수 다 구해가면서 MIN SUM값 골라내면 된다. 시간 초과는 안터지네...?
 *
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14718_용감한용사진수 {

    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] soldier = new int[n][3];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                soldier[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < n; m++) {
                    int count = 0;
                    for (int t = 0; t < n; t++) {
                        if (soldier[i][0] >= soldier[t][0] && soldier[j][1] >= soldier[t][1] && soldier[m][2] >= soldier[t][2]) {
                            count++;
                        }
                    }
                    if (count >= k) {
                        answer = Math.min(answer, soldier[i][0] + soldier[j][1] + soldier[m][2]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
