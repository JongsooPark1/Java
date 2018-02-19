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

// 삽입
q.offer(1);

// 빼기(선입선출)
q.poll();

// 보기(먼저 들어간 것 부터), queue에서 제거되지는 않는다. poll()과의 차이
q.peek();
```

* 참고 사이트

https://msdn.microsoft.com/en-us/library/system.text.stringbuilder.aspx

http://www.dreamy.pe.kr/zbxe/CodeClip/158356
