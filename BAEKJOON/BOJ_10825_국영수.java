// 2020_04_27_월_과제_29회차_국영수

/*
 * 1. n 명의 학생들 이름 출력
 *
 * 2. 1 ≤ N ≤ 100,000
 *
 * 3. 정렬, 구현
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_10825_국영수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][4];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                if (Integer.parseInt(a[1]) == Integer.parseInt(b[1])) {
                    if (Integer.parseInt(a[2]) == Integer.parseInt(b[2])) {
                        if (Integer.parseInt(a[3]) == Integer.parseInt(b[3])) {
                            return a[0].compareTo(b[0]);
                        }
                        return Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3]));
                    }
                    return Integer.compare(Integer.parseInt(a[2]), Integer.parseInt(b[2]));
                }
                return Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1]));
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0]);
        }
    }
}
