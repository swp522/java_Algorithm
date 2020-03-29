//2020_03_27_문풀_21회차_계산기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8338_계산기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCase; t++) {

            int n = Integer.parseInt(br.readLine());
            int num[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            int result = num[0];

            for (int i = 1; i < num.length; i++) {
                if (result + num[i] > result * num[i]) {
                    result += num[i];
                } else {
                    result *= num[i];
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
