// 2020_06_19_금_41회차_과제1_소가 정보섬에 올라온 이유

/*
 * 1. S 값 구하기
 *
 * 2. 4 ≤ N ≤ 200,000 , 1 ≤ Q ≤ 200,000 , 1 ≤ |Ai| ≤ 10 , 1 ≤ Qi ≤ N
 *
 * 3. 1). -1 스티거 붙히면 계속 유지됨
 *
 *    2). solve1 : 그냥 구현했는데 시간 초과 발생함
 *
 *      -> 이거 구현할 때 temp = 0으로 둬서 시간 날림
 *
 *      -> for문이 많다보면 i, j 등 index 변수 알맞게 썼는지 확인하기
 *
 *    3). solve2 : 전체합 sum 구하고 부분합 parts[] 구해서 2 * (-1) * parts[] 빼주는 로직으로 해결
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17128_소가정보섬에올라온이유 {

    static int n, q, sum;
    static int[] cows, targetIndex, parts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        cows = new int[200000];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        targetIndex = new int[200000];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            targetIndex[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        getSum();
        solve2();
    }


    public static void getSum() {
        sum = 0;
        parts = new int[n];
        for (int j = 0; j < n; j++) {
            if (j == n - 3) {
                parts[j] = (cows[n - 3] * cows[n - 2] * cows[n - 1] * cows[0]);
            } else if (j == n - 2) {
                parts[j] = (cows[n - 2] * cows[n - 1] * cows[0] * cows[1]);
            } else if (j == n - 1) {
                parts[j] = (cows[n - 1] * cows[0] * cows[1] * cows[2]);
            } else {
                int temp = 1;
                for (int c = j; c < j + 4; c++) {
                    temp *= cows[c];
                }

                parts[j] = temp;
            }

            sum += parts[j];
        }
    }


    public static void solve2() {
        for (int i = 0; i < q; i++) {
            int sticker = targetIndex[i];
            for (int j = 0; j < 4; j++) {
                parts[sticker] *= -1;
                sum += 2 * parts[sticker];
                sticker--;
                if (sticker < 0) {
                    sticker = n - 1;
                }
            }

            System.out.println(sum);
        }
    }


    public static void solve1() {
        for (int i = 0; i < q; i++) {
            int answer = 0;
            cows[targetIndex[i]] *= -1;

            for (int j = 0; j < n; j++) {
                if (j == n - 3) {
                    answer += (cows[n - 3] * cows[n - 2] * cows[n - 1] * cows[0]);
                } else if (j == n - 2) {
                    answer += (cows[n - 2] * cows[n - 1] * cows[0] * cows[1]);
                } else if (j == n - 1) {
                    answer += (cows[n - 1] * cows[0] * cows[1] * cows[2]);
                } else {
                    int temp = 1;
                    for (int c = j; c < j + 4; c++) {
                        temp *= cows[c];
                    }
                    answer += temp;
                }
            }

            System.out.println(answer);
        }
    }

}
