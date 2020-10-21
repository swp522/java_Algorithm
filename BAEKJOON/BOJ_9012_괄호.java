// 2002_10_21_수

/*

    1. VPS 인지 아닌지 구하기

    2. 2 <= 괄호 문자열 길이 <= 50

    3. 1) Stack 구현

       2) 이 문제는 스택 안쓰고 그냥 count 변수 써서 풀어도 된다

          count 체크 두번으로 필터링

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            String input = br.readLine();

            solve1(n, input);
            solve2(n, input);
        }
    }


    public static void solve1(int n, String input) throws IOException {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i, i + 1).equals("(")) {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                break;
            }
        }

        if (count != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }


    public static void solve2(int n, String input) throws IOException {
        Boolean isPossible = true;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i, i + 1).equals("(")) {
                stack.push("(");
            } else if (input.substring(i, i + 1).equals(")")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    isPossible = false;
                }
            }
        }

        if (stack.isEmpty() && isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}
