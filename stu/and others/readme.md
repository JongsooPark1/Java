## and others
---

1. nextInt() 사용시 주의할 점

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
