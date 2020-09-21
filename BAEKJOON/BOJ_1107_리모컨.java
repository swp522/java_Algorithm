// 2020_09_18_금

/*
 *  1. 채널 N 으로 이동하려면 버튼 몇번 눌러야하는지 구하기
 *  
 *  2. 0 ≤ N ≤ 500,000 , 0 ≤ M ≤ 10  , 시작 채널 100번
 *  
 *  3. 브루트 포스
 *  
 *     1). answer 초기 값 : 숫자버튼 안누르고  +/-만 누르는 경우로 초기화
 *  
 *     2). 처음에 어떤 숫자로 이동할지 결정 -> 10으로 나눠서 1의자리부터 broken인지 check한다 (첫 채널이 0인 경우 따로 고려)
 *  
 *     3). check 결과가 return length 되면 최소 값 비교한다
 *     
 *  4. 입력받을 때 Scanner로 받으면 문제없는데 BufferedReader로 받으면 m != 0 처리 해줘야 맞는다
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨 {
	
	static boolean[] broken = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int targetNumber = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int x = Integer.parseInt(st.nextToken());
				broken[x] = true;
			}
		}

		int answer = targetNumber - 100;
		if (answer < 0) {
			answer = -answer;
		}

		for(int i = 0; i <= 1000000; i++) {
			int firstChannel = i;
			int length = checkIfTheButtonIsBroken(firstChannel);
			if(length > 0) {
				int pressCount = firstChannel - targetNumber;
				if(pressCount < 0) {
					pressCount = -pressCount;
				}
				
				if(answer > length + pressCount) {
					answer = length + pressCount;
				}
			}
		}
		
		System.out.println(answer);
	}

	public static int checkIfTheButtonIsBroken(int channel) {
		if (channel == 0) {
			if (broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}

		int len = 0;
		while (channel > 0) {
			if (broken[channel % 10]) {
				return 0;
			}

			len += 1;
			channel /= 10;
		}

		return len;
	}

}
