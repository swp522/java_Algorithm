// 2020_02_04_목

/*

    1. Moo 수열의 n번째 글자 구하기

    2. 1 ≤ N ≤ 10^9

    3. 잘 모르겠어서 참고했는데 dp로 확인함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5904_Moo게임 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[30];
        dp[0] = 3;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = (dp[i - 1] * 2) + (i + 3);
        }

        getMoo(n);

        System.out.println();
    }


    private static char getMoo(int n) {
        if (n == 1) {
            return 'm';
        }
        if (n == 2 || n == 3) {
            return 'o';
        }

        int index = 0;
        while (dp[index] < n) {
            index++;
        }

        if (dp[index] == n) {
            return 'o';
        }

        if (n - dp[index - 1] == 1) {
            return 'm';
        }

        if (n - dp[index - 1] <= index + 3) {
            return 'o';
        }

        return getMoo((n - dp[index - 1] - (index + 3)));
    }
}
