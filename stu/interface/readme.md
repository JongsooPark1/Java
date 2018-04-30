## Interface
---

>  객체의 사용 방법을 정의한 타입으로 다형성을 구현하는데 중요한 역할을 한다

### 구성

##### 상수 필드


인터페이스에 선언된 필드는 모두 상수이며, public static final의 특성을 갖는다

##### 메소드

1. Abstract method

추상 클래스의 추상 메서드와 마찬가지로 {} 붙지 않는다. 차이는 interface에서는 abstract 키워드가 따로 붙지 않는다는 것. 구현 클래스에서 꼭 대응하는 실체 method 작성되어야 한다. 없으면 컴파일 에러

```java
public interface RemoteControl {
  public void turnOn();
  public void turnOff();
}
```

2. Default method (java 8 추가)

default 키워드가 리턴 타입 앞에 붙는다. interface에 선언되지만 사실은 구현 객체가 가지고 있는 instance method라고 생각해야 한다. 존재 이유는 기존 interface를 확장해서 새로운 기능을 추가하기 위해서. 예를 들어 기존의 방법으론 나중에 interface에 메소드를 추가 할 경우, 구현 클래스에도 새로운 메소드를 추가해야 컴파일 에러 발생하지 않는다. 하지만 default method로 추가한다면 구현 클래스에 추가하지 않아도 에러가 발생하지 않는다

```java
default void setMute(boolean mute) {
  if (mute) {
    System.out.println("무음 처리합니다");
  } else {
    System.out.println("무음 해제합니다");
  }
}
```

3. Static method (java 8 추가)

### 구현 클래스

interface에 선언된 abstract method에 대응하는 실체 method를 구현 클래스가 작성하지 않으면, 구현 클래스는 자동적으로 추상 클래스가 된다. 그렇기 때문에 클래스 선언부에 abstract 키워드를 추가해야 한다


### 익명 구현 객체

소스 파일을 만들지 않고도 구현 객체를 만들 수 있는 방법을 제공한다. 람다식은 interface의 익명 구현 객체를 만들기 때문에 코드 패턴을 잘 익혀 둘 필요 있다. 하나의 실행문이므로 끝에는 세미콜론(;) 반드시 필요하다

```java
인터페이스 변수 = new 인터페이스() {
  // 인터페이스에 선언된 추상 메소드의 실체 메소드
};
```

### interface 사용

interface로 구현 객체를 사용하려면 변수를 선언하고 구현 객체를 대입해야 한다. 인터페이스 변수는 참조 타입이기 때문에 구현 객체가 대입될 경우 구현 객체의 번지를 저장한다. abstract method, default method 모두 객체를 대입해야 사용할 수 있고, static method는 인터페이스로 바로 호출이 가능하다

```java
public class RemoteControlExample {
  public static void main(String[] args) {
    RemoteControl rc;
    rc = new Televiwion();
    rc.turnOn();    // 추상 메소드

    rc = new Audio();
    rc.turnOn();    // 추상 메소드
    rc.setMute();   // 디폴트 메소드

    RemoteControl.changeBattery();    // 정적 메소드
  }
}
```

### 자동 타입 변환(Promotion)

인터페이스 : A / 구현 클래스 : B, C / 구현 클래스의 자식 클래스 : D, E

```java
A a1 = new B();
A a2 = new C();
A a3 = new D();
A a4 = new E();
```

구현 객체가 인터페이스 타입으로 변환되는 것

인터페이스 구현 클래스를 상속해서 자식 클래스를 만들었다면 자식 객체 역시 인터페이스 타입으로 자동 타입 변환시킬 수 있다

### 필드의 다형성

interface
```java
public interface Tire {
  public void roll();
}
```
구현 객체 1
```java
public class KumhoTire implements Tire {
  @Override
  roll () {
    System.out.println("금호 타이어가 굴러갑니다");
  }
}
```
구현 객체 2
```java
public class HankookTire implements Tire {
  @Override
  roll () {
    System.out.println("한국 타이어가 굴러갑니다");
  }
}
```
Car 객체 (필드 다형성)
```java
public class Car {
  Tire frontLeftTire = new KumhoTire();
  Tire frontRightTire = new KumhoTire();
  Tire backLeftTire = new KumhoTire();
  Tire blackRightTire = new KumhoTire();
}

public void run() {
  frontLeftTire.roll();
  frontRightTire.roll();
  backLeftTire.roll();
  backRightTire.roll();
}
```

Main
```java
public class Main {
  public static void main(String[] args) {
    Car myCar = new Car();
    myCar.run();
    myCar.frontLeftTire = new HankookTire();
    myCar.frontRightTire = new HankookTire();
    myCar.run();
  }
}
```
출력 결과
```
금호타이어가 달려갑니다
금호타이어가 달려갑니다
금호타이어가 달려갑니다
금호타이어가 달려갑니다
한국타이어가 달려갑니다
한국타이어가 달려갑니다
금호타이어가 달려갑니다
금호타이어가 달려갑니다
```

### 강제 타입 변환 (Casting)

구현 객체가 인터페이스 타입으로 자동 변환하면, 인터페이스에 선언된 메소드만 사용 가능하다는 제약 사항이 따른다. 이때 강제 타입 변환을 통해 다시 구현 클래스로 변환 후, 구현 클래스의 필드와 메소드를 사용할 수 있다

interface
```java
public interface Vehicle {
  public void run();
}
```

구현 객체
```java
public class Bus implements Vehicle {
  @Override
  public void run() {
    System.out.println("버스가 달립니다");
  }

  public void checkFare() {
    System.out.println("승차요금을 체크합니다");
  }
}
```

Main
```java
public class Main {
  public static void main(String[] args) {
    Vehicle vehicle = new Bus();
    vehicle.run();
    //vehicle.checkFare(); 불가능
    Bus bus = (Bus) vehicle;
    bus.run();
    bus.checkFare();  // 가능
  }
}
```

### 객체 타입 확인

어떤 구현 객체가 자동 타입 변환 되어 있는지 알 수 없는 상태에서 강제 타입 변환을 할 경우 ClassCastException발생. 따라서 객체 타입을 확인한다

example
```java
public void drive(Vehicle vehicle) {
  if (vehicle instanceof Bus) {
    Bus bus = (Bus) vehicle;
  }
  bus.checkFare();
}
```

### 인터페이스 상속

인터페이스는 클래스와 달리 다중 상속을 허용한다. 또한 인터페이스가 또 다른 인터페이스를 상속할 수 도 있다

```java
public interface 하위인터페이스 extends 상위인터페이스1, 상위인터페이스2 {
  ...
}
```

하위 인터페이스를 구현하는 클래스는 하위 인터페이스의 메소드뿐만 아니라 상위 인터페이스의 모든 추상 메소드에 대한 실체 메소드를 가지고 있어야 한다. 따라서 다음과 같은 변환 가능하다

```java
하위인터페이스 변수 = new 구현클래스(...);
상위인터페이스1 변수 = new 구현클래스(...);
상위인터페이스2 변수 = new 구현클래스(...);
```
하위 인터페이스로 변환된 경우 상, 하위 인터페이스 선언된 모든 메소드 사용 가능하지만, 상위 인터페이스로 타입 변환되면 상위 인터페이스에 선언된 메소드만 사용 가능하다
