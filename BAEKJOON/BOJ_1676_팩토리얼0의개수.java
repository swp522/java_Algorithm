// 2020_12_12_토

/*

    1. 뒤에서 처음 0이아닌 숫자 나올때까지 0의 개수 구하기

    2. 0 ≤ N ≤ 500

    3. 2 x 5 이면 10인데, 5의 개수에 따라서 0이 결정되는걸 활용

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int zeroCount = 0;

        for (int i = 1; i <= n; i++) {
            int target = i;
            while (target % 2 == 0 || target % 5 == 0) {
                if (target % 2 == 0) {
                    target /= 2;
                }

                if (target % 5 == 0) {
                    target /= 5;
                    zeroCount++;
                }
            }
        }

        System.out.println(zeroCount);
    }
}
