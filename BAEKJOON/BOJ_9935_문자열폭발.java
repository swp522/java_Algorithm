// 2020_05_11_월_숙제_35회차_문자열 폭발

/*
 * 1. 폭발 끝나고 남은 문자열 출력하기
 *
 * 2.  1 <= input.length() <= 1,000,000
 *
 * 3. 문자열, 구현, Stack 사용
 * 
 *    stack 쓸 때는 디버그 찍으면서 단계별로 생각해보기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();

        String answer = solve(input, bomb);

        if(answer.length() == 0){
            System.out.println("FRULA");
        } else{
            System.out.println(answer);
        }
    }


    public static String solve(String input, String bomb) {

        Stack<Character> stack = new Stack<>();

        int bombLength = bomb.length();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= bombLength) {
                boolean flag = false;
                for (int j = 0; j < bombLength; j++) {
                    if (stack.get(stack.size() - bombLength + j) != bomb.charAt(j)) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    for (int j = 0; j < bombLength; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : stack){
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
