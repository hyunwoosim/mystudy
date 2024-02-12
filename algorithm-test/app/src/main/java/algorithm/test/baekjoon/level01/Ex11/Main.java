package algorithm.test.baekjoon.level01.Ex11;

import java.util.Scanner;

// 입출력과 사칙연산 꼬마정민 11382
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long a, b, c;
    a = sc.nextLong();
    b = sc.nextLong();
    c = sc.nextLong();

    long result = a + b + c;
    System.out.println(result);

    sc.close();
  }
}
