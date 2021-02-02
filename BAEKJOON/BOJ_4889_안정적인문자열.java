
// 2020_02_02_화

/*

    1. 안정적인 문자열 만드는데 필요한 연산 횟수(2종류임) 구하기

    2. 문자열 길이 < 2000

    3. 스택으로 짝 맞추기 구현

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4889_안정적인문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;

        while (true) {
            Stack<String> stack = new Stack<>();
            String[] inputArr = br.readLine().split("");
            if (inputArr[0].equals("-")) {
                break;
            }

            for (String s : inputArr) {
                if (stack.isEmpty()) {
                    stack.push(s);
                } else if (stack.peek().equals("{") && s.equals("}")) {
                    stack.pop();
                } else {
                    stack.push((s));
                }
            }

            int sum = 0;
            while (!stack.isEmpty()) {
                if (stack.pop().equals("{")) {
                    sum++;
                }

                if (stack.pop().equals("}")) {
                    sum++;
                }
            }

            System.out.println(num++ + ". " + sum);
        }
    }
}
