// 2020_03_18_(수) 강남스터디_8회차_과제_구간합구하기
// 세그먼트 트리


import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int totalNumber;
    private static int changeCount;
    private static int sumCount;
    private static int[] number;
    private static long[] segment;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        totalNumber = Integer.parseInt(st.nextToken());
        changeCount = Integer.parseInt(st.nextToken());
        sumCount = Integer.parseInt(st.nextToken());
        initNumber();
        segment = new long[4 * totalNumber];
        initSegment(1, totalNumber, 1);
        solve();
    }

    public static void initNumber() throws IOException {
        number = new int[totalNumber + 1];
        for (int i = 1; i <= totalNumber; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
    }

    public static long initSegment(int nodeStart, int nodeEnd, int nodeIndex) { //nodeIndex 는 start 와 end의 구간을 indexing 함->segment[]의 index 다
        if (nodeStart == nodeEnd) {//동시에 같은 원소를 가리키고 있따. leaf 노드 !
            segment[nodeIndex] = number[nodeStart];
            return segment[nodeIndex];
        }
        int nodeMid = (nodeStart + nodeEnd) / 2;
        segment[nodeIndex] = initSegment(nodeStart, nodeMid, 2 * nodeIndex)
                + initSegment(nodeMid + 1, nodeEnd, 2 * nodeIndex + 1);
        return segment[nodeIndex];
    }

    public static void solve() throws IOException {
        for (int i = 1; i <= changeCount + sumCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            int changeNumber = 1;
            int sumRangeNumber = 2;
            int nodeIndex = 1;
            if (mode == changeNumber) {
                int indexToChange = Integer.parseInt(st.nextToken());
                int numberToChange = Integer.parseInt(st.nextToken());

                updateSegment(1, totalNumber, nodeIndex, indexToChange, numberToChange);
            } else if (mode == sumRangeNumber) {
                int queryStart = Integer.parseInt(st.nextToken());
                int queryEnd = Integer.parseInt(st.nextToken());

                long output = sumSegment(1, totalNumber, nodeIndex, queryStart, queryEnd);
                bw.write(output + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static void updateSegment(int nodeStart, int nodeEnd, int nodeIndex, int indexToChange, int numberToChange) {
        if (indexToChange < nodeStart || indexToChange > nodeEnd) {
            return; //start 와 end 사이에 대상 index 없으면 리턴
        }
        else if (nodeStart == nodeEnd) {  //같은 위치의 원소를 가리키고 있따 : noddIndex의 위치에 nodeStart와 nodeEnd가 도착했따
            segment[nodeIndex] = number[indexToChange] = numberToChange;    // numberToChage로 값 바꿔준다
            return;
        }

        int nodeMid = (nodeStart + nodeEnd) / 2;
        updateSegment(nodeStart, nodeMid, 2 * nodeIndex, indexToChange, numberToChange);
        updateSegment(nodeMid + 1, nodeEnd, 2 * nodeIndex + 1, indexToChange, numberToChange);

        segment[nodeIndex] = segment[2 * nodeIndex] + segment[2 * nodeIndex + 1];
    }

    public static long sumSegment(int nodeStart, int nodeEnd, int nodeIndex, int queryStart, int queryEnd) {
        if (queryStart <= nodeStart && nodeEnd <= queryEnd) {
            return segment[nodeIndex];  // 1. 완전히 겹치면 -> 해당 합 값 리턴
        }
        else if (queryEnd < nodeStart || queryStart > nodeEnd) {
            return 0;   //2. 구간 안겹치면 -> 내 노드값은 구간의 합에 관여하지 않으니까 0리턴
        }
        int nodeMid = (nodeStart + nodeEnd) / 2;
        // 1,2 제외한 경우 - 쿼리와 노드 구간이 겹치눈 겹치는 구간 발생
        return (sumSegment(nodeStart, nodeMid, 2 * nodeIndex, queryStart, queryEnd)
                + sumSegment(nodeMid + 1, nodeEnd, 2 * nodeIndex + 1, queryStart, queryEnd));
    }
}
