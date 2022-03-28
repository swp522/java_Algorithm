/*
1. 구현

2. O(n ^ 2)

3. 백트래킹, 재귀함수로 구현
 - 순열 중요한 문제

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

    static int[] arr;
    static boolean[] visited;
    static int n;
    static int answer = Integer.MIN_VALUE;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        selected = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth){
        if(depth == n){
            int sum = 0;
            for(int i = 0; i < n - 1; i++){
                sum += Math.abs(selected[i] - selected[i + 1]);
            }
            answer = Math.max(answer, sum);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
