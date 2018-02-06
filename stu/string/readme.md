## String & StringBuilder
---

> String과 StringBuilder method 익히기

### string methods

```java
String str = "";

// 아래의 method를 적용해도 str은 변하지 않는다
// 예를 들어 문자열을 변환한 값을 그대로 유지하고 싶다면 str = str.replace("oldStr", "newStr")으로 해야한다


// 문자열 뒤에 추가
str += "newStr";
str.concat("newStr");


// 크기 확인, 문자열 배열은 그냥 .length, list 배열은 .size();
str.length();


// 문자 추출
str.charAt(index);


// 지정한 문자열이 어디서 시작하는지 확인, int 값 return. 없으면 -1 return
str.indexOf("anotherStr");


// 특정 문자열 기준으로 나누어 String 배열 생성
str.split("anotherStr");


// 문자열 변환, 문자열 내 해당 문자열을 새로운 문자열로 모두 변경한다
// replace와 replaceAll(반영)의 차이는 정규표현식 반영 여부
str.replace("oldStr", "newStr");
str.replaceAll("oldStr", "newStr");


// 문자열 추출, 여기서 index는 문자열 길이를 넘어서도 에러나지 않는다
str.substring(시작 index, 끝 index + 1);


// 특정 문자 제거, index2 부터 index3 - 1까지 제거된다
str.substring(index1, index2) + str.substring(index3, index4);


// 문자열 비교, 같은 인덱스끼리만 비교해서 문자열 길이가 동일할 때 적용하면 좋다.
//예를 들어 "aaac", "adb" 를 비교한다고 하면 첫번째 index는 동일하고 두 번째 인덱스는 d가 a보다 3만큼 크므로 -3을 return한다. 문자열 길이와는 무관
str.compareTo("anotherStr");


// 문자열 비교, 주소 비교가 아니라 문자열 자체를 비교한다
str.equals("anotherStr")


// 문자열 중 소문자를 대문자로 변환
str.toUpperCase();


// 문자열 중 대문자를 소문자로 변환
str.toLowerCase();


// 문자열의 공백을 없애준다
str.trim();


// 문자열 있는지 확인, true or false로 반환
str.contains("anotherStr");

// 문자, int로 강제 변환하면 ascii 넘버로 출력된다
char ch = 'a';
System.out.println((int) ch);

```

### StringBuilder methods

> StringBuffer과 사용법은 동일하지만 multi thread에서 동기화 처리가 되지 않아 속도가 빠르다는 차이점이 있다. 따라서 StringBuilder를 사용하기로 한다

```java
StringBuilder sb = new StringBuilder("str");

// 아래의 method 적용하면 sb가 바뀜

// 문자열 뒤에 추가
sb.append("anotherStr");

// 문자열 삭제
sb.delete(시작 index, 끝 index + 1);

// 문자 삭제, delete로도 가능. sb.delete(index, index + 1);
sb.deleteCharAt(해당 index);

// 문자열 변환
sb.replace(시작 index, 끝 index + 1, anotherStr);

// 문자 치환, replace로도 가능. sb.replace(index, index + 1, anotherStr);
sb.setChar(해당 index, 'anotherChar');

// 문자열 뒤집기
sb.reverse();

// 문자열 삽입하기
sb.insert(시작 index, "anotherStr");

// 이외의 메소드 length(), indexOf() 등 String과 겹치는 것들이 많다.

```
