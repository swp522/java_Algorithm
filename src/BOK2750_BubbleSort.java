/*
문제 : N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력 : 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
      둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
      수는 중복되지 않는다.
출력 : 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

소요시간 : 30m
*/

import java.util.Scanner;

public class BOK2750_BubbleSort {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] data = new int[size];
        int temp;

        for (int i=0; i<data.length; i++){
            data[i] = scan.nextInt();
        }

        for (int j=data.length; j>0; j--){
            for(int k=0; k<j-1; k++){
                if(data[k] > data[k+1]){
                    temp = data[k];
                    data[k] = data[k+1];
                    data[k+1] = temp;
                }
            }
        }

        for(int num=0; num<data.length; num++){
            System.out.println(data[num]);
        }
        scan.close();
    }
}