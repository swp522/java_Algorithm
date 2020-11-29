// 2020_11_29_일

/*

    1. n 번쨰 수 출력하기

    2. n <= 10,000

    3. 브루트 포스인데 처음에 문제를 잘못 이해해서 오래걸림

 */

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class BOJ_1436_영화감독숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int num = 665;

        String s;
        while (true) {
            num++;
            s = Integer.toString(num);

            if (s.contains("666")) {
                count++;
            }

            if (count == n) {
                break;
            }
        }

        System.out.println(num);
    }
}
