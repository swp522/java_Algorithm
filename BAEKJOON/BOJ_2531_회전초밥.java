// 2020_10_18_일

/*
 *  1. 초밥을 먹을 수 있는 개수의 최대값 구하기
 *  
 *  2. 2 ≤ N ≤ 30,000  /  2 ≤ d ≤ 3,000   / 2 ≤ k ≤ 3,000 (k ≤ N)  / 1 ≤ c ≤ d
 *  
 *  3. count = 1 로 두고 c를 우선 포함하게 한다음 k개만큼 확인하도록 구현 
 *  
 *  4. 문제를 이해하는데 너무 오래걸렸다
 *  
 *     d가 왜 필요한지 이해하는데 오래걸림 -> 쿠폰 c가 현재 없으면 새로운 종류의 초밥이 올라가는데 이것 때문인듯
 *     
 *     불필요한 배열의 공간 없애야하고 투포인터 방법 생각해보기
 * 
 */


package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] input = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		};
	
		System.out.println(solution(n, d, k, c, input));
	}

	public static int solution(int n, int d, int k, int c, int[] input) {
		int answer = Integer.MIN_VALUE;
		boolean[] check = new boolean[d + 1];
		
		for(int i = 0; i < n; i++) {
			int count = 1;
			Arrays.fill(check, false);
			for(int j = i; j < (i + k); j++) {
				if(!check[input[j % n]]) {
					check[input[j % n]] = true;
					count++;
					if(input[j % n] == c) {
						count--;
					}
				}
			}
			
			if(count == k + 1) {
				answer = count;
				break;
			}
			answer = Math.max(answer, count);
		}
		
		return answer;
	}
}
