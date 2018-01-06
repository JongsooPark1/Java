## Object
---

>  java의 최상위 부모 클래스

### 객체 비교, equals()

Object class의 equals() 메소드는 비교 연산자인 ==과 동일한 결과를 리턴한다

하지만 각 객체에서 equals() 메소드를 @Override하여 equals의 의미를 다르게 나타내기도 한다

예를 들어, String class에서 equals()는 기준 객체와 비교 객체의 번지 값을 비교하는 것이 아니라 문자열을 비교한다

또한 기준 객체와 비교 객체의 타입은 동일해야한다. 그렇지 않으면 false를 return한다

```java
@Override
public boolean equals(Member m2) {
  if (m2 instanceof Member) {
    if (m1.equals(m2)) {
      System.out.println("true");
    }
  }
  return false;
}
```

### 객체 해시코드, hashCode()
