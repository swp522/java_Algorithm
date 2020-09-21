// 2020_09_18_금

/*
 *  1. 지금 몇 년 인지 구하기
 *  
 *  2. 1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
 *  
 *  3. 1). 문제 이해하는데 시간 걸림
 *  
 *     2). 총 15*28*19 경우의수 있는데 그냥 조건식 생략해서 무한루프로 둠
 *     
 *     3). 나머지 연산으로도 풀 수 있음  VVV
 */

package algo;

import java.util.Scanner;

public class BOJ_1476_날짜계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		int eYear = 1, sYear = 1, mYear = 1;

		for (int i = 1; ; i++) {
			
			if(eYear == E && sYear == S && mYear == M) {
				System.out.println(i);
				break;
			}

			eYear += 1;
			sYear += 1;
			mYear += 1;
			
			if(eYear == 16) {
				eYear = 1;
			}
			if(sYear == 29) {
				sYear = 1;
			}
			if(mYear == 20) {
				mYear = 1;
			}
		}

	}

}
