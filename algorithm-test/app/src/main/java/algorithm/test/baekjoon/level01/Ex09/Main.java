package algorithm.test.baekjoon.level01.Ex09;

import java.util.Scanner;

// 입출력과 사칙연산 나머지 10430
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a, b, c;
    a = sc.nextInt();
    b = sc.nextInt();


    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println((a % c) * (b % c) % c);
  }
}
