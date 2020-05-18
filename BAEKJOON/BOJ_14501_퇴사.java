// 2020_05_18_월_과제_35회차_퇴사

/*
 * 1. 최대 수익 구하기
 *
 * 2. 1 ≤ N ≤ 15, 1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000
 *
 * 3. dp
 *
 * 4. dfs 도 가능할듯
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n + 6];
        int[] prices = new int[n + 6];
        int[] dp = new int[n + 6];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        for (int date = n; date > 0; date--) {
            int day = date + times[date];

            if (day <= n + 1) {
                dp[date] = Math.max(prices[date] + dp[day], dp[date + 1]);
            } else{ // 상담일이 마지막날을 초과하는 경우 dp[date + 1]이 받을 수 있는 최대 금액
                dp[date] = dp[date + 1];
            }
        }

        System.out.println(dp[1]);  //1일 이후에 상담해서 받을 수 있는 최대 수익 출력
    }
}
