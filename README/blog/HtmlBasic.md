# HTML 기초
1. HTML이란 ?
  * 웹 문서를 만드는 언어이다.
  * HyperText Markup Language의 줄임말이다.

2. HTML문서의 기본 구조
```
<!DOCTYPE html>
<html lang="ko">
<head>
</haed>
<body>
</body>
</html>
```
- **!DOCTYPE html** : 현재 문서가 HTML언어로 작성한 웹 문서라는 뜻
- **html ~ /html** : 웹 문서의 시작과 끝을 나타내는 태그
- **head ~ /head** : 웹 브라우저가 웹 문서를 해석하는데 필요한 정보를 입력하는 부분
- **body ~ /body** : 웹 브라우저 화면에 나타나는 내용
- **html lang="ko** : korea의 줄임말로 언어를 나타낸다.

# haed
## 1. meta 태그
- 메타 태그는 '데이터에 관한 데이터'를 말한다.
- 웹 브라우저에는 보이지 않지만 웹 문서와 관련된 정보를 저장할 때 사용한다.
- 가장 중요한 역할은 **화면에 표시할 글자의 인코딩을 정할때 사용한다.**
```
<meta charset="UTF-8">
```

## 2. title 태그
- 웹 문서의 제목을 정하는 태그이다.
- 제목 표시줄에 표시된다

# 시맨틱 태그
- HTML태그는 이름만 봐도 의미를 알 수 있어 시맨틱(semantic)태그라고 한다.
```
예)
텍스트 다락(paragraph) <p>
앵커(anchor) <a>
```

## 주요 시맨틱 태그

## header
- 말그대로 헤더영역을 의미한다.
- 특정 영역 헤더도 있다.
- 주로 맨 위쪽이나 왼쪽에 있다.
- 검색창, 사이트 메뉴를 삽입한다.

## nav
- 내비게이션 영역
- 같은 웹 문서 안에서 다른 위치를 연결하거나 다른 웹 문서로 연결하는 링크를 만든다.
- 

## main
- 메인 콘텐츠가 들어있는 영역
- 핵심이 되는 내용을 넣는다.
- 똑같이 들어간 정보는 넣을 수 없다.
- 문서마다 다르게 보여주는 내용을 구성한다.
- 웹 문서에서 한번만 사용 가능하다.

## article
- 웹에서 실제로 보여주고 싶은 내용을 넣는다.
- 독립된 웹 콘텐츠 항목
- 여러번 사용할 수 있다.
- 안에 section 태그를 넣을 수 있다.

## seciton
- 아티클 태그와 비슷하지만 섹션 태크는 몇 개의 콘텐츠를 묶는 용도로 사용한다.

## aside
- 사이드 바는 필수 요사가 아니므로 필요한 경우에만 사용

## footer
- 푸터는 맨 아래쪽에 만든다.
- 사이트 정보, 저작권 정보, 연락처 등을 넣는다.
- 다른 시맨틱 태그를 사용할 수 있다.

## div
- id, class 속성을 사용해서 문서구조를 만들거나 스타일을 적용할 때 사용한다.
- 영역을 구별하거나 스타일로 문서를 꾸미는 것이다.
```
<div id="header">
<div class="detail">
```

# 텍스트 입력하기

## hn 태그
- 제목을 나타내는 태그이다.
- h는 제목을 뜻하는 Heading의 줄임말이다.
- n은 1~6까지의 숫자가 들어간다.
- h1이 가장 큰 제목이고 순서대로 크기가 작아진다.

## P 
- p태그에 텍스트를 입력하면 텍스트 앞뒤로 빈 줄이 생기면서 텍스트 단락이 만들어진다.
- **주의** 편집기에서 줄을 바꿔도 웹브라우저에서는 한줄로 표시된다.

## br
- 단독으로 사용하는 태그이다.
- 줄 바꿈 태그