/*
1. 아이디어
- 2중 for, 값 1 && 방문 x -> dfs
- dfs를 통해 찾은 값을 저장 후 정렬해서 출력

2. 시간복잡도
- dfs O(V + E)
- V, E : N^2, 4N^2
- V + E : 5N ^ 2 -> N ^ 2 -> 625 -> 2억보다 낮은값. 사용 가
- bfs가 더 빠른 것 같다

3. 자료구조
- 그래프 저장 : int[][]
- 방문여부 : bool[][]
- 결과값 : int[][]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667_단지번호붙이기 {

    static int n, apartCount;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static int[] answerArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        apartCount = 0;
        answerArray = new int[n * n];

        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    apartCount++;
                }
            }
        }

        System.out.println(apartCount);
        Arrays.sort(answerArray);
        for (int i = 0; i < answerArray.length; i++) {
            if(answerArray[i] != 0) {
                System.out.println(answerArray[i]);
            }
        }
    }


    public static void dfs(int x, int y) {
        answerArray[apartCount]++;
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int dx = x + dir[d][0];
            int dy = y + dir[d][1];

            if (dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
            if (map[dx][dy] != 1 || visited[dx][dy]) continue;

            dfs(dx, dy);
        }
    }
}

