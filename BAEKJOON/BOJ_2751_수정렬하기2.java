// 2020_10_13_화

/*

    1. 입력값 정렬하기

    2. 1 ≤ n ≤ 1,000,000

    3. merge Sort로 구현해봄

    4. 시간초과 발생

       - mergSort() 에서 temp 배열 생성하지 않도록함

       - System.out.println() 안쓰고 BufferedWriter 써야함

 */

import java.io.*;

public class BOJ_2751_수정렬하기2 {

    static int[] inputArr, temp;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inputArr = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        divide(inputArr, 0, inputArr.length - 1);

        print(inputArr);
    }


    public static void divide(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            divide(arr, start, mid);
            divide(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }

    }

    public static void mergeSort(int[] arr, int start, int mid, int end) {
        int start1 = start;
        int start2 = mid + 1;
        int index = start;

        while (start1 <= mid && start2 <= end) {
            if (arr[start1] < arr[start2]) {
                temp[index] = arr[start1];
                start1++;
            } else {
                temp[index] = arr[start2];
                start2++;
            }

            index++;
        }

        if (start1 > mid) {
            for (int i = start2; i <= end; i++) {
                temp[index] = arr[i];
                index++;
            }
        } else {
            for (int i = start1; i <= mid; i++) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
    }

    public static void print(int[] arr) throws IOException {
        for (Integer n : arr) {
            bw.write(n + "\n");
        }
        bw.flush();
        bw.close();
    }

}
