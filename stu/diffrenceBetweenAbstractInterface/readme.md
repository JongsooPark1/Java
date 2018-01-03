## interface와 abstract class 차이
---

1. interface는 abstract class와 달리 다중 상속을 허용한다. 즉 부모 인터페이스가 두 개 이상일 수 있다는 의미

```java
public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {
  ...
}
```

2. abstract class는 class이기 때문에 구현 할 때에 extends라는 표현을 쓰고, iterface는 implements를 사용한다
