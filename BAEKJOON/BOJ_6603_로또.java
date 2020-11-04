// 2020_11_04_수

/*

    1. 주어진 수들로 경우의수 다 출력하기

    2. 주어지는 수는 1 이상 49 이하  /  k > 6

    3. 조합으로 구현하기

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {

    static int k;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0){
                break;
            }
            arr = new int[k];
            visited = new boolean[k];

            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }

            System.out.println();
        }

        for (int i = start; i < k; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
