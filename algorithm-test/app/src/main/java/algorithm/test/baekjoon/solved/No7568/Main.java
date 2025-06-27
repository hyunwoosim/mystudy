package algorithm.test.baekjoon.solved.No7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            int count = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) {
                    count++;
                }
            }

            rank[i] = count;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : rank) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}