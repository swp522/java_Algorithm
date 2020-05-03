// 2020_05_03_일_n 과 m(1)

/*
 * 1. 중복 허용 >> 순열 찾기
 *
 * 2. 1 ≤ M ≤ N ≤ 8
 *
 * 3. dfs 백트래킹
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_N과M1 {

    static int n, m;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[m];
        visited = new boolean[n + 1];
        dfs(0);
    }

    public static void dfs(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(list[i] + " ");
            }
            System.out.println();
            return;

        } else {
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list[count] = i;
                    dfs(count + 1);//끝까지 간다음에 밑 line 감
                    visited[i] = false;
                }
            }
        }
    }
}
