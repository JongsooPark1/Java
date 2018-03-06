## and others
---

### nextInt() 사용시 주의할 점

* 기존 code

```java
static int getHowManyManual() {
		System.out.println("수동으로 구매할 장수를 입력해주세요");
		Int num = sc.nextInt();
		return num;
	}
```

위의 코드는 숫자를 입력 받아 return하는 메소드이다. 하지만 문제는 이후에 scanner를 또 사용할 경우에, 개행문자(\n)가 버퍼에 남아있게 되어
다음 scanner 사용시 문제가 발생할 수 있다. 따라서 그 경우 아래 코드와 같이 사용한다

* 수정 code

```java
static int getHowManyManual() {
		System.out.println("수동으로 구매할 장수를 입력해주세요");
		String num = sc.nextLine();
		return Integer.parseInt(num);
	}
```

### System.getProperty("line.separator")

운영 체제에 따라 개행 문자는 달라질 수 있다. 따라서 위와 같은 명령어를 이용한다

안될시, \r\n or (\r ? \n) or (\\r ? \\n) 사용해보기


### import static utils.StringUtils.appendNewLine;

이는 utils 패키지의 StringUtils 클래스에 있는 appendNewLine 메소드를 다른 패키지 또는 다른 클래스에서 자유롭게 사용할 수 있게 한다

### StringBuilder

```java
StringBuilder sb = new StringBuilder();
sb.append("Will");
sb.append(" Park");
System.out.println(sb);
```

출력 결과 : Will Park

즉, StringBuilder를 생성하면 append와 같은 여러 String 조작 메소드 및 필드를 사용할 수 있다

### Queue

```Java
Queue<Integer> q = new LinkedList<>();

// 뒤에서부터 삽입
q.offer(1);

// 앞에서부터 하나만 빼기(선입선출)
q.poll();

// 앞에서부터 하나만 보기(먼저 들어간 것 부터), queue에서 제거되지는 않는다. poll()과의 차이
q.peek();
```

* 참고 사이트

https://msdn.microsoft.com/en-us/library/system.text.stringbuilder.aspx

http://www.dreamy.pe.kr/zbxe/CodeClip/158356

### next()와 nextLine()의 차이

※ next()는 개행문자, 공백은 무시하고 문자를 입력받는다. 개행문자 또는 공백은 버퍼에 남아 있다. 따라서 next()이후에 nextLine()을 사용할 경우, 버퍼에 남아있는 공백 또는 개행문자가 남아있기 때문에 제대로 입력 값을 못 받는 경우가 있으니 주의한다. 이를 해결하기 위해선 next()로만 사용하거나 nextLine()으로만 사용한다. 예를 들어 nextInt() 사용후 이후에 nextLine()으로 줄단위 입력을 받을 때, nextInt()를 입력하고 남은 개행문자가 버퍼에 남아있어 다음에 사용하는 nextLine()에 영향을 줄 수 있다


```Java
Scanner s = new Scanner("\n\ntest\nhoho\n");

while (s.hasNext()) {
    System.out.println("출력: " + s.next());
}
// <결과>
// 출력: test
// 출력: hoho
```

※ nextLine()은 한 줄 단위로 입력받기 때문에 개행문자도 한 줄로 인식한다

```Java
// nextLine()
Scanner s = new Scanner("\n\ntest\nhoho\n");

while (s.hasNext()) {
    System.out.println("출력: " + s.nextLine());
}
// <결과>
// 출력:
// 출력:
// 출력: test
// 출력:
// 출력: hoho
// 출력:
```

참고

http://bing9blog.com/java-scanner-next-nextline%EC%B0%A8%EC%9D%B4%EC%99%80-%EC%9E%85%EB%A0%A5%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0%EB%B2%95/

### hasNext()와 hasNextLine()의 차이

hasNextLine() checks to see if there is another linePattern in the buffer

hasNext() checks to see if there is a parseable token in the buffer, as separated by the scanner's delimiter
