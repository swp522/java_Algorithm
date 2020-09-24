// 2020_09_21_월

/*
 *  1. 만들어지는 수의 자릿수 구하기
 *  
 *  2. 1 ≤ N ≤ 100,000,00
 *  
 *  3.  브루트 포스
 *  
 *     1). answer에 count(자리수) 계속 n번 더해줌
 *  
 *     2). 10의 제곱 수에 걸릴 때 limit * 10 해주고 자릿수 +1 해서 answer에 더함
 *  
 *     3). 1분넘어서 시초뜰 줄 알았는데 맞았음
 *     
 */

package algo;

import java.util.Scanner;

public class BOJ_1748_수이어쓰기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int limit = 10;
		int count = 1;
		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (i == limit) {
				limit *= 10;
				count++;
			}
			answer += count;
		}

		System.out.println(answer);
	}
}
