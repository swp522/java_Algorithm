// 2020_12_01_수

/*

    1. 좋은 단어 수 출력하기

    2. 1 <= n <= 100

    3. 짝 맞춰주는 방식으로 스택 활용해서 구현
    
       문제 이해하는게 오래 걸렸음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (!stack.isEmpty() && input.charAt(j) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }

            if (stack.size() == 0) {
                answer++;
            }

            stack.clear();
        }

        System.out.println(answer);
    }
}
