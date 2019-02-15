/*
문제 : 자연수 M과 N이 주어질 때 M 이상 N 이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

걸린 시간 : 20분
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BOK2581 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int min = scan.nextInt();
        int max = scan.nextInt();
        int check=0;
        int sum=0;

        ArrayList decimal = new ArrayList();

        for(int i=min; i<=max; i++){
            if(i==1){
                check=1;
            }
            for(int j=2; j<i; j++){
                if(i%j==0){
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                decimal.add(i);
                sum += i;
            }
            check = 0;
        }
        if(decimal.size() == 0){
            System.out.println("-1");
        }
        else{
            System.out.println(sum);
            System.out.println(decimal.get(0));
        }


    }
}
