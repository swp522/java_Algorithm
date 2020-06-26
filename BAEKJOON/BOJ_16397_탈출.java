// 2020_06_26_금_43회차_과제1_탈출

/*
 * 1. 탈출에 필요한 최소 버튼 횟수
 *
 * 2. 0 ≤ N, G ≤ 99,999   , 1 ≤ T ≤ 99,999
 *
 * 3. 1). clicks[] 의 index인 now가 현재 숫자 나타내고, 그 배열 값이 클릭 수 나타냄
 *
 *    2). selectForDigit() 메서드 참고함
 *
 * 4. 1). boj_1697_숨바꼭질과 유형 비슷함
 *
 *    2). int[] 하나로 처리하려다가 그냥 boolean[] 만듬
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16397_탈출 {

    static int n, t, g, answer;
    static int[] clicks;
    static  boolean[] visited;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   // 시작 숫자
        t = Integer.parseInt(st.nextToken());   // 최대 버튼 횟수
        g = Integer.parseInt(st.nextToken());   // 목표 숫자
        answer = -1;

        bfs();

        if (answer == -1) {
            System.out.println("ANG");
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs() {
        q = new LinkedList<>();
        clicks = new int[100001];
        visited = new boolean[100001];
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (clicks[now] > t) {
                break;
            }

            if (now == g) {
                answer = clicks[now];
                return;
            }

            int nextA = now + 1;
            if (!visited[nextA] && nextA <= 99999) {
                visited[nextA] = true;
                q.add(nextA);
                clicks[nextA] = clicks[now] + 1;
            }

            int temp = 2 * now;
            if (temp > 99999) {
                continue;
            }

            int nextB = temp;
            nextB -= selectForDigit(temp);

            if (!visited[nextB] && 2 * now <= 99999) {
                visited[nextB] = true;
                q.add(nextB);
                clicks[nextB] = clicks[now] + 1;
            }
        }

    }

    public static int selectForDigit(int n) {
        int digit = 1;
        while (n != 0) {
            n /= 10;
            digit *= 10;
        }
        return digit / 10;
    }

}
