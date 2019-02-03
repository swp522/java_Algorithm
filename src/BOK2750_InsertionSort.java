/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
      수는 중복되지 않는다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 10m
*/

import java.util.Scanner;

public class BOK2750_InsertionSort {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] data = new int[size];

        for(int i=0; i<data.length; i++){
            data[i] = scan.nextInt();
        }

        for(int i=1; i<data.length; i++){
            int key = data[i];
            int j = i-1;
            while(j > 0 && data[j] > key){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = key;
        }

        for(int i=0; i<data.length; i++){
            System.out.println(data[i]);
        }
        scan.close();
    }
}