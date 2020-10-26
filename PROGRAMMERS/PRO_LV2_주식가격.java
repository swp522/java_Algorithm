// 2020_10_26_월

/*

    1. 각 인덱스마다 가격이 떨어지지 않는 구간의 길이(?) 구하기 ( 문제 이해가 어려웠음 )

    2. 1 <= prices 가격 <= 10,000    /    2 <= prices.length <= 100,000

    3. 스택/큐 문제인데 그냥 완전 탐색으로 구현함

 */

public class PRO_LV2_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(solution1(prices));
    }

    public static int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int count = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[i] <= prices[j]){
                    count++;
                } else {
                    count++;
                    break;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
}
