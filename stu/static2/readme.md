## Static
---

### instance method  VS  class method(static method)

*instance field*

> 객체마다 그 값이 다르다면 instatnce field

*static field*

> 공용적인 데이터

*instance method*

> intstance field에 영향을 주는 함수는 instance method로 사용한다
>
> instance를 생성한 뒤에 사용할 수 있다
>
> instance method내부에서는 instance method를 호출할 수 있다


*class method*

> intstance field에 영향을 주지 않고 어떤 기능을 구현하고자 할 때 class method를 사용한다
>
> instance를 생성하지 않고 바로 사용할 수 있다
>
> 외부 클래스의 class method를 사용할 경우, Class.method()로 사용한다
>
> static method 내부에서는 static method만 사용 가능하다


[static을 지양해야하는 이유](http://tech.thegajago.com/2016/02/20/%EC%99%9C-%EC%9E%90%EB%B0%94%EC%97%90%EC%84%9C-static%EC%9D%98-%EC%82%AC%EC%9A%A9%EC%9D%84-%EC%A7%80%EC%96%91%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94%EA%B0%80/)
