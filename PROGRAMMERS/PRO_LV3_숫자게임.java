// 2021_04_12_월

/*

    1. B팀이 얻는 최대 승점

    2. 1 <= A B 길이 <= 100,000   /   1 <= A B 값 <= 1,000,000,000

    3. 1) 처음에 A 배열은 고정으로 두는 거라고 생각했음

       2) 정렬하고 뒤에서부터 비교하는데 B값이 A보다 크면 answer++하고 B의 index--

       3) 안크면 B의 값을 비교에 쓸 필요가 없으니까 continue 처리
       
       4) for 문 두번쓰면 O(N^2)로 시간초과

 */

import java.util.Arrays;

public class PRO_LV3_숫자게임 {
    public static void main(String[] args) {
        int[] A = {5, 1, 3, 7};
        int[] B = {2, 2, 6, 8};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int index = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[index]) {
                answer++;
                index--;
            } else{
                continue;
            }
        }

        return answer;
    }

  public static int solution2(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        int b = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = b; j < B.length; j++){
                if(A[i] < B[j]){
                    answer++;
                    b = j + 1;
                    break;
                }
            }
        }

        return answer;
    }
}
