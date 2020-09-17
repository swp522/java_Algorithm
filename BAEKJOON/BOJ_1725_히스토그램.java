// 2020_09_16_수_1회차

/*

    1. 가장 큰 직사각형 넓이 구하기

    2. 1 ≤ N ≤ 100,000  , 0 < height < 1,000,000,000  , 넓이 < 20억

    3. 1). 처음에 push(0) 해주고 n + 1 까지 for 문 돌아서 '끝처리' 해줌 -> 이게 너무 어려움

       2). while 밖에 push(i) index를 넣는다

       3). pop()이랑 다음 값이랑 비교해서 다음 값이 크면 왼>오 전진하고 작으면 왼쪽으로 가서 width 구해준다

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1725_히스토그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] heights = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        for (int i = 1; i <= n + 1; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.peek()];
                stack.pop();
                int width = i - stack.peek() - 1;

                answer = Math.max(answer, width * height);
            }

            stack.push(i);
        }

        System.out.println(answer);
    }
}
