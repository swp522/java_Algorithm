// 2020_11_27_금

/*

    1. 30의 배수가 되는 가장 큰 수 출력하기 ( 없으면 -1 출력 )

    2. n의 길이 <= 100000

    3. 30의 배수 조건 구현

       1) 각 자리 값의 합이 3의로 나눠져야함

       2) 10의 배수이려면 0이 하나라도 있으면 된다

    4. 속도 개선해보기

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int[] numbers = new int[n.length()];
        int sum = 0;
        boolean isZero = false;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(n.charAt(i) + "");
            sum += numbers[i];
            if (numbers[i] == 0) {
                isZero = true;
            }
        }

        Arrays.sort(numbers);

        if (isZero && sum % 3 == 0) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                System.out.print(numbers[i]);
            }
        } else {
            System.out.print(-1);
        }
    }
}
