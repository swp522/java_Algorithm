//2020_03_30_월_과제_22회차_숫자 정사각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_숫자정사각형 {

    static int row, col, k, targetSize, squareMaxSize;
    static int[][] Rectangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        Rectangle = new int[row][col];
        k = Math.min(row, col);
        squareMaxSize = 1;
        targetSize = 1;

        for (int i = 0; i < row; i++) {
            String input = br.readLine();
            for (int j = 0; j < col; j++) {
                Rectangle[i][j] = (int) (input.charAt(j));
            }
        }
        //입력값 받을 때 런타임 에러 발생하여 int로 형변환 처리해서 받음

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                findSquare(i, j);
            }
        }
        System.out.println(squareMaxSize);
    }


    public static void findSquare(int x, int y) {
        for (int len = 0; len < k; len++) {
            if (x + len < row && y + len < col) {
                if (Rectangle[x][y] == Rectangle[x][y + len] && Rectangle[x][y] == Rectangle[x + len][y] && Rectangle[x][y] == Rectangle[x + len][y + len]) {
                    targetSize = (len + 1) * (len + 1);
                    squareMaxSize = Math.max(targetSize, squareMaxSize);
                }
            }
        }
    }
}
