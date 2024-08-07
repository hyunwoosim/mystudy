package algorithm.test.baekjoon.level03.Ex01;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        for(int i = 1; i <=9; i++) {
            int sum = a * i;
            System.out.println(a + " * " + i + " = " + sum);
        }
    }

}
