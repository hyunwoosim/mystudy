package algorithm.test.baekjoon.level10.Ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] T = new int[3];

        for(int i = 0; i < 3; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }

        int sum = T[0] + T[1] + T[2];
//        System.out.println(sum);

        if(sum != 180) {
            System.out.println("Error");
        } else {
            if (T[0] == 60 && T[1] == 60 && T[2] == 60 ) {
                System.out.println("Equilateral");
            } else  {
                if (T[0] == T[1] || T[1] == T[2] || T[0]== T[2]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}
