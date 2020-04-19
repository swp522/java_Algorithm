//2020_04_19_일_PROGRAMMERS_LV2_숫자야구

public class PRO_LV2_숫자야구 {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

        System.out.println(solution(baseball));
    }

    public static int solution(int[][] baseball) {
        int answer = 0;
        boolean check = true;

        for (int i = 123; i <= 987; i++) {
            String baseNum = Integer.toString(i);
            if (baseNum.charAt(0) != baseNum.charAt(1) && baseNum.charAt(0) != baseNum.charAt(2) && baseNum.charAt(1) != baseNum.charAt(2) &&
                    baseNum.charAt(0) != '0' && baseNum.charAt(1) != '0' && baseNum.charAt(2) != '0') {

                check = true;

                for (int j = 0; j < baseball.length; j++) {
                    int strike = 0;
                    int ball = 0;

                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            String targetNum = Integer.toString(baseball[j][0]);

                            if (a == b && baseNum.charAt(a) == targetNum.charAt(b)) {
                                strike++;
                                continue;
                            } else if (a != b && baseNum.charAt(a) == targetNum.charAt(b)) {
                                ball++;
                                continue;
                            }
                        }
                    }

                    if (strike != baseball[j][1] || ball != baseball[j][2]) {
                        check = false;
                        break;
                    }
                }

                if (check == true) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
