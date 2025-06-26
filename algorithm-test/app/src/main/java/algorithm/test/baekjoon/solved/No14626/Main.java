package algorithm.test.baekjoon.solved.No14626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbn = br.readLine();

        int miss = 0;
        int sum = 0;

        for(int i = 0; i < 13; i++) {
            char ch = isbn.charAt(i);

            if(ch == '*') {
                miss = i;
            } else {
                int num = ch - '0';
                if(i % 2 == 0) {
                    sum += num;
                } else {
                    sum += num * 3;
                }
            }
        }

        for(int candidate = 0; candidate <= 9; candidate++) {
            int total = 0;

            if(miss % 2 == 0) {
                total += sum + candidate;
            } else {
                total += sum + candidate * 3;
            }

            if(total % 10 == 0){
                System.out.println(candidate);
                break;
            }
        }

    }
}