// 2020_09_23_수

/*
 *  1. 두 수로 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return하기
 *  
 *  2. 2 <= numbers.length <= 100
 *  
 *  3. 구현
 *  
 *     - list 에 indexOf() 값 만약 없으면 -1 리턴하는거 이용  
 *     
 */

package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PRO_WCCS1_두개뽑아서더하기 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = { 2, 1, 3, 4, 1 };

		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static int[] solution(int[] numbers) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int value = numbers[i] + numbers[j];
				if(list.indexOf(value) == -1) {
					list.add(value);
				}
			}
		}
		
		int[] answer = new int[list.size()];
		
		for(int i = 0; i <list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		Arrays.sort(answer);

		return answer;
	}

}
