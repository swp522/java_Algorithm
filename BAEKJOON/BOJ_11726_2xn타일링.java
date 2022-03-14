/*
1. 아이디어
- 점화식 : an = an-1 + an-2
- N값 구하기 위해, for문으로 3부터 n까지의 값을 구해주기
- 이전값, 이전이전값 더해서 10007로 나눠 저장

2. 시간 복잡도
- O(n)

3. 자료구조
- dp값 저장하는 경우의수 배열 : int[] dp
- 최대값 : 10007보다 작음 > int
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);
    }
}
