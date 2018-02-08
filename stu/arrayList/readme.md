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

// 배열 집어 넣기
List<Integer> another = Arrays.asList(1, 2, 3, 4, 5, 6);

// 리스트 집어 넣기
list.addAll(anotherList);

// 값 존재 여부 확인, return은 true or false
list.contains(1);

// list중 1번 index부터 2번 index전까지 빼낸 값을 list type으로 return
list.sublist(1,2);

// 정렬, 오름차순
Collections.sort(list);

// 최대값
Collections.max(list);

// 최소값
Collections.min(list);

// 값 초기화
Collections.fill(list, obj);

// 초기 크기 설정하고 싶은 경우
// 용량(capacity) : 초기 크기, 10으로 설정되어 있으며, arrayList의 크기가 10 이상이 되는 순간 부터 다시 10 단위로 커진다
List<Integer> list = Arrays.asList(new Integer[10]);
```
