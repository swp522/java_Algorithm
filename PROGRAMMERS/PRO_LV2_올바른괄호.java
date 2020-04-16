//2020_04_16_목_PROGRAMMERS_LV2_올바른 괄호

import java.util.Stack;

public class PRO_LV2_올바른괄호 {
    public static void main(String[] args) {
        String s = "(()(";

        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (target == '(') {
                stack.push(target);
            } else if (target == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
