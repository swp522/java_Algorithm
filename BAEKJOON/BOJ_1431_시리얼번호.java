// 2021_02_03_수

/*

    1. 시리얼 번호 정렬 후 출력하기

    2. n <= 1000, 시리얼 번호는 최대 50

    3. Comparator 로 정렬 구현

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1431_시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if (a.length() < b.length()) {
                    return -1;
                } else if (a.length() > b.length()) {
                    return 1;
                } else {
                    int sum1 = 0;
                    for (int i = 0; i < a.length(); i++) {
                        char result = a.substring(i, i + 1).charAt(0);
                        if ((int) result > 47 && (int) result < 58) {
                            sum1 += Integer.parseInt(Character.toString(result));
                        }
                    }

                    int sum2 = 0;
                    for (int j = 0; j < b.length(); j++) {
                        char result = b.substring(j, j + 1).charAt(0);
                        // 48(0) ~ 57(9)
                        if ((int) result > 47 && (int) result < 58) {
                            sum2 += Integer.parseInt(Character.toString(result));
                        }
                    }

                    if (sum1 > sum2) {
                        return 1;
                    } else if (sum1 < sum2) {
                        return -1;
                    } else {
                        return a.compareTo(b);
                    }
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
