package algorithm.test.baekjoon.level06.Ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        for(int i = 1; i <= A; i++){
            for(int j = 0; j < A-i; j++  ) {
                System.out.print(" ");
            }
            for(int q = 0; q < 2*i-1; q++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = A-1; i >=0 ; i--){
            for(int j = 0; j <A-i; j++){
                System.out.print(" ");
            }for(int q = 0; q < 2*i-1; q++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
