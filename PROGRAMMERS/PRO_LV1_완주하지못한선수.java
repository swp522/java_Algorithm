//2020_03_22_일_Programmers_LV1_완주하지 못한 선수
// Hash 문제

import java.util.*;

class Solution{
    public String solution(String[] participant, String[] completion){
        String answer = "";
        HashMap<String, Integer> hm  = new HashMap<>();
        
        for(String s : participant){
            if(!hm.containsKey(s)){
                hm.put(s, 0);  //index 숫자를 value 값으로 put
            }
            hm.put(s, hm.get(s) + 1);
        }
        
        for(String s : completion){
            hm.put(s, hm.get(s) - 1);
        }
        
        for(String s : hm.keySet()){
            if(hm.get(s) != 0){
                return s;
            }
        }
        return answer;
    }
}