package algorithm.test.baekjoon.solved.No1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 가장 앞에 있는 문서의 중요도 확인
    // 2. 현재 문서보다 중요도가 높은 문서가 있으면 현재 문서를 제일 뒤에 배치
    // 3. 그렇지 않다면 현재 문서 인쇄
    // 중요도 1 ~ 9  높은 수가 중요도 높은

    // 테스트 케이스는 2줄 씩 주어진다.
    // 맨 첫번 줄 테스트 케이스 갯 수
    // 테스트 케이스 1번 줄  문서 개 수:N, 몇 번쨰로 인쇄되었는지 궁금 문서의 현재 위치(인덱스위치): M
    // 테스트 케이스 2번 줄 N개의 문서의 중요도 (1~N) 최대 중요도는 9까지
    // 중요도가 같은 문서도 여러 개 존재 가능

    // 몇 번째로 인쇄되는지 출력해야함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCases = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int t = 0; t < testCases; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] importance = br.readLine().split(" ");

            int result = calculatePrintOrder(N, M, importance);

            System.out.println(result);
        }
    }

    public static int calculatePrintOrder(int N, int M, String[] importance) {
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int priority = Integer.parseInt(importance[i]);
            q.add(new int[]{priority, i});
        }

        int printCount = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            boolean hasHigher = false;


            for (int[] doc : q) {
                if (doc[0] > current[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.add(current);
            } else {
                printCount++;

                if (current[1] == M) {
                    return printCount;
                }
            }
        }

        return -1;
    }
}