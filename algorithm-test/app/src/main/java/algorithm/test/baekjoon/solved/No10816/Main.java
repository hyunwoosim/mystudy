package algorithm.test.baekjoon.solved.No10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        // 첫째 줄 : 상근이가 가지고 있는 카드 개수 :N
        // 둘째 줄 : 숫자 카드에 적혀있는 정수
        // 셋째 줄 : 정수 갯수 :M
        // 넷째 줄 : 맞춰야 할 정수들

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        Map<Integer, Integer> cardMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(cards[i]);
            cardMap.put(num, cardMap.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(targets[i]);
            sb.append(cardMap.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }
}