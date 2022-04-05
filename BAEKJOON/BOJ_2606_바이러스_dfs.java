/*
1. 구햔

2. O(n^2)

3. dfs (bfs 도 가능)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_dfs {

    static int node, line, answer;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        answer = 0;
        map = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        int a, b;
        StringTokenizer st;
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }

        dfs(1);

        System.out.println(answer - 1);
    }

    public static void dfs(int start){
        if(visited[start]){
            return;
        }

        visited[start] = true;
        answer++;

        for(int i = 0; i < map[start].length; i++){
            if(map[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
