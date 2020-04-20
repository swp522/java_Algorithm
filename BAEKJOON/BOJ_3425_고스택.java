// 2020_04_19_월_과제_28회차_고스택

/*
 * 1. 각각의 입력값에 대한 출력
 *
 * 2. 0 ≤ N ≤ 10,000  / 0 ≤ Vi ≤ 10^9
 *
 * 3. 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_3425_고스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            ArrayList<String> commandList = new ArrayList<>();
            String inputCom = br.readLine();

            if (inputCom.equals("QUIT")) {
                break;
            }

            while (true) {
                if (inputCom.equals(" ")) {
                    continue;
                }
                if (inputCom.equals("END")) {
                    break;
                }
                commandList.add(inputCom);
                inputCom = br.readLine();


            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                long value = Long.parseLong(br.readLine());
                Stack<Long> stack = new Stack<>();
                stack.add(value);

                for (int j = 0; j < commandList.size(); j++) {// !stack.isEmpty() 로 표현하면 안된다

                    if (stack.size() > 1000) {
                        System.out.println("ERROR");
                        break;
                    }

                    String command = commandList.get(j);
                    StringTokenizer st = new StringTokenizer(command, " ");
                    String command1 = st.nextToken();

                    if (command1.equals("NUM")) {
                        if (st.hasMoreTokens()) {
                            long num = Long.parseLong(st.nextToken());

                            if (0 <= num && num <= 1000000000) {
                                stack.add(num);
                            }
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("POP")) {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("INV")) {
                        if (!stack.isEmpty()) {
                            long a = stack.pop();
                            a *= -1;
                            stack.push(a);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("DUP")) {
                        if (!stack.isEmpty()) {
                            stack.push(stack.peek());
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("SWP")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();
                            stack.push(first);
                            stack.push(second);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("ADD")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first + second > 1000000000) {
                                System.out.println("ERROR");
                                break;
                            }

                            stack.push(first + second);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("SUB")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (second - first > 1000000000) {
                                System.out.println("ERROR");
                                break;
                            }

                            stack.push(second - first);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("MUL")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first * second > 1000000000) {
                                System.out.println("ERROR");
                                break;
                            }

                            stack.push(first * second);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("DIV")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first == 0) {
                                System.out.println("ERROR");
                                break;
                            }

                            long divVal = second / first;

                            if (divVal > 1000000000) {
                                System.out.println("ERROR");
                                break;
                            }

                            if (second < 0) {
                                divVal = Math.abs(second) / Math.abs(first);
                                if (first < 0 || second < 0) {
                                    divVal *= -1;
                                }
                            }

                            stack.push(divVal);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    } else if (command1.equals("MOD")) {
                        if (!stack.isEmpty()) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first == 0) {
                                System.out.println("ERROR");
                                break;
                            }
                            long modVal = second % first;

                            if (modVal > 1000000000) {
                                System.out.println("ERROR");
                                break;
                            }

                            if (second < 0) {
                                modVal = Math.abs(second) % Math.abs(first);
                                if (first < 0 || second < 0) {
                                    modVal *= -1;
                                }

                            }
                            stack.push(modVal);
                        } else {
                            System.out.println("ERROR");
                            break;
                        }
                    }
                    //commmand 하나씩 선택하는 for 문

                }

                if (stack.isEmpty() || stack.size() != 1) {
                    System.out.println("ERROR");
                } else {
                    long answer = stack.peek();
                    System.out.println(answer);
                }

            }

        }
    }
}

