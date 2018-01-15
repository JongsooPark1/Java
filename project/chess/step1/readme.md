## chess-step1
---

### requirement

* chess판 구성하기 - black 말은 알파벳 대문자로, white 말은 알파벳 소문자로 구현
* 각 말로 점수 구현하기 - 각 말 마다 점수를 갖고 있기 때문에 black, white 각각 점수를 나타낼 수 있다

### output
```
RNBQKBNR  8 (rank 8)
PPPPPPPP  7
........  6
........  5
........  4
........  3
pppppppp  2
rnbqkbnr  1 (rank 1)

abcdefgh
```

### analysis

각 말을 객체로 뽑아내어 enum class로 속성 값을 매치시킨다. method 단위로 설계 하여 TDD를 직접적으로 적용해 볼 수 있는 좋은 기회였다
