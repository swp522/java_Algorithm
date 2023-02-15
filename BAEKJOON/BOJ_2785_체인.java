import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2785_체인 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        Collections.sort(list);
        while(true){
            if(list.size() == 1){
                break;
            }

            list.set(0, list.get(0) - 1);
            list.set(list.size()-2, list.get(list.size()-2) + list.get(list.size()-1));
            list.remove(list.size()-1);

            answer++;

            if(list.get(0) == 0){
                list.remove(0);
            }
        }

        System.out.println(answer);
    }
}
