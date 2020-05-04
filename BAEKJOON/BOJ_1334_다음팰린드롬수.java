// 2020_05_01_금_31회차_과제_다음 팰린드롬 수

/*
 * 1. n보다 큰 팰린드롬 수 중에서 가장 작은 것 출력
 *
 * 2. N <= 50, 첫 숫자는 0이 X
 *
 * 3. 구현
 *
 * 4. 미완성 >> left right 나눠서 left 기준으로 reverse 해서 문자열 다시 만든다음에 num보다 작은 경우 mid 숫자 ++ 하는 로직
 *
 *              인데 50자리라서 못하겠따
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_1334_다음팰린드롬수 {

    static int mid;
    static String left, right, changedNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        if (n.equals("9")) {
            System.out.println("11");
            return;
        }

        int len = n.length();
        if (len % 2 == 1) {
            mid = (len / 2) + 1;
            left = n.substring(0, mid - 1);
            right = n.substring(mid, len);
            changedNum = left + n.substring(mid - 1, mid) + reverseString(left);


            if (Integer.parseInt(changedNum) <= Integer.parseInt(n)) {
                int midNum = Integer.parseInt(n.substring(mid - 1, mid));
                while (Integer.parseInt(changedNum) <= Integer.parseInt(n)) {
                    midNum++;
                    changedNum = left + midNum + reverseString(left);
                }
                System.out.println(changedNum);
            } else {
                System.out.println(changedNum);
            }

        } else if (len % 2 == 0) {
            mid = (len / 2);
            left = n.substring(0, mid);
            right = n.substring(mid, len);
            changedNum = left + reverseString(left);

            if (Integer.parseInt(changedNum) <= Integer.parseInt(n)) {
                int midNum = Integer.parseInt(n.substring(mid - 1, mid));

                while (Integer.parseInt(changedNum) <= Integer.parseInt(n)) {
                    midNum++;
                    changedNum = n.substring(0, mid - 1) + midNum + midNum + reverseString(left).substring(1);
                }
                System.out.println(changedNum);
            } else {
                System.out.println(changedNum);
            }
        }


    }

    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }

    public static void changeBigNum(String num){
        BigInteger numBig = new BigInteger(num);
    }
}
