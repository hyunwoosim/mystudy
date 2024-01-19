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

