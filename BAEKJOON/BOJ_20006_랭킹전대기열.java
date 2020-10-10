// 2020_10_09_목

/*
    1. 비슷한 레벨의 플레이어들 배치해줌. 방의 상태와 입장 플레이어들 출력하기

    2. 1 ≤ p, m ≤ 300  /  1 ≤ l ≤ 500  /  알파벳 소문자  /  닉네임 길이 < 16

    3. 구현

       1 2 3 문제 조건 이해하는데 좀 오래걸림
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20006_랭킹전대기열 {

    static class Player {
        int l;
        String n;

        public Player(int l, String n) {
            this.l = l;
            this.n = n;
        }
    }

    static int p, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Player>[] list = new ArrayList[p];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();

            for (int j = 0; j < list.length; j++) {
                if (list[j].size() != m) {
                    if (list[j].size() == 0) {
                        list[j].add(new Player(l, n));
                        break;
                    } else {
                        if (((list[j].get(0).l - l) >= -10) && ((list[j].get(0).l - l) <= 10)) {
                            list[j].add(new Player(l, n));
                            break;
                        }
                    }
                }
            }
        }

        for (int roomNum = 0; roomNum < list.length; roomNum++) {
            Collections.sort(list[roomNum], new Comparator<Player>() {
                @Override
                public int compare(Player p1, Player p2) {
                    return p1.n.compareTo(p2.n);
                }
            });


            if (list[roomNum].size() != 0) {
                if (list[roomNum].size() == m) {
                    System.out.println("Started!");
                } else {
                    System.out.println("Waiting!");
                }

                for (int playerIndex = 0; playerIndex < list[roomNum].size(); playerIndex++) {
                    System.out.println(list[roomNum].get(playerIndex).l + " " + list[roomNum].get(playerIndex).n);
                }
            }

        }
    }
}

