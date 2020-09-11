// 2020_09_03_수_restart

/*
 * 1. 받을 수 있는 가장 큰 상금 구하기
 *
 * 2. 3 <= expression.length <= 100 , 0 <= 피연산자 길이 <= 999
 *
 * 3. 1). 정수, 연산자 입력값 받아서 리스트에 저장하기
 *
 *    2). dfs 돌릴 때 연산자 3개로 6가지 경우의 수 고려해야함 -> order[] 에 우선순위 들어감
 *
 *    3). count가 3이면 order 다 채워졌으니까 계산 시작함
 *
 *    4). copyOperations 리스트에 순서대로 order[i] 와 비교해서 일치하면 해당 연산자의 순서이니까 calculate 진행
 *
 *    5). calculate 메소드 결과 return 하고 answer의 max 값 갱신
 *
 *    6). remove(j) 두번해주고 j--도 해줘야했음
 *
 */

import java.util.ArrayList;

public class PRO_LV2_수식최대화 {

    static ArrayList<Long> inputNumbers;
    static ArrayList<Character> InputOperations;
    static long answer;
    static char[] priority = {'+', '-', '*'};
    static boolean[] visited = new boolean[3];

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        //String expression = " ";

        System.out.println(solution(expression));
    }


    public static long solution(String expression) {
        inputNumbers = new ArrayList<>();
        InputOperations = new ArrayList<>();
        answer = 0;

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                inputNumbers.add(Long.parseLong(num));
                num = "";
                InputOperations.add(expression.charAt(i));
            }
        }
        inputNumbers.add(Long.parseLong(num));

        dfs(0, new char[3]);

        return answer;
    }


    public static void dfs(int count, char[] orders) {
        if (count == 3) {
            ArrayList<Long> copyNumbers = new ArrayList<>(inputNumbers);
            ArrayList<Character> copyOperations = new ArrayList<>(InputOperations);

            for (int i = 0; i < orders.length; i++) {
                for (int j = 0; j < copyOperations.size(); j++) {
                    if (copyOperations.get(j) == orders[i]) {
                        Long calculatedResult = calculate(copyNumbers.remove(j), copyNumbers.remove(j), orders[i]);
                        copyNumbers.add(j, calculatedResult);
                        copyOperations.remove(j);
                        j--;
                    }
                }
            }

            answer = Math.max(answer, Math.abs(copyNumbers.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orders[count] = priority[i];
                dfs(count + 1, orders);
                visited[i] = false;
            }
        }

    }


    public static Long calculate(Long a, Long b, char oper) {
        long value = 0;
        switch (oper) {
            case '+': {
                return a + b;
            }
            case '-': {
                return a - b;
            }
            case '*': {
                return a * b;
            }
        }
        return value;
    }

}
