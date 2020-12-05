// 2020_12_05_토

/*

    1. 입력된 숫자들 합 구하기

    2. 1 ≤ K ≤ 100,000

    3. 스택으로 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int input;
        for (int i = 0; i < k; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
                continue;
            }

            stack.push(input);
        }

        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}
