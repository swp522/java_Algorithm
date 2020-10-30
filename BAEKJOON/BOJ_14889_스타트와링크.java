// 2020_10_30_금

/*

    1. 스타트팀 링크팀 능령치 차이 최솟값 구하기

    2. 4 <= n <= 20  /  n은 짝수  / 1 <= s값 <= 100

    3. 1) 조합으로 하나의 팀원들 구해주고 visit 처리

       2) !visit은 다른 팀으로 판단하고, 두 팀 caculate() 한다

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

    static int n, answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        map = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nCr(0, 0);

        System.out.println(answer);
    }


    public static void nCr(int index, int count) {
        if (count == n / 2) {
            answer = Math.min(answer, calculate());
            return;
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nCr(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }


    public static int calculate() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += map[i][j];
                }

                if (!visited[i] && !visited[j]) {
                    linkTeam += map[i][j];
                }
            }
        }

        return Math.abs(startTeam - linkTeam);
    }
}

