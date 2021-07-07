/*
문제 : M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
입력 : 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000)
출력 : 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

걸린 시간 : 45분
새로 알게 된 점 : 에라토스테네스의 체(최적의 소수 구하기 알고리즘 도구)
 */

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class BOK1929 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int min = scan.nextInt();
        int max = scan.nextInt();
        int check = 0;

        ArrayList decimal = new ArrayList();

        for(int i=min; i<=max; i++){
            if(i==1){
                check=1;
            }

            for(int j=2; j<=sqrt(i); j++){
                if(i%j==0){
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                decimal.add(i);
            }
            check = 0;
        }

        for (int i = 0; i < decimal.size(); i++) {
            System.out.println(decimal.get(i));
        }
    }
}