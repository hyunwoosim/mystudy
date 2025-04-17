package algorithm.test.baekjoon.solved.No15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        // ai = 배열 영어 알파벳
        // l = 5
        // r = 31
        // M = 1234567891

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String A = br.readLine();
        long r = 1;
        long H = 0;

        for(int i =0; i < L; i++) {
            H += ((A.charAt(i)-96) * r);
            r = ((r*31) % 1234567891);
        }

        System.out.println(H % 1234567891);
    }
}