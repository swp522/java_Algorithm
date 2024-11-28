/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000 보다 작거나 같은 정수이다.
      수는 중복되지 않는다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 3시간
*/

import java.io.*;
import java.util.StringTokenizer;

public class BOK2751_HeapSort {
    static StringTokenizer st;
    static int[] heapSort;

    public static void buildMaxHeap() {
        if (heapSort == null || heapSort.length < 1) {
            return;
        }

        for (int i = heapSort.length / 2; i >= 0; i--) {
            heapify(heapSort, i, heapSort.length);
        }

        for (int i = heapSort.length - 1; i >= 0; i--) {
            swap(0, i);
            heapify(heapSort, 0, i);
        }
    }

    public static void heapify(int[] unSorted, int index, int heapSize) {
        int maxIndex = index;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < heapSize && unSorted[leftIndex] > unSorted[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex < heapSize && unSorted[rightIndex] > unSorted[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != index) {
            swap(maxIndex, index);
            heapify(heapSort, maxIndex, heapSize);
        }
    }

    public static void swap(int maxIndex, int index) {
        int temp = heapSort[maxIndex];
        heapSort[maxIndex] = heapSort[index];
        heapSort[index] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        heapSort = new int[size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            heapSort[i] = input;
        }

        buildMaxHeap();

        for (int output : heapSort) {
            bw.write(String.valueOf(output));
            bw.newLine();
        }
        bw.close();
    }
}