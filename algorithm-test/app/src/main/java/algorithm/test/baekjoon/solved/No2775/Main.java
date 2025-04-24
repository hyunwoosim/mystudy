package algorithm.test.baekjoon.solved.No2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // k층
    // n호


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[][] apt = new int[k + 1][n + 1];

            // 0층 초기화
            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            // 1층부터 k층까지
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }

            System.out.println(apt[k][n]);
        }
    }
}