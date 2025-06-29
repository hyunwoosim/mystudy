package algorithm.test.baekjoon.solved.No1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[][] board = new String[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= M - 8; i++) {
            for (int j = 0; j <= N - 8; j++) {
                int repaint = countRepaint(board, i, j);
                minCount = Math.min(minCount, repaint);
            }
        }

        System.out.println(minCount);
    }

    public static int countRepaint(String[][] board, int startX, int startY) {
        int countWStart = 0;
        int countBStart = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String current = board[startX + i][startY + j];
                if ((i + j) % 2 == 0) {
                    if (!current.equals("W")) countWStart++;
                    if (!current.equals("B")) countBStart++;
                } else {
                    if (!current.equals("B")) countWStart++;
                    if (!current.equals("W")) countBStart++;
                }
            }
        }

        return Math.min(countWStart, countBStart);
    }



    }