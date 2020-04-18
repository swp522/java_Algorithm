//2020_04_19_일_PROGRAMMERS_KAKAO_2018_n진수 게임

public class PRO_2018KAKAO_3차_n진수게임 {
    public static void main(String[] args) {
        int n = 16, t = 16, m = 2, p = 1;

        String s = "";
        String answer = "";

        for (int i = 0; i < t * m; i++) {
            s += nConvert(i, n);
        }

        int countNum = p - 1;

        for (int i = 0; i < t; i++) {
            answer += s.charAt(countNum);
            countNum += m;
        }

        System.out.println(answer);
    }


    private static String nConvert(int num, int n) {
        char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        String value = "";

        while (num / n != 0) {
            int a = num % n;
            value = c[a] + value;
            num = num / n;
        }
        value = c[num % n] + value;

        return value;
    }
}
