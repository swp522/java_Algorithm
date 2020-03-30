//2020_03_30_월_과제_22회차_병사 배치하기
//LIS 알고리즘 -> DP 적용, 감소하는 방향

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18353_병사배치하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] soldiers = new int[num + 1];
        int[] dp = new int[num + 1];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < num; i++) {
            {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {   // j는 i보다 작은 구간에서 ++
                    if (soldiers[i] < soldiers[j] && dp[i] < dp[j] + 1) {   // 감소 && 구간 길이
                        dp[i] = dp[j] + 1;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        System.out.println(num - max);
    }
}
