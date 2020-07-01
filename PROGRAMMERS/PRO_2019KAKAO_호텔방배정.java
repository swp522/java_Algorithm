// 2020_07_01_수_문풀_호텔 방 배정

/*
 * 1. 고객에게 배정되는 방 번호를 순서대로 배열에 담아서 return 하기
 *
 * 2. 1 <= k(방 개수) <= 10^12 , 1 <= n(입력 배열 길이) <= 200,000  ,
 *
 * 3. 1). hashmap에 방번호 x 있는지 확인
 *
 *    2). x 없으면 answer[]에 넣어주고 hashmap에 해당 방번호를 index로 다음 방번호를 value로 put
 *
 *    3). x 있으면 list에 그 x 넣고, x의 hash값을 x로 갱신 계속 해주고, x가 빈방이면 while문 탈출하고 answer랑 list에 x 넣어줌
 *
 *    4). list에 있는 것들을 key, x + 1를 값으로 hashmap 갱신 (list에 마지막 값이 x인 상태)
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PRO_2019KAKAO_호텔방배정 {
    public static void main(String[] args) {
        long k = 10;
        long[] room_number = {1, 3, 4, 1, 3, 1};

        System.out.println(Arrays.toString(solution(k, room_number)));
    }

    public static long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        HashMap<Long, Long> hashmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long x = room_number[i];
            if (!hashmap.containsKey(x)) {
                answer[i] = x;
                hashmap.put(x, x + 1);
            } else {
                ArrayList<Long> list = new ArrayList<>();
                while (hashmap.containsKey(x)) {
                    list.add(x);
                    x = hashmap.get(x);
                }

                answer[i] = x;
                list.add(x);
                for (int j = 0; j < list.size(); j++) {
                    hashmap.put(list.get(j), x + 1);
                }
            }
        }

        return answer;
    }
}
