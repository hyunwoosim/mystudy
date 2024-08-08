package algorithm.test.baekjoon.level03.Ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int total = N/4;
        for(int i = 0; i <total; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }

}
