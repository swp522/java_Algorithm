/*
1. 구현

2. O(n)

3. 다양한 방법이 있을 것 같음
 - 배열에 각각의 숫자의 개수를 세주고 max 값 출력(set수)
 - 6, 9 개수는 예외처리 : 반으로 나눠줌 (홀수면 + 1)
 - 소수좀 제거를 (int)Math.ceil((arr[6]+arr[9])/2.0) 로 표현해도 됨
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();
        int[] arr = new int[10];
        int index;
        int answer = 0;

        for (int i = 0; i < size; i++) {
            index = input.charAt(i) - '0';
            arr[index]++;
        }

        int temp = arr[6] + arr[9];
        if (temp % 2 == 0) {
            arr[6] = temp / 2;
            arr[9] = temp / 2;
        } else {
            arr[6] = temp / 2 + 1;
            arr[9] = temp / 2 + 1;
        }

        for(int i = 0; i < arr.length; i++){
            answer = Math.max(answer, arr[i]);
        }

        System.out.print(answer);
    }
}
