// 2020_11_07_토

/*

    1. 식의 값을 최소로 만들기

    2. 가장 처음과 마지막은 숫자  /  두 개 이상의 연산자 X  /  연속 숫자는 5자리까지

    3. 구현문제 였는데 로직 생각이 떠오르는데 좀 오래걸림

       Split 하는거보다 StringTokenizer가 빠른거 같음

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            int num = 0;
            String[] arr = input[i].split("\\+");

            for (int j = 0; j < arr.length; j++) {
                num += Integer.parseInt(arr[j]);
            }

            if(answer == Integer.MAX_VALUE){
                answer = num;
            } else {
                answer -= num;
            }
        }

        System.out.println(answer);
    }
}
