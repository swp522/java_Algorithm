/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000 보다 작거나 같은 정수이다.
      수는 중복되지 않는다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 1시간 10분
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK2751_MergeSort {
    static int result[];

    public static void divide(int left, int right, int[] data){
        int mid;
        if(left<right){
            mid = (left+right)/2;
            divide(left, mid, data);
            divide(mid+1, right, data);
            merge(left, mid, right, data);
        }
    }

    public static void merge(int left, int mid, int right, int[] data){
        int firstLeft = left;
        int firstRight = mid+1;
        int firstInsert = left;

        while(firstLeft<=mid || firstRight<=right){
            if(firstLeft<=mid && firstRight<=right){
                if(data[firstLeft]<=data[firstRight]){
                    result[firstInsert] = data[firstLeft++];
                } else {
                    result[firstInsert] = data[firstRight++];
                }
            }
            else if(firstLeft <= mid){
                result[firstInsert] = data[firstLeft++];
            }
            else{
                result[firstInsert] = data[firstRight++];
            }
            firstInsert++;
        }
        for(int i=left; i<right+1; i++){
            data[i] = result[i];
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        result = new int[size];
        int[] data = new int[size];

        for(int i=0; i<size; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        divide(0, size-1, data);

        for(int i=0; i<size; i++){
            sb.append(result[i]+"\n");
        }
        System.out.println(sb);
    }
}