// 2020_10_22_목

import java.util.Stack;

public class PRO_LV2_짝지어제거하기 {
    public static void main(String[] args) {
        String s = "baabaa";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.substring(i, i + 1));
            } else {
                String now = stack.peek();
                String target = s.substring(i, i + 1);
                if (now.equals(target)) {
                    stack.pop();
                } else {
                    stack.push(target);
                }
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }
}
