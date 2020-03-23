//2020_03_23_월_Programmers_LV1_문자열을 정수로 바꾸기

public class PRO_LV1_문자열을정수로바꾸기 {
    public static void main(String[] args) {
        String s = "-123";

//        solution(s);
        System.out.println(solution(s));
    }


    public static int solution(String s) {
        int answer = 0;

        if (s.substring(0, 1).equals("-")) {
            answer = -Integer.parseInt(s.substring(1, s.length()));
        } else if (s.substring(0, 1).equals("+")) {
            answer = Integer.parseInt(s.substring(1, s.length()));
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
