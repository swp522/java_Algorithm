// 2020_11_16_월

/*

    1. 햄버거 먹을 수 있는 사람 최대 수 구하기

    2. 1 <= n <= 20000   /   1 <= k <= 10

    3. 문자열 다루기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String inputString = br.readLine();

        boolean[] ate = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (inputString.charAt(i) == 'P') {
                for (int j = i - k; j <= i + k; j++) {
                    if (j >= 0 && j < n && inputString.charAt(j) == 'H' && !ate[j]) {
                        ate[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
