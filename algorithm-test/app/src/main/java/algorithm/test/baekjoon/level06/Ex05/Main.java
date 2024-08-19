package algorithm.test.baekjoon.level06.Ex05;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        int[] arr = new int[26];

        int A = System.in.read();

        while(A > 64) {

            if(A < 91) {
                arr[A - 65]++;
            } else {
                arr[A - 97]++;
            }
            A = System.in.read();
        }

        int max = -1;
        int ch = -2;

        for(int i = 0; i < 26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                ch = i;
            } else if (arr[i] == max) {
                ch = -2;
            }
        }
        System.out.println((char) (ch+65));
    }
}
