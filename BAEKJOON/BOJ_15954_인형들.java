// 2020_04_20_월_문풀_28회차_KAKAO_인형들

/*
 * 1. 선택된 인형들을 선호하는 사람의 수의 표준편차 출력
 *
 * 2. 1 <= n <= 500 , 1 <= k <= n
 *
 * 3. 조건문으로 k경우의수 만큼의 index 를 arr에서 연속된 거 뽑아서 구한다
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15954_인형들 {
    static int n, k;
    static double answer, pyojoon, mean, boonsan;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = Double.MAX_VALUE;
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = k; i <= n; i++) {  // k = 3, 4, 5
            for (int j = 0; j <= n - i; j++) {  // 3묶음, 2묶음, 1묶음

                double sum = 0.0;
                for (int s = j; s < j + i; s++) {   // 3묶음([0 1 2번째], [1 2 3 번째], [2 3 4번째])
                    sum += arr[s];                  // 2묶음([0 1 2 3 번째],[1 2 3 4 번째]), 1묶음([0 1 2 3 4 번째])
                }
                mean = sum / i;

                double tempsum = 0.0;
                for (int s = j; s < j + i; s++) {
                    tempsum += ((arr[s] - mean) * (arr[s] - mean)/i);
                }
                boonsan = tempsum;
                pyojoon = Math.sqrt(boonsan);

                answer = Math.min(answer, pyojoon);

            }
        }
        System.out.println(String.format("%.11f", answer));
    }
}