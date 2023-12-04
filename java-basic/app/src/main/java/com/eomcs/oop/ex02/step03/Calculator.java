package com.eomcs.oop.ex02.step03;

public class Calculator {

  static int result = 0;


  static void plus(int value) {

    result += value;
  }

  static void minus(int value) {
    result -= value;
  }

  static void multiple(int value) {
    result *= value;
  }

  static void divide(int value) {
    result /= value;
  }

  // 다음 메서드는 계산 결과를 사용하지 않는다.
  // 파라미터 값에 대해 절대값을 리턴하는 일을 한다.
  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}
