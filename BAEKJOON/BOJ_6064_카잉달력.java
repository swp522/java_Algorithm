// 2020_09_21_월

/*
 *  1. <x, y> 가 몇번째 해인지 구하기
 *  
 *  2. 1 ≤ M, N ≤ 40,000 ,  1 ≤ x ≤ M,   1 ≤ y ≤ N
 *  
 *  3. 브루트 포스 
 *  
 *     1). 나머지 연산하려고 x, y 값 -1 해줌
 *  
 *     2). x부터 시작해서 m만큼씩 index 증가하면서 y값만 비교해준다 (x 고정)
 *  
 *     3). y값 맞으면 +1 해서 index 출력
 *     
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			boolean check = false;

			for (int j = x; j < (n * m); j += m) {
				if (j % n == y) {
					System.out.println(j + 1);
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println(-1);
			}
		}
	}

}
