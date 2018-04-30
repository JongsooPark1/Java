## JUnit (test code)
---

> main method를 활용해 테스트할 때 발생하는 문제점을 해결하기 위해 등장한 도구가 JUnit이다

### 예시

```java
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    Calculator cal;

    @Before
    public void setUp()  {
        cal = new Calculator();
    }

    @Test
    public void 덧셈()  {
        assertEquals(7, cal.add(3, 4));
    }

    @Test
    public void 뺄셈()  {
        assertEquals(1, cal.subtract(5,  4));
    }

    @Test
    public void 곱셉()  {
        assertEquals(6, cal.multiply(2, 3));
    }

    @Test
    public void 나눗셈()  {
        assertEquals(2, cal.divide(8, 4));
    }

    @After
    public void tearDown() {
        cal = null;
    }
}
```

### Annotation 활용

@Before : 테스트 전 단계로 각 테스트 전에 실행

@Test : 실제 메소드를 테스트

@After : 테스트를 마친 후 실행

### 이용하는 메소드

assertEquals : 메소드의 값을 직접 입력해 비교

assertTrue : return 값이 true인지 확인

```java
assertTrue (test());
```

assertFalse : return 값이 false인지 확인

```java
assertFalse (test());
```
