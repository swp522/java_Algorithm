// 2020_11_06_금

/*

    1. 주어진 조건에서 한 명의 아들에게 줄 수 있는 가장 많은 과자 수 return

    2. 1 <= cookie 길이 <= 2000  /  1 <= 쿠기 값 <= 500

    3. 왼쪽, 오른쪽 index를 잡고 경우에 따라 각 방향으로 이동하면서 sum 해주고 max 갱신

 */

public class PRO_LV4_쿠키구입 {
    public static void main(String[] args) {
        int[] cookie = {1, 1, 2, 3};

        System.out.println(solution(cookie));
    }


    public static int solution(int[] cookie) {
        int answer = 0;
        int len = cookie.length;

        for (int i = 0; i < len - 1; i++) {
            int leftIndex = i;
            int rightIndex = i + 1;
            int leftSum = cookie[leftIndex];
            int rightSum = cookie[rightIndex];

            while (true) {
                if (leftSum == rightSum) {
                    answer = Math.max(answer, leftSum);
                }

                if (leftSum <= rightSum && 0 < leftIndex) {
                    leftIndex--;
                    leftSum += cookie[leftIndex];
                } else if (leftSum > rightSum && rightIndex < len - 1) {
                    rightIndex++;
                    rightSum += cookie[rightIndex];
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
