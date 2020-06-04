// 2020_06_05_금_38회차_과제1_음식평론가
// 극은 코테라 불참

/*
 * 1. 소시지 나눠줄 때 최소 칼질 횟수구하기
 *
 * 2. 1 ≤ N, M ≤ 100
 *
 * 3. 구현, 최대공약수
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1188_음식평론가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 소세지 수
        int m = Integer.parseInt(st.nextToken());   // 사람 수

        int answer = m - solve(n, m);
        System.out.println(answer);
    }

    public static int solve(int n, int m) {
        while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }

        return n;
    }

}
