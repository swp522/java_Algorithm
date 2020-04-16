//2020_04_16_목_PROGRAMMERS_LV2_다음 큰 숫자

public class PRO_LV2_다음큰숫자 {
    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    // bitCount() 로 이진수에 있는 1 개수 count
    public static int solution1(int n) {
        int bitValue = Integer.bitCount(n);
        int answer = n;

        while (true) {
            answer++;

            if (bitValue == Integer.bitCount(answer)) {
                break;
            }
        }
        return answer;
    }

    //toBinaryString()으로 이진수 변환
    public static int solution2(int n) {
        int answer = 0;
        int max = 1000000;  // 0 < n <= 1000000
        String binary = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }

        for (int i = n + 1; i <= max; i++) {
            String temp = Integer.toBinaryString(i);
            int tempCount = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    tempCount++;
                }
            }
            if (count == tempCount) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
