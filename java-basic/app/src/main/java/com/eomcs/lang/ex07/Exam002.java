package com.eomcs.lang.ex07;

import java.util.Scanner;

// # 메서드 : 사용 전
//
public class Exam002 {

  static void printSpaces(int spaceLen) {
    // 별 앞에 공백 출력
    int spaceCnt = 1;
    while (spaceCnt <= spaceLen) {
      System.out.print(" ");
      spaceCnt++;
    }
  }

  static void printStar(int starLen) {
    // 별 출력
    int starCnt = 1;
    while (starCnt <= starLen) {
      System.out.print("*");
      starCnt++;
    }
  }

  static int computeSpaceLength(int len, int starLen) {
    return (len - starLen) / 2;
  }

  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();


    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpaces(computeSpaceLength(len, starLen));
      printStar(starLen);
      // 출력 줄 바꾸기
      System.out.println();

    }
  }
}
