/*
1. 구현

2. O(n^2)

3. 너무 어렵게 생각했는데 대각선 꼭지점이 0, 0 인 사각형이었음
 - 주어진 3가지 조건을 i, j 고려하면서 그려보면 더 쉽게 구현할 수 있을 듯
 - StringBuilder 로 append 시간 효율 더 높아지는 듯
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16967_배열복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] B = new int[h + x][w + y];
        for(int i = 0 ; i < h + x; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w + y; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] A = new int[h][w];
        for(int i = 0 ; i < h + x; i++){
            for(int j = 0; j < w + y; j++){
                if(i < x && j < w){
                    A[i][j] = B[i][j];
                } else if(j < y && i < h){
                    A[i][j] = B[i][j];
                } else if(j >= y && i >= x && j < w && i < h){
                    A[i][j] = B[i][j] - A[i - x][j - y];
                }
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

}
