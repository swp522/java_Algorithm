//2020_03_27_과제_21회차_근손실
//경우의수 모두 구하는 순열문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18429_근손실 {

    static int n, k, count, answer;
    static int[] kits;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        kits = new int[n + 1];
        visited = new boolean[n + 1];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
            kits[i] -= k;
        }

        for (int i = 1; i <= n; i++) {
            if (kits[i] >= 0) {
                visited[i] = true;
                nPr(1, kits[i]);
                visited[i] = false;
            }
        }

        System.out.println(answer);
    }

    public static void nPr(int count, int sum) {
        if (count == n) {
            answer++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == false && sum + kits[i] >= 0) {
                visited[i] = true;
                nPr(count + 1, sum + kits[i]);
                visited[i] = false;
            }
        }
        return;
    }
}
