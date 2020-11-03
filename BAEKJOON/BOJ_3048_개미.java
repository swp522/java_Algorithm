// 2020_11_03_화

/*

    1. t초가 지난 후 개미 순서 출력하기

    2. 0 ≤ T ≤ 50

    3. 구현 문제

       주어진 예제로 문제 이해하는게 조금 오래걸렸다

       1) 개미 배열, 방향 배열(오른쪽으로 전진 : 1, 왼쪽으로 전진 : -1) 사용

       2) 한 쌍(두 마리) 바꿔주고 i++ 처리

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3048_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        String s1 = br.readLine();
        String s2 = br.readLine();

        char[] ant1 = new char[n1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            ant1[s1.length() - 1 - i] = s1.charAt(i);
        }
        char[] ant2 = s2.toCharArray();
        char[] ants = new char[n1 + n2];
        int[] direction = new int[n1 + n2];

        for (int i = 0; i < n1; i++) {
            ants[i] = ant1[i];
            direction[i] = 1;
        }

        for (int i = n1; i < n1 + n2; i++) {
            ants[i] = ant2[i - n1];
            direction[i] = -1;
        }

        int time = Integer.parseInt(br.readLine());

        move(ants, direction, time);
    }


    public static void move(char[] ants, int[] direction, int time) {
        StringBuilder sb = new StringBuilder();

        while (time > 0) {
            time--;
            for (int i = 0; i < ants.length - 1; i++) {
                if (direction[i] == 1 && direction[i + 1] == -1) {
                    char temp1 = ants[i];
                    ants[i] = ants[i + 1];
                    ants[i + 1] = temp1;
                    int temp2 = direction[i];
                    direction[i] = direction[i + 1];
                    direction[i + 1] = temp2;
                    i++;
                }
            }
        }

        for (int i = 0; i < ants.length; i++) {
            sb.append(ants[i]);
        }

        System.out.println(sb.toString());
    }
}
