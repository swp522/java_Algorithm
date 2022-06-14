/*
1. 조각의 수 구하기
 - ( 는 push, ) 는 pop,
 - )전이 (이면 레이저 -> stack.size() 만큼 더하기
 - )전이 )이면 그냥 닫힘 -> answer + 1

2. 스택, 구현

3. O(n)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if(input.charAt(i) == ')'){
                stack.pop();

                if(input.charAt(i - 1) == '('){
                    answer += stack.size();
                } else{
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
