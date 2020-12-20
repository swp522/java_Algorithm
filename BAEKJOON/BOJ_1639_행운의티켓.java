// 2020_12_20_일
// version 1.0

/*

    1. 조건 만족하는 가장 긴 문자열 길이 구하기

    2. 정답 길이는 2의 배수 / 문자열 길이 <= 100

    3. 포인터 변수 두개로 구간 설정하고 더해서 비교하는 로직구현이 좀 오래걸렸음

       1) 처음에 주어진 입력값 홀수일 경우 end 값 조정

       2) 첫번째 while 문은 비교하는 문자열 길이를 조건으로 함

       3) 두번쨰 while 문은 고정된 문자열 길이 구간을 두개의 포인터를 한칸식 이동하는 부분

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1639_행운의티켓 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int[] inputArr = new int[len];
        for (int i = 0; i < len; i++) {
            inputArr[i] = input.charAt(i) - '0';
        }

        int end;
        if (len % 2 != 0) {
            end = len - 1;
        } else {
            end = len;
        }
        end += 2;

        move(end, len, inputArr);
    }

    public static void move(int end, int len, int[] inputArr) {
        int start, mid;
        int startPointer, endPointer;
        int leftSum, rightSum;
        while (end > 2) {
            start = 0;
            end -= 2;
            startPointer = start;
            endPointer = end;

            while (endPointer <= len) {
                mid = (startPointer + endPointer) / 2;
                leftSum = 0;
                rightSum = 0;

                for (int i = startPointer; i < mid; i++) {
                    leftSum += inputArr[i];
                }

                for (int i = mid; i < endPointer; i++) {
                    rightSum += inputArr[i];
                }

                if (leftSum == rightSum) {
                    System.out.println(end);
                    return;
                }

                startPointer++;
                endPointer++;
            }
        }

        System.out.print(0);
    }
}
