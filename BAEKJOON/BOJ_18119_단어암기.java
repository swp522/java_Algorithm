// 2020_05_07_금_문풀_34회차_단어암기

/*
 * 1. 각 쿼리별로 완전히 알고 있는 단어 개수 출력
 *
 * 2. 1 ≤ N ≤ 104,  1 ≤ M ≤ 5×10^4,  문자열 길이 <= 10^3
 *
 * 3. 문자열, 구현
 *
 * 4. flag 를 사용하는 것까지 생각했지만 마무리를 못했었음
 *
 *    정답 코드로 우선 정리함
 *
 *    알파벳 문제나오면 26 크기랑 'a' 빼줘서 input 받는거 생각하자
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18119_단어암기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] statusOfWord = new boolean[n][26];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                statusOfWord[i][word.charAt(j) - 'a'] = true;
            }
        }

        int answer = n;
        boolean[] forgetFlag = new boolean[n];
        int[] count = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            char target = st.nextToken().charAt(0);

            if (order == 1) {   // forget
                for (int j = 0; j < n; j++) {
                    if (statusOfWord[j][target - 'a']) {
                        count[j]++;
                        if (!forgetFlag[j]) {
                            answer--;
                        }
                        forgetFlag[j] = true;
                    }
                }
            } else {   // remember
                for (int j = 0; j < n; j++) {
                    if (forgetFlag[j] && statusOfWord[j][target - 'a']) {
                        count[j]--;
                        if (count[j] == 0) {
                            forgetFlag[j] = false;
                            answer++;
                        }
                    }
                }
            }

            System.out.println(answer);
        }

    }
}
