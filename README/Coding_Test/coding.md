# 코딩 시험 문제(?)

##  지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력하라. java.io ex710
```
 File dir = new File("."); 
 System.out.println(dir.getCanonicalPath());
```
- 현재 파일 위치를 조회한다.
- getCanonicalPath() 는 계산된 절대경로가 나오낟
- ex) C:\Users\kshsi\git\mystudy\java-basic\app

```
File dir = new File("."); 
 System.out.println(dir.getCanonicalPath());

 printList(dir);

 static void printList(File dir){
  File[] files = dir.listFiles(); // 배열을 생성하여 파일목록 저장
 
 for(File file : files) // for문을 통해 저장되어있는 목록을 다 꺼낸다.
 { System.out.println(file.getName());
 }
 }
```
 - 현재 디렉토리의 하위 파일 및 디렉토리 목록을 알아낸다.
 - 리턴 받은 파일 배열에서 이름을 꺼내 출력한다.

```
File dir = new File("."); 
 System.out.println(dir.getCanonicalPath());

 printList(dir);

 static void printList(File dir){
  File[] files = dir.listFiles(); 
 
 for(File file : files) {
  if(file.isDirectory() && !file.isHidden())
  // 만약 디렉토리이고 숨긴파일이 아니라면
  {System.out.printf("%s/\n, file.getName());
  // 이름/을 꺼낸다.
  }else if (file.isFille())
  //만약 파일만 있다면
  {System.out.printf("%s\n, fiel.getname());
  // 파일의 이름만 꺼낸다.
  }
 }
 }
 다 꺼낼때 가지 반복
```


## 홀수만 출력하기
- n개의 정수가 주어졌을 때, 주어진 숫자 중 홀수이면서 3의 배수인 수들만   순서대로 출력하는 프로그램을 작성해보세요.
- 첫 번째 줄에 정수 n이 주어집니다.
- 두 번째 줄부터 n개의 줄에 걸쳐 한 줄에 정수가 하나씩 주어집니다.
  * 1 ≤ n ≤ 10

  * 1 ≤ 주어지는 정수 ≤ 100

- 처음에 n개의 정수만 보고서 문제를 풀다가 큰 코 다쳤다.
- 문제를 차근차근 읽어보자

1. n개의 정수가 주어졌을때 주어진 숫자중 
  - 만약 n=5라면 n을 포함해서 총 6개의 숫자가 주어진다는 뜻이다.
2. 홀수이면서 ,3의 배수인 수들만 출력하라
  - if문을 사용해야한다.

### 내가 푼 코드
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in); // 입력 받을 스캐너 객체 생성
        int n = sc.nextInt();   // 키보드에서 입력 받은 값을 n에 넣는다.

       int[] list = new int[n]; // n 길이의 배열 생성
        

        for(int i = 0;  i<n; i++){    // 반복문을 사용하여 i에 입력받은
            list[i] = sc.nextInt();   // 값을 넣는다.
        }

        for(int i : list){            // 배열에 있는 값을 모두 꺼낸다
            if(i %2 ==1 && i%3==0){   // if문을 통해서 맞는 값만 출력한다.
                System.out.println(i);
            }
        }
      }
    }
```


### 다른방법
```
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 변수 선언
        int n;

        // 입력
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {   
            int a;
            a = sc.nextInt();
            if(a % 2 == 1 && a % 3 == 0)
                System.out.println(a);
        }
    }
}
```
- n의 정수를 입력받아 n번의 반복문을 돌며 출력할 수 있다.

### 문제점
- 처음 주어진 숫자들을 넣어야할 때 배열이 생각나서 배열로 풀었다.
- 하지만 더 편하게 풀 수있는 방법이 있었다
- 하나의 생각에 깊이 빠져들면 다른 길이 보이지않는다. 머리를 식히고 
- 다시 풀자
- 문제를 쫌 더 분석하고 너무 깊은 생각에 빠지지말자
