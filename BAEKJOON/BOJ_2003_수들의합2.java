// 2020_09_22_화

/*
 *  1. i~j 수까지 합이 m이 되는 경우의 수 구하기
 *  
 *  2. 1≤N≤10,000   ,   1≤M≤300,000,000    ,   input[i] < 30,000 자연수
 *  
 *  3. 투포인터
 *  
 *     1). sum이 m보다 작으면 first 포인터 전진하고 sum에서 + 해준다
 *  
 *     2). sum이 m보다 크거나 같으면 second 포인터 전진하고 sum에서 - 해준다
 *  
 *     3). sum이 m이랑 같으면 경우의수 카운트해준다 
 *     
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args_) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] input = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int first = 0;
		int second = 0;
		int answer = 0;
		
		while(true) {
			if(sum >= m) {
				sum -= input[second++];
			} else if(first == n) {
				break;
			} else {
				sum += input[first++];
			}
			
			if(sum == m) {
				answer++;
			}
		}

		System.out.println(answer);
	}

}
