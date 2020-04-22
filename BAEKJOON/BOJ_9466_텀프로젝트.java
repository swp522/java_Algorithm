// 2020_04_22_수_과제_12회차_팀프로젝트

/*
 * 1. 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 구하라
 *
 * 2. 2 <= n <= 100,000
 *
 * 3. dfs + finished[i] 저장
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466_팀프로젝트 {

    static int n, cycleCount;
    static int[] students;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];  //visited 된곳을 또 visit 하면 올라감 (싸이클의 멤버를 카운트 하려고 만듬)
            cycleCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) {
                    dfs(i);
                }
            }
            System.out.println(n - cycleCount);
        }
    }

    public static void dfs(int now) {
        if (visited[now]) {
            finished[now] = true;
            cycleCount++;
        } else {
            visited[now] = true;
        }

        int nextIndex = students[now];

        if (!finished[nextIndex]) {
            dfs(nextIndex);
        }
        visited[now] = false;
        finished[now] = true;
    }
}
