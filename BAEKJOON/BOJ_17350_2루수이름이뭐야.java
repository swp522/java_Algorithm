// 2020_05_03_월_과제_23회차_2루수 이름이 뭐야

/*
 * 1. ang 포함된 문자열이면 뭐야; 출력하고 아니면 뭐야? 출력하기
 *
 * 2. 1 ≤ N ≤ 1,000
 *
 * 3. 문자열 구현
 *
 * 4. contains 써야하는줄 알았다
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17350_2루수이름이뭐야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("anj")) {
                flag = true;
                break;
            }
        }
        System.out.println(flag ? "뭐야;" : "뭐야?");
    }
}
