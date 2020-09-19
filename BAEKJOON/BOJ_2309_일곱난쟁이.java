// 2020_09_17_목

/*
 *  1. 일곱 난쟁이 키 오름차순 출력
 *  
 *  2. 난쟁이 키의 합이 100
 *  
 *  3. 1). 9명 중에서 2명 뽑는건데 브루트 포스로 다 구해보는 문제였음
 *  
 *     2). 100 일 경우 루프문 탈출해줘야함 -> break 걸어주는걸 생각못해서 틀렸음. 가능한 정답 모두 구하게 되어버려서 시간 오래걸림
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] men = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			men[i] = Integer.parseInt(br.readLine());
			sum += men[i];
		}
	
		Arrays.sort(men);

		loop:
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - men[i] - men[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (i != k && j != k) {
							System.out.println(men[k]);
						}
					}
					
					break loop;
				}
			}
		}

	}
}
