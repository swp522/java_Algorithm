// 2020_09_21_월

/*
 *  1. 훔칠 수 있는 돈의 최대값 구하기
 *  
 *  2. 3 <= 집 개수  <= 1,000,000  0 <= money[i] <= 1000
 *  
 *  3. DP
 *  
 *     1). 시작을 '첫번째 집 터는거'와 '두번쨰 집 터는거' 비교
 *  
 *     2). firstHouseDP는 첫번째 집을 못터니까 firstHouseDP[1] = money[0] 으로 초기화
 *  
 *     3). firstHouseDP는 첫번쨰 집 털었으니까 마지막 집 못터니까 return 할때 -1 해줘야함
 *     
 */

package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRO_LV4_도둑질 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] money = { 1, 2, 3, 1 };

		System.out.println(solution(money));
	}

	public static int solution(int[] money) {
		int answer = 0;
		int[] firstHouseDP = new int[money.length];
		int[] secondHouseDP = new int[money.length];

		firstHouseDP[0] = money[0];
		firstHouseDP[1] = money[0];
		secondHouseDP[1] = money[1];

		for (int i = 2; i < money.length; i++) {
			firstHouseDP[i] = Math.max(firstHouseDP[i - 1], firstHouseDP[i - 2] + money[i]);
			secondHouseDP[i] = Math.max(secondHouseDP[i - 1], secondHouseDP[i - 2] + money[i]);
		}
		
		answer = Math.max(firstHouseDP[money.length - 2], secondHouseDP[money.length - 1]);

		return answer;
	}
}
