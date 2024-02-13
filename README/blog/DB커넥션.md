# DB 커넥션 공유의 문제점과 해결점

- 각각의 스레드로 작업을 할 때 하나의 커넥션을 공유해서 사용한다면
- 각각의 스레드의 작업 결과가 임시DB에 함께 저장된다.
- 한 스레드가 commit을 실행한다면 함께 commit 되기 때문에
- 다른 스레드에서 rollback을 요청해도 취소할 수 없다.
- **클라이언트는 각각의 커넥션을 사용해야한다.**

# 해결책 

## 방법 1. 스레드별 각각의 Connection을 만든다.
- SQL 실행할 때 마다 Connection 생성하기   
 ==> 다른 Thread의 SQL작업을 간섭하지 않는다.

### 단점
1. "auth"
  - "auth"란 사용자인증(Authentication), 권한조회(Authorization) 앞의 4글자를 딴것이다.
 - Authentintication(사용자 인증) : ID/PWD 유효성을 검증한다.
 - Authorization(권한 조회) : 사용자의 권한 범위 조회
- 매번 생성할 때마다 사용자 인증, 권한조회를 거쳐야하기 때문에 시간이 낭비되고 가비지가 생성된다.

2. 트랜잭션(Tx, transaction)으로 묶을수 없다
  - transaction(트랜잭션) insert(),commit,rollback을 말한다. Tx라고도 부른다.
- 하나의 스레드로 작업을 해도 connnection이 다르기 때문에 작업결과가 다른다   
연관있는 작업을 해도 각각의 커넥션에서 수정을 해야한다.

# 방법 2. 스레드당 1개의 Connection 유지
 1. 스레드마다 다른 Connection 사용 ==> 다른 스레드의 Commit/rollback에 영향을 받지 않는다.
 2. 한 스레드가 SQL을 실행하는 동안 Connection 사용 ==> 여러개의 데이터 변경작업을 하나의 트랜 잭션으로 묶을 수 있다.
 