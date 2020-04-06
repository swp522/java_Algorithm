// 2020_04_03_금_과제_23회차_안테나
// 1 3 5 9 9 9 9 인 경우 테케에서 누락된 듯

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18310_안테나 {

    static int n;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        houses = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(houses);

        if (n % 2 == 0) {
            System.out.println(houses[(n / 2)]);
        } else {
            System.out.println(houses[n / 2] + 1);
        }
    }
}
