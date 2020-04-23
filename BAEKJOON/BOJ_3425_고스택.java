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
            boolean errorCheck;
            String inputCom = br.readLine();

            if(inputCom.equals("")){
                inputCom = br.readLine();
            }

            if(inputCom.equals("QUIT")){
                break;
            }

            commandList.add(inputCom);

            while (true) {
                if (inputCom.equals("END")) {
                    break;
                }
                inputCom = br.readLine();
                commandList.add(inputCom);
            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                errorCheck = false;
                long value = Long.parseLong(br.readLine());
                Stack<Long> stack = new Stack<>();
                stack.add(value);

                for (int j = 0; j < commandList.size(); j++) {

                    String command = commandList.get(j);
                    StringTokenizer st = new StringTokenizer(command, " ");
                    String command1 = st.nextToken();

                    if (command1.equals("NUM")) {
                        if (st.hasMoreTokens()) {
                            long num = Long.parseLong(st.nextToken());

                            if (0 <= num && num <= 1000000000) {
                                stack.add(num);
                            } else{
                                errorCheck = true;
                                break;
                            }
                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("POP")) {
                        if (!stack.isEmpty()) {
                            stack.pop();

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("INV")) {
                        if (!stack.isEmpty()) {
                            long a = stack.pop();
                            a *=-1;
                            stack.push(a);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("DUP")) {
                        if (!stack.isEmpty()) {
                            stack.push(stack.peek());

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("SWP")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();
                            stack.push(first);
                            stack.push(second);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("ADD")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();

                            long val = first + second;
                            if (Math.abs(val) > 1000000000) {
                                errorCheck = true;
                                break;
                            }
                            stack.push(val);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("SUB")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();

                            long val = second - first;
                            if (Math.abs(val) > 1000000000) {
                                errorCheck = true;
                                break;
                            }
                            stack.push(val);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("MUL")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();

                            long val = first * second;
                            if (Math.abs(val) > 1000000000) {
                                errorCheck = true;
                                break;
                            }
                            stack.push(val);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("DIV")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first == 0) {
                                errorCheck = true;
                                break;
                            }

                            long divVal;
                            if (first * second < 0) {
                                divVal = (-1) * (Math.abs(second) / Math.abs(first));
                            } else{
                                divVal = Math.abs(second) / Math.abs(first);
                            }

                            if (Math.abs(divVal) > 1000000000) {
                                errorCheck = true;
                                break;
                            }
                            stack.push(divVal);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    } else if (command1.equals("MOD")) {
                        if (stack.size() > 1) {
                            long first = stack.pop();
                            long second = stack.pop();

                            if (first == 0) {
                                errorCheck = true;
                                break;
                            }
                            long modVal;
                            if (second < 0) {
                                modVal = (-1) * (Math.abs(second) % Math.abs(first));

                            } else {
                                modVal = Math.abs(second) % Math.abs(first);
                            }

                            if (modVal > 1000000000) {
                                errorCheck = true;
                                break;
                            }
                            stack.push(modVal);

                        } else {
                            errorCheck = true;
                            break;
                        }
                    }

                }
                if (errorCheck == true || stack.size() != 1) {
                    System.out.println("ERROR");
                } else {
                    long answer = stack.peek();
                    System.out.println(answer);
                }
            }
            System.out.println();

        }

    }
}
