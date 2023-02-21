import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFS_BFS {
    static int n, m, v; // 정점 개수, 간선 개수, 탐색시작 정점 번호
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(v);
    }

    public static void dfs(int v){
        visited[v] = true;
        System.out.print(v + " ");
        for(int i = 1; i <= n; i++){
            if(arr[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }


    public static void bfs(int v){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i = 1; i <= n; i++){
                if(arr[temp][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
