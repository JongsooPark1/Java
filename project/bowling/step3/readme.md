## bowling-step3
---

### requirement

예외 처리 추가

### output

```
플레이어 이름은(3 english letters)?: PJS
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |      |      |      |      |      |      |      |      |      |      |
|      |      |      |      |      |      |      |      |      |      |      |

1프레임 투구 : 10
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |      |      |      |      |      |      |      |      |      |
|      |      |      |      |      |      |      |      |      |      |      |

2프레임 투구  : 8
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8   |      |      |      |      |      |      |      |      |
|      |      |      |      |      |      |      |      |      |      |      |

2프레임 투구 : 2
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8|/ |      |      |      |      |      |      |      |      |
|      |  20  |      |      |      |      |      |      |      |      |      |

3프레임 투구 : 8
| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |
|  PJS |  X   |  8|/ |   8  |      |      |      |      |      |      |      |
|      |  20  |  38  |      |      |      |      |      |      |      |      |
```


### analysis

평소 리팩토링에 시간을 많이 들이고 기능 구현 자체에는 자신이 있는 편이었지만, 스코어 합산 기능은 처음으로 기능을 구현하는 데에도 꽤 시간이 많이 소요되었다. 왜냐하면 현재 프레임의 스코어 합이 스트라이크, 스페어, 일반의 경우에 따라 이후의 프레임을 추가 합산해야했기 때문이다

리팩토링 과정 중 가장 어려웠던 부분은, 스코어 합산을 위해 frames 인스턴스 변수에서 각각의 스코어를 가져와 합산 하는 방식에서 각 프레임이 가지고 있는 데이터인 스코어를 스스로 합산 하게 전환하는 과정이었다. 데이터를 직접 저장하고 불러와서 사용하는 것보다 각각의 객체가 해야 할 일을 신호로 보내고 직접 해당 기능을 하게 하는 것이 더 좋은 프로그램이라는 것을 알 수 있었다. 이유는 인스턴스 변수를 줄여 코드를 간결하게 할 수 있고, 데이터를 보호하는 데 더 탁월하기 떄문이다. 하지만 method 실행 마다 각 프레임별로 새롭게 변수를 생성해 처리하는 방법은 메모리 측면에서 비효율 적인 부분도 있다. 그럼에도 전자가 더 객체지향적 프로그래밍이라는 것을 알 수 있었다

추가적으로 처음의 코드는 Frame과 FrameTen class를 만들어 상속 관계를 적용 시켰다. 하지만 이후에 Frame이라는 abstract class를 구현하고 NormalFrame과 FrameTen이라는 자식 클래스를 만들어 상속시키도록 설계하였다. 기능을 구현하는 데에는 두 가지 방법 모두 문제가 없다. 하지만 각 class에 개별성을 주는 데에는 두 번째 방법이 더 탁월하다. 예를 들어 첫 번째 설계 방법에서 부모 class인 Frame class 내의 메소드를 부모 클래스 및 자식 클래스에서 사용한다고 가정하자. 만약 이 메소드가 변경되는 경우 자식 클래스인 FrameTen은 기존의 메소드를 재사용할 수 없어 override를 필수적으로 또 한 번 해줘야 한다. 하지만 후자의 방법에선 NormalFrame과 FrameTen이 각각 개별성을 갖을 수 있기 때문에 메소드가 변경이 되더라도 변경이 필요한 객체에만 적용시키면 된다. 객체가 다양해지고 새롭게 추가 될 수 있는 경우가 비일비재하기 때문에 후자의 방법을 습관적으로 사용하는 것이 더 유리하다. 이는 interface로 연결되며 java의 특장점 중 하나인 다형성을 구현하는데 더 좋은 방법이 될 수 있다
