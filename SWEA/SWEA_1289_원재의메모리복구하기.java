// 2020_04_06_월_문풀_24회차_원재의 메모리 복구하기

import java.util.Scanner;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            char[] input = sc.next().toCharArray();
            char[] temp = new char[input.length];

            int count = 0;

            for (int i = 0; i < input.length; i++) {
                temp[i] = '0';
            }


            for (int i = 0; i < input.length; i++) {
                if (input[i] != temp[i]) {

                    char tmpNum = input[i];

                    for (int j = i; j < input.length; j++) {
                        temp[j] = tmpNum;
                    }
                    count++;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
