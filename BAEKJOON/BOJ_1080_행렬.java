/*
1. 연산 최솟값 구하기. 구현 문제

2. 그리디, 구현

3. O(n ^ 4)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080_행렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            for(int j = 0; j < m; j++){
                b[i][j] = temp.charAt(j) - '0';
            }
        }

        int answer = 0;
        for(int i = 0; i <= n - 3; i++){
            for(int j = 0; j <= m - 3; j++){
                if(a[i][j] != b[i][j]){
                    answer++;
                    for(int k = i; k < i + 3; k++){
                        for(int l = j; l < j + 3; l++){
                            if(a[k][l] == 0){
                                a[k][l] = 1;
                            } else{
                                a[k][l] = 0;
                            }
                        }
                    }
                }
            }
        }

        boolean flag = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(a[i][j] != b[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag){
            System.out.println(answer);
        } else{
            System.out.println(-1);
        }
    }
}
