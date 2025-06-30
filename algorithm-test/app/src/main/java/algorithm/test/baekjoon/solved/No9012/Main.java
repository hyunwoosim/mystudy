package algorithm.test.baekjoon.solved.No9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(isVPS(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    public static String isVPS(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);

            } else if (stack.empty()) {
                return "NO";

            } else {
                stack.pop();
            }

        }
        return stack.isEmpty() ? "YES" : "NO";
    }

}