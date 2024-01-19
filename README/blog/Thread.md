# Thread

## 멀티 스레드
- 스레드란 코드의 실행을 말한다.
- main 스레드는 하나의 실행 흐름이다.
- main() 에서 시작해 종료까지 끊기지않고 실행해 나간다.
- 예를 들어 m1()을 호출하면 실행이 끝난 후 ruturn하여 다시 돌아온다.
- 그렇기 때문에 Thread(실)라 하는 것이다.

- 멀티 스레드는 프로세스 내부에 생성되기 때문에 하나의 예외를 발생시키면
- 프로세스가 종료되므로 다른 프로세스에게도 영향을 준다.
- 그렇기 때문에 멀티 스레드를 사용할 땐 예외처리에 최선을 다해야한다.

- 하나의 실행흐름 안에 또 다른 실행흐름을 사용하려면 멀티 스레드를 사용한다.

## Thread 자식 클래스로 생성
- Thread 클래스를 상속한 다음 run() 메소드를 재정의해서 스레드안에 실행코드를 적으면 된다.
```
public class WorkerThread extends Thread {
  @Override
  public void run(){
    실행 코드
  }
}
Thread thread = new WorkerThread();
// 스레드 객체 생성

```

## Thread 직접 생성
- Runnable은 실행할때 사용하는 인터페이스이다.
- Runnable에는 run()메서드가 정의되어 있다
- 구현 클래스는 run()을 재정의해서 스레드가 실행할 코드를 가지고 있어야한다.
```
Thrad thread = new Thrad(Runnable target);

Class Task implements Runnalbe{
  @Override
  public void run(){
    // 스레드가 실행할 코드
  }
}
```
- Thread 생성자를 호출할 때 Runnable 익명 구현 객체를 매개값으로 사용할 수 있다.
```
Thread thread = new Thread(new Runnable {
  @Override
  public void run() {
    //스레드 실행할 코드
  }
});
```
- 작업스레드는 객체가 생성되었다고 바로 실행되지 않는다.
- 스레드 객체의start() 메서드를 호출해야한다.
```
thread.start();
```