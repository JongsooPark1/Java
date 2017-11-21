## ArrayList
---

> 배열과의 가장 큰 차이는 사용중 크기를 변경할 수 있다는 점이다

### method

```java
List<String> list = new ArrayList<>();

// index 0번 부터 순서대로 객체 추가
list.add("1");              
list.add("2");
list.add("3");

// index 1번에 객체 추가, 뒤의 원소들은 하나씩 index 밀려난다
list.add(1, "4");

// index 2번에 객체를 "5"로 바꾼다
list.set(2, "5");

// index 2번 객체 return
list.get(2);

// list가 비어있는지 조사. return type은 boolean
list.isEmpty();

// list 크기 확인
list.size();

// 저장된 모든 객체 삭제
list.clear();

// index 2번 객체 삭제
list.remove(2);

// "3" 객체 삭제
list.remove("3");
```
