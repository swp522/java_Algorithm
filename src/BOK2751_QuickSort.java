/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000 보다 작거나 같은 정수이다.
      수는 중복되지 않는다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 1시간 20분
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK2751_QuickSort {
    public static void quickSort(int[] data, int start, int end){
        if(start < end){
            int newPivot = partition(data, start, end);
            quickSort(data, start, newPivot-1);
            quickSort(data, newPivot+1, end);
        }
    }

    public static int partition(int[] data, int start, int end){
        int pivot = data[(start + end) / 2];

        while(start < end){
            while(data[start] < pivot)
                start++;
            while(data[end] > pivot)
                end--;
            if(start < end){
                swap(data, start, end);
            }
        }
        return start;
    }

    public static void swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine().trim());
        int data[] = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = Integer.parseInt(br.readLine().trim());
        }

        quickSort(data, 0, size-1);

        for(int i=0; i<size; i++){
            sb.append(data[i]+ "\n");
        }
        System.out.println(sb);
    }
}