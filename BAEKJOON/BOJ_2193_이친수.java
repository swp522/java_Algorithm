// 2020_12_29_월
// version 1.0

/*

    1. 이친수(0으로 시작 X, 1이 두번 연속 X) 개수 구하기

    2. 1 ≤ N ≤ 90

    3. 직접 개수 적어보니 '피보나치 수열' 구현으로 해결할 수 있음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193_이친수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] num = new long[n];

        if (n == 1) {
            num[0] = 1;
        } else if (n == 2) {
            num[1] = 1;
        } else {
            num[0] = 1;
            num[1] = 1;
            for (int i = 2; i < n; i++) {
                num[i] = num[i - 1] + num[i - 2];
            }
        }

        System.out.print(num[n - 1]);
    }
}
