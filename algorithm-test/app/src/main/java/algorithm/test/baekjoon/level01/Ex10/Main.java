package algorithm.test.baekjoon.level01.Ex10;

import java.util.Scanner;

// 입출력과 사칙연산 곱셈 2588
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num1, num2;
    num1 = sc.nextInt();
    num2 = sc.nextInt();

    int c1 = (num2 % 10) * num1;
    int c2 = ((num2 / 10) % 10) * num1;
    int c3 = ((num2 / 100) % 10) * num1;

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(num1 * num2);

    sc.close();
  }
}
