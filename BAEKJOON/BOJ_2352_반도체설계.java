// 2020_02_05_금

/*

    1. n개 포트와 다른 n개 포트가 안겹치고 연결되는 최대 개수

    2. 1 ≤ n ≤ 40,000

    3. Lis 로만 하면 시간 초과 나와서 binary search 개념 필요함

       (참고 했음)

    4. lower bound 구현만으로 풀 수도 있는 듯

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352_반도체설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisArr = new int[n];
        lisArr[0] = arr[0];
        int index = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            if (lisArr[index - 1] < arr[i]) {
                lisArr[index++] = arr[i];
            } else if (lisArr[0] > arr[i]) {
                lisArr[0] = arr[i];
            } else {
                temp = Arrays.binarySearch(lisArr, 0, index, arr[i]);
                lisArr[temp < 0 ? (-temp - 1) : temp] = arr[i];
            }
        }

        System.out.println(index);
    }
}
