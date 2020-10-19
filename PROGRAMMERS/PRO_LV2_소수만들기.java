// 2020_10_20_화

/*

    1. 소수의 개수 구하기

    2. 범위 작음

    3. 1) 3중 포문 돌려서 3개 숫자 sum 구해서 다 구해보기 -> 시간 안터짐

       2) 소수 확인하는 메소드 따로 구현

       3) 조합으로 경우의수 구해도 된다

 */

public class PRO_LV2_소수만들기 {
    public static void main(String[] args){
        int[] nums ={1,2,7,6,4};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        boolean check = false;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum > 1){
                        check = checkIfSosu(sum);
                        if(check){
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static boolean checkIfSosu(int sum){
        boolean isSosu = true;
        if(sum == 2){
            return isSosu;
        }

        for(int i = 2; i < sum; i++){
            if(sum % i == 0){
                isSosu = false;
                break;
            }
        }

        return isSosu;
    }
}
