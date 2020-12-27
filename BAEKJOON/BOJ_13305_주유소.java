// 2020_12_27_일
// version 1.0

/*

    1. 1km 마다 1리터 기름 사용하는데 최소 비용 구하기

    2. 2 ≤ N ≤ 100,000   /  거리, 가격 <= 1,000,000,000

    3. 다음 기름 값이 이전 기름 값보다 비싸면 이전 값으로 대체하는 방식으로 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] distance = new long[n - 1];
        long[] price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            if (price[i] < price[i + 1]) {
                price[i + 1] = price[i];
            }
        }

        long answer = 0;
        for (int i = 0; i < n - 1; i++) {
            answer += (price[i] * distance[i]);
        }

        System.out.print(answer);
    }
}
