// 2020_09_19_토

/*
 *  1. 테르노미노를 하나 맵에 놓았을 때 최대값 구하기
 *  
 *  2. 4 ≤ N, M ≤ 500
 *  
 *  3. 브루트 포스 
 *  
 *     1). 어떤 테트로미노 놓을 건지 / 어디에 놓을 건지 결정
 *  
 *     2). 테르노미노는 회전,대칭 가능 -> 총 19가지 가능
 *  
 *     3). 19 x n x m 가지  -> 약 4750000 가지
 *  
 *  4. 빡구현 하면 백트래킹 보다 시간 절반정도 걸림
 *  
 */

package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테르노미노 {

	static int row, col, answer;
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		answer = 0;
		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (j + 3 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 3 < row) {
					int target = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
					if (answer < target) {
						answer = target;
					}
				}

				if (i + 1 < row && j + 2 < col) {
					int target = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 2 < row && j + 1 < col) {
					int target = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i][j + 1];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 1 < row && j + 2 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 2 < row && j - 1 >= 0) {
					int target = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j - 1];
					if (answer < target) {
						answer = target;
					}
				}
				if (i - 1 >= 0 && j + 2 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 2];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 2 < row && j + 1 < col) {
					int target = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 1 < row && j + 2 < col) {
					int target = map[i][j] + map[i + 1][j] + map[i][j + 1] + map[i][j + 2];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 2 < row && j + 1 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
					if (answer < target) {
						answer = target;
					}
				}

				if (i + 1 < row && j + 1 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
					if (answer < target) {
						answer = target;
					}
				}

				if (i + 2 < row && j + 1 < col) {
					int target = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
					if (answer < target) {
						answer = target;
					}
				}
				if (i - 1 >= 0 && j + 2 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 1][j + 2];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 2 < row && j - 1 >= 0) {
					int target = map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j - 1];
					if (answer < target) {
						answer = target;
					}
				}
				if (i + 1 < row && j + 2 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
					if (answer < target) {
						answer = target;
					}
				}

				if (j + 2 < col) {
					int target = map[i][j] + map[i][j + 1] + map[i][j + 2];
					if (i - 1 >= 0) {
						int target2 = target + map[i - 1][j + 1];
						if (answer < target2) {
							answer = target2;
						}
					}
					if (i + 1 < row) {
						int target2 = target + map[i + 1][j + 1];
						if (answer < target2) {
							answer = target2;
						}
					}
				}
				if (i + 2 < row) {
					int target = map[i][j] + map[i + 1][j] + map[i + 2][j];
					if (j - 1 >= 0) {
						int target2 = target + map[i + 1][j - 1];
						if (answer < target2) {
							answer = target2;
						}
					}
					if (j + 1 < col) {
						int target2 = target + map[i + 1][j + 1];
						if (answer < target2) {
							answer = target2;
						}
					}
				}
			}
		}

		System.out.println(answer);
	}
}
