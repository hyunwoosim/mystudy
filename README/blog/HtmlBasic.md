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