//2020_03_23_월_Programmers_LV2_프린터

import java.util.LinkedList;
import java.util.Queue;

class Print{
    int priority;
    int index;

    Print(int priority, int index){
        this.priority = priority;
        this.index = index;
    }
}


public class PRO_LV2_프린터 {

    static Queue<Print> q;

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));
    }


    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int[] result = new int[priorities.length];
        q = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++){
            Print print = new Print(priorities[i], i);
            q.offer(print);
        }

        int j = 0;
        while(!q.isEmpty()){
            Print print = q.poll();
            int priority = print.priority;

            //우선순위 더 큰거 있으면 다시 큐의 뒤에 넣어줌
            if(check(priority)){
                q.offer(print);
            }
            //우선순위 더 큰거 없으면 result 배열에 넣어줌
            else{
                result[j] = print.index;
                j++;
            }
        }

        for(int i = 0; i<result.length; i++){
            if(result[i] == location){  //result[i]는 처음 print의 index 의미함
                answer = i + 1;
                break;
            }
        }
        return answer;
    }


    public static boolean check(int number) {
        boolean checking = false;

        Print[] list = q.toArray(new Print[q.size()]);

        for (int i = 0; i < list.length; i++) {
            if (list[i].priority > number) {
                checking = true;
                break;
            }
        }
        return checking;
    }
}
