// 2020_12_27_일
// version 1.0

/*

    1. 가장 작은 창고 다각형의 면적 구하기

    2. n <= 1000   /   l, h <= 1000

    3. Stack 활용해서 구현

       1) lastIndex, maxIndex 구하기

       2) 스택써서 왼쪽, 오른쪽 각각 면적 값 더해주기 (중간에 stack 초기화)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[1001];
        heights[0] = 0;

        int lastIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            heights[L] = H;

            if (lastIndex < L) {
                lastIndex = L;
            }
            if (heights[maxIndex] < H) {
                maxIndex = L;
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int answer = heights[maxIndex];
        for (int i = 0; i < maxIndex; i++) {
            if (stack.peek() < heights[i]) {
                stack.push(heights[i]);
            }

            answer += stack.peek();
        }

        stack.clear();
        stack.push(0);

        for (int i = lastIndex; i > maxIndex; i--) {
            if (stack.peek() < heights[i]) {
                stack.push(heights[i]);
            }

            answer += stack.peek();
        }

        System.out.print(answer);
    }
}
