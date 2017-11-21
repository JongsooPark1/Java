## for each 문
---

> 배열이나 컬렉션 항목의 개수만큼 반복하고, 자동적으로 for문을 빠져나간다
>
> 기존의 for문에서 index를 사용하지 않는다면 for each문을 쓰는 것이 더 한 눈에 들어온다


```java
int[] scores = {10, 20, 100, 50, 50};
int sum = 0;
for (int score : scores) {
  sum += score;
}
System.out.println("총합 : " + sum);
```

for문의 괄호에는 배열에서 꺼낸 항목을 저장할 변수 선언과 콜론(:) 그리고 배열을 나란히 작성한다

배열에서 가져올 항목을 다 가져왔다면 for문 종료. 따라서 반복 횟수는 배열 또는 컬렉션의 크기와 동일하다
