// 2024.07.03(수) 프로그래머스 LV1 모의고사

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PRO_LV1_모의고사 {
    public static void main(String[] args){
        int[] answers = {1,2,3,4,5};

        System.out.println(solution1(answers));
    }

    // 배열로 카운트 방법 1
    public static List<Integer> solution1(int[] answers) {
        int[] ex1 = { 1, 2, 3, 4, 5};
        int[] ex2 = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] ex3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];

        for(int i = 0 ; i < answers.length; i++){
            if(answers[i] == ex1[i%5]){
                answer[0]++;
            }
            if(answers[i] == ex2[i%8]){
                answer[1]++;
            }
            if(answers[i] == ex3[i%10]){
                answer[2]++;
            }
        }

        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));

        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(max == answer[i]){
                answerList.add(i + 1);
            }
        }
        return answerList;
    }

    // ArrayList 로 카운트 방법 2
    public static int[] solution2(int[] answers) {
        int[] ex1 = { 1, 2, 3, 4, 5};
        int[] ex2 = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] ex3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<3; i++) list.add(0);

        for(int i=0; i<answers.length; i++){
            if(answers[i] == ex1[i%5]) list.set(0, list.get(0)+1);
            if(answers[i] == ex2[i%8]) list.set(1, list.get(1)+1);
            if(answers[i] == ex3[i%10]) list.set(2, list.get(2)+1);
        }

        int max = Collections.max(list);

        List<Integer> returnList = new ArrayList<Integer>();
        for(int i=0; i<3; i++)
            if(max == list.get(i)) returnList.add(i+1);

        int[] answer = new int[returnList.size()];
        for(int i=0; i<returnList.size(); i++)
            answer[i] = returnList.get(i);

        return answer;
    }
}
