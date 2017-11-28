## enum 클래스
---

> 클래스처럼 보이게 하는 상수
>
> 서로 관련 있는 상수들을 모아 심볼릭한 명칭의 집합으로 정의한 것
>
> Enum 클래스형을 기반으로 한 클래스형 선언
>
> 새로운 열거형을 선언하면, 내부적으로 Enum 클래스형 기반의 새로운 클래스형이 만들어짐


### 열거형 사용하기

1) 하나의 java 파일로 선언하기

```java
//Type.java
public enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
```
```java
//Shoes.java
public class Shoes {
    public String name;
    public int size;
    public Type type;
}
```

2) 클래스 안에서 선언하기

```java
//Shoes.java
public class Shoes {
    public String name;
    public int size;
    public enum Type {
        WALKING, RUNNING, TRACKING, HIKING   
    }
}
```

3) 클래스 밖에서 선언하기

```java
//Shoes.java
enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
public class Shoes {
    public String name;
    public int size;
    public Type type;
}
```

열거된 순서에 따라 0 부터 순서값을 가짐. 차례대로 증가함

enum 열거형으로 지정된 상수는 대문자 사용

마지막 끝에 세미콜론(;)을 붙이지 않음


### 사용하기

```java
//Shoes.java
enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
public class Shoes {
    public String name;
    public int size;
    public Type type;

    public static void main(String[] args) {
        Shoes shoes = new Shoes();

        shoes.name = "나이키";
        shoes.size = 230;
        shoes.type = Type.RUNNING;

        System.out.println("신발 이름 = " + shoes.name);
        System.out.println("신발 사이즈 = " + shoes.size);
        System.out.println("신발 종류 = " + shoes.type);
    }
}
```

output

신발 이름 = 나이키

신발 사이즈 = 230

신발 종류 = RUNNING

### 메소드

1) values() : 열거된 모든 원소를 배열에 담아 순서대로 반환

```java
enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
public class Shoes {
    public String name;
    public int size;
    public Type type;

    public static void main(String[] args) {
        for(Type type : Type.values()) {
            System.out.println(type);
        }
    }
}
```

output

WALKING

RUNNING

TRACKING

HIKING

---
2) ordinal() : 원소에 열거된 순서를 정수 값으로 반환

```java
enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
public class Shoes {
    public String name;
    public int size;
    public Type type;

    public static void main(String[] args) {
        Shoes shoes = new Shoes();

        shoes.name = "나이키";
        shoes.size = 230;
        shoes.type = Type.RUNNING;

        System.out.println(shoes.type.ordinal());

        Type tp = Type.HIKING;

        System.out.println(tp.ordinal());
    }
}
```

output

1

3

----
3) valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 반환

(주어진 String과 일치하는 원소가 없는 경우 IllegalArgumentException 예외 발생)

```java
enum Type {
    WALKING, RUNNING, TRACKING, HIKING
}
public class Shoes {

    public static void main(String[] args) {
        Type tp1 = Type.WALKING;
        Type tp2 = Type.valueOf("WALKING");

        System.out.println(tp1);
        System.out.println(tp2);
    }
}
```

output

WALKING

WALKING

< 값 가져오는 방법 >

* enum 형 객체를 만들어서 값 가져오기 -> Type.WALKING;

* valueOf() 메소드를 이용해서 가져오기 -> Type.valueOf("WALKING");


### 열거형 상수를 다른 값과 연결하기

```java
enum Type {
    // 상수("연결할 문자")
    WALKING("워킹화"), RUNNING("러닝화")
    , TRACKING("트래킹화"), HIKING("등산화")

    final private String name;

    private Type(Stirng name) { //enum에서 생성자 같은 역할
        this.name = name;
    }
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
}
public class Shoes {
    public static void main(String[] args) {
        for(Type type : Type.values()){
            System.out.println(type.getName());
        }
    }
}
```

output

워킹화

러닝화

트래킹화

등산화

### 클래스의 static final 이용해서 열거형 선언하기

```java
class Type {
    static final String WALKING = "워킹화";
    static final String RUNNING = "러닝화";
    static final String TRACKING = "트래킹화";
    static final String HIKING = "등산화";
}

public class Shoes {
    public static void main(String[] args) {
        String w = Type.WALKING;
        System.out.println(w);
    }
}
```
output

워킹화
