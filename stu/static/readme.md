## Static
---
static은 필드와 메소드 앞에 붙어 정적 멤버를 만든다.

1. 외부 class에서 정적멤버를 사용하는 경우
*  객체를 선언하지 않고 클래스로 접근한다.
```
A.method;
A.field;
```
* 아래는 잘못된 표현이지만, 실행은 된다
```
A a = new A();
a.method;
a.field;
```

2. 정적 멤버에서 인스턴스 멤버를 사용하는 경우
* 객체로 접근한다.
* 또는 인스턴스 멤버에 static을 붙여 정적멤버로 변환 후 사용한다


------
static이 붙어 있는 method는 인스턴스를 만들지 않고 사용할 수 있다

붙어 있지 않은 method는 인스턴스를 만들고 사용해야 한다

3. 예제

```java
public class StaticMemberEx01 {
	static int a; // 정적 필드
	int b; // 인스턴스 필드
	StaticMemberEx01(int a, int b){
		this.a = a; // 매개값 할당
		this.b = b; // 매개값 할당
	}
	public String print(){
		String value = "a : " + a + ", b : " + b;
		return value;
	}

	public static void main(String[] args) {
		StaticMemberEx01 sm = new StaticMemberEx01(1, 2);
		StaticMemberEx01 sm1 = new StaticMemberEx01(2, 3);
		StaticMemberEx01 sm2 = new StaticMemberEx01(3, 4);
		System.out.println(sm.print()); // a : 3, b : 2
		System.out.println(sm1.print()); // a : 3, b : 3
		System.out.println(sm2.print()); // a : 3, b : 4
	}
}
[출처] [JAVA/자바] 정적 멤버(필드, 메소드)와 static|작성자 JOKER
```
