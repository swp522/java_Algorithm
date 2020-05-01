// 2020_05_01_금_31회차_과제_이진탐색트리

/*
 * 1. 수를 삽입한 후에 각각의 카운터 C값 출력
 *
 * 2. 1 ≤ N ≤ 300,000, 입력값은 중복 X
 *
 * 3. 구현, BST + 규칙
 *
 *  아직 미완성 상태임. insert 그냥 구현하면 런타임에러 계속 떠서 자료구조 활용해야할 듯
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Tree {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void makeTree(int[] arr) {
        root = makeTreeR(arr, 1, arr.length);
    }

    public Node makeTreeR(int[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return null;
        }
        int mid = ((startIndex + 1) + endIndex) / 2;
        Node node = new Node(arr[mid]);
        node.left = makeTreeR(arr, (startIndex + 1), mid - 1);
        node.right = makeTreeR(arr, mid + 1, endIndex);

        return node;
    }

//    public void searchBinaryTree(Node node, int target) {
//        if (target < node.data) {
//            System.out.println("DATA IS SMALLER THAN " + node.data);
//            searchBinaryTree(node.left, target);
//        } else if (target > node.data) {
//            System.out.println("DATA IS BIGGER THAN " + node.data);
//            searchBinaryTree(node.right, target);
//        } else{
//            System.out.println("DATA FOUND!");
//        }
//    }
//}
}


public class BOJ_2957_이진탐색트리 {

    static int n, count;
    static int[] arr, answerBST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = 0;
        arr = new int[n + 1];
        answerBST = new int[300001];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Tree t = new Tree();
        t.makeTree(arr);

        System.out.println(t);


    }
}


//    public static void insert(int num, int index) {
//
//        count++;
//        if (num < answerBST[index]) {
//            if (answerBST[index * 2] == 0) {
//                answerBST[index * 2] = num;
//            } else {
//                insert(num, index * 2);
//            }
//        } else if (num > answerBST[index]) {
//            if (answerBST[(index * 2) + 1] == 0) {
//                answerBST[(index * 2) + 1] = num;
//            } else {
//                insert(num, (index * 2) + 1);
//            }
//        }
//    }
