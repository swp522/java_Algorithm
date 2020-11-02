// 2020_11_02_월

/*

    1. 경로가 겹치는 쌍의 수 구하기

    2. 총 52글자 수

    3. 구현, 문제 이해하는데 오래걸림

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14468_소가길을건너간이유2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean[] visited = new boolean[26];
        int[] alpha;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - 'A';
            if (visited[now]) {
                continue;
            }

            visited[now] = true;

            alpha = new int[26];
            alpha[now]++;

            for (int j = i + 1; j < input.length(); j++) {
                int next = input.charAt(j) - 'A';
                alpha[next]++;

                if (next == now) {
                    for (int k = 0; k < 26; k++) {
                        if (visited[k] && alpha[k] == 1) {
                            count++;
                        }
                    }

                    break;
                }
            }
        }

        System.out.println(count);
    }
}
