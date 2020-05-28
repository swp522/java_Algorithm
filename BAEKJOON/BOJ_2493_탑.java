// 2020_05_29_금_36회차_과제_탑

/*
 * 1. 각 index 탑에서 발사한 레이저를 '수신하는 탑의 index' 순서대로 출력하기
 *
 * 2. 1 <= N <= 500000, 1 <= N <= 100000000
 *
 * 3. 스택 사용하고 sb로 출력하기
 *
 *    long 사용해서 메모리 초과 방지
 *
 * 4. 속도 효율성 생각해보기
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

    static class Building {
        int index;
        long height;

        Building(int index, long height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Building> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            long targetHeight = Long.parseLong(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek().height >= targetHeight) {
                    sb.append(stack.peek().index + " ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }

            stack.push(new Building(i, targetHeight));
        }

        System.out.println(sb.toString());
    }
}
