// 2020_11_26_목

/*

    1. 손가락을 움직이는 최소 회수 구하기

    2. N ≤ 500,000  /  2 ≤ P ≤ 300,000

    3. 구현하는 문제 같은데 로직이 생각이 나지 않아서 stack 쓰라는 힌트 참고함

      '새로 누를 flatNum' 이 가장 최근에 스택에 넣은거 보다 큰 경우 작은 경우 구분

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841_외계인의기타연주 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Stack<Integer>[] guitarLines = new Stack[7];
        for (int i = 0; i < 7; i++) {
            guitarLines[i] = new Stack<>();
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int lineNum = Integer.parseInt(st.nextToken()) - 1;
            int flatNum = Integer.parseInt(st.nextToken()) - 1;

            if (guitarLines[lineNum].isEmpty() || guitarLines[lineNum].peek() < flatNum) {
                if (!guitarLines[lineNum].isEmpty() && guitarLines[lineNum].peek() == flatNum) {
                    continue;
                }

                guitarLines[lineNum].push(flatNum);
                answer++;

                continue;
            }

            while (!guitarLines[lineNum].isEmpty() && guitarLines[lineNum].peek() > flatNum) {
                guitarLines[lineNum].pop();
                answer++;
            }

            if (!guitarLines[lineNum].isEmpty() && guitarLines[lineNum].peek() == flatNum) {
                continue;
            }

            guitarLines[lineNum].push(flatNum);
            answer++;
        }

        System.out.println(answer);
    }
}
