// String - StringBuffer vs StringBuilder

package com.eomcs.basic.ex02;

public class Exam0164 {
  public static void main(String[] args) throws Exception {
    StringBuilder buf = new StringBuilder();

    Worker w1 = new Worker(buf, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    Worker w2 = new Worker(buf, "---------------------------------------------------");
    Worker w3 = new Worker(buf, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    Worker w4 = new Worker(buf, "***************************************************");

    // 순차적으로 작업을 시키지 않고 동시에 진행한다.
    // => Thread객체 대해 start()를 호출하면 run() 메서드를 실행시키고 즉시 리턴한다.
    // => 즉 run() 메서드의 작업이 끝날 때까지 기다리지 않는다.

    w1.start();
    w2.start();
    w3.start();
    w4.start();

    // 이전에 실행 시킨 작업이 끝날 때까지
    // 2초 정도 기다렸다가 다음 명령을 실행한다.
    Thread.currentThread().sleep(2000);
    System.out.println("실행 끝!");
    System.out.println(buf.length());
  }
  // 하는 일 :
  // - 주어진 메세지를 버퍼에 100번 담는 일을 한다.

  static class Worker extends Thread {
    String message;
    StringBuilder buf;

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        buf.append(message);
      }
    }

    public Worker(StringBuilder buf, String message) {
      this.buf = buf;
      this.message = message;


      System.out.printf("%s 메시지 저장 끝!\n", message);
    }
  }
}

