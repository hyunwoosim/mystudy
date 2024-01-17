
# 데이터 입출력
  24.01.05

## 입출력 스트림
1. 입 출력 스트림이란?
  - 파일에 저장되거나 다른 프로그램으로 전송되는 것을 
  - 총칭하여 데이터 입출력이라 한다.
    - ex) 키보드를 통해 데이터를 입력받는다., 데이터를 모니터로 출력한다.

2. 스트림의 두 종류
  - 바이트 스트림 
    - 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 입출력할 때 사용
  - 문자 스트림
    - 문자만 입출력 할 때 사용한다.

3. 자바 I.o 패키지
  - 바이트 스트림의 최상위 클래스는
    - 입력 = InputStream 
    - 출력 = OutputStream
  - 문자 스트림의 최상위 클래스는
    - 입력 = Reader
    - 출력 = Writer

4. OutputStream(바이트 출력 스트림)
  - 바이트 출력 스트림의 최상위 클래스로 추상클래스이다.
  - 모든 바이트 클래스는 OutputStream을 상속받아 만들어진다.
  - ex) FileOutputStream, BufferedOutputstream, DataOutputStream 등등
  - 모든 바이트 출력 스트림이 가져야 할 메서드가 정의되어 있다.
```
주요 메서드

void write(int b)  1byte를 출력
void write(byte[] b) 배열 b의 모든 바이트 출력
void write(byte [] b, int off, int len)  배열 b의 [off]부터 len 개의 바이트 출력
void flush() 버퍼에 잔류하는 모든 바이트를 출력
void close()  출력 스트림을 닫고 사용 메모리 해제 
```

  - write(int b) 는 메서드의 매개값 int(4byte)에서 끝에 1byte만 출력한다.