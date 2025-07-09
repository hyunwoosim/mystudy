package algorithm.test.baekjoon.solved.No10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            que(command);
        }

        System.out.println(sb);
    }


    public static void que(String command) {
        StringTokenizer st = new StringTokenizer(command);
        String cmd = st.nextToken();

        switch (cmd) {
            case "push" :
                int x = Integer.parseInt(st.nextToken());
                q.add(x);
                break;
            case "pop" :
                sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                break;
            case "size" :
                sb.append(q.size()).append("\n");
                break;
            case "empty" :
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
                break;
            case "front" :
                sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                break;
            case "back" :
                if (q.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(((LinkedList<Integer>) q).getLast()).append("\n");
                }
                break;
        }


    }
}