// 2020_09_16_수_1회차

/*

    1. 땅 고르기에 걸리는 '최소 시간'과 그 경우 '땅 높이' 구하기

    2. 1 ≤ M, N ≤ 500,  0 ≤ B ≤ 6.4 × 10^7 , 작업 시작시 인벤에 b개 있음

    3. 1). 입력받을 때 최대/최소 height 구해주기

       2). 1작업 2초, 2작업 1초 파내고 넣어주는 로직


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111_마인크래프트 {

    static int row, col, b, answerTime, answerHeight, maxHeight, minHeight;
    static int[][] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        heights = new int[row][col];
        answerTime = Integer.MAX_VALUE;
        answerHeight = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                heights[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, heights[i][j]);
                minHeight = Math.min(minHeight, heights[i][j]);
            }
        }

        for (int h = minHeight; h <= maxHeight; h++) {
            int time = 0;
            int block = b;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int term = heights[i][j] - h;
                    if (term > 0) {
                        time += term * 2;
                        block = block + term;
                    } else if (term < 0) {
                        time -= term;
                        block += term;
                    }
                }
            }

            if ((block >= 0) && (time <= answerTime)) {
                answerTime = time;
                answerHeight = h;
            }

        }

        System.out.println(answerTime + " " + answerHeight);
    }
}
