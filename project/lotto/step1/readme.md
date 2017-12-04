## lotto-step1
---

### output
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

### analysis

* 하드코딩하지 않도록 한다

```java
//Input.java
private static final int MONEY_PER_LOTTO = 1000;
```

* 인스턴스 메소드로 해결해야 할 것과 class 메소드로 해결해야 할 것을 나눈다

```java
//Lotto.java
int matchingCount(List<Integer> luckyNumbers) {
		int matchCount = 0;
		for (Integer number : luckyNumbers) {
			if (this.numbers.contains(number)) {
				matchCount++;
			}
		}
		return matchCount;
	}
```

위의 코드는 Statistics 클래스에 있었지만 로직 구현 부분을 lotto로 바꾸면서 Statistics 클래스의 부담을 줄이고, 코드를 좀 더 읽기 쉽게 구현할 수 있었다

* method를 최대한 분리한다

```java
static List<Integer> getLuckyNumber() {
		String input = inputLuckyNumber();
		String[] splittedInput = makeArray(input);
		List<Integer> luckyNumber = new ArrayList<>();
		for (String number : splittedInput) {
			luckyNumber.add(Integer.parseInt(number));
		}
		if ( !checkLottoNo(luckyNumber) ) {
			return getLuckyNumber();
		}
		return luckyNumber;
	}

	private static boolean checkLottoNo(List<Integer> luckyNumber) {
		for (int numbers : luckyNumber) {
			if (!(Lotto.makeNumbers().contains(numbers))) {
				return false;
			}
		}
		return true;
	}

	private static String[] makeArray(String input) {
		String[] splittedInput = input.split(",");
		if (splittedInput.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 골라주세요!");
			return makeArray(inputLuckyNumber());
		}
		return splittedInput;
	}

	private static String inputLuckyNumber() {
		System.out.println("\n지난 주 당첨 번호를 입력해주세요");
		return sc.nextLine();
	}

	static List<Integer> checkLength(String[] splittedInput) {
		System.out.println("1 ~ 45 중 6개의 숫자를 골라주세요!");
		return getLuckyNumber();
	}
```

초기에는 로또 번호를 문자열로 입력받고 리턴하여 문자열을 배열로 만든 뒤에 List<Integer> 타입으로 변형하여 return하는 함수였다

메소드를 분리하고자 하였지만 문자열을 리턴하는 메소드와 List<Integer>타입을 리턴하는 메소드에 각각 재귀를 사용한 예외처리를 집어 넣었기 때문에 리턴타입이 달라 메소드를 분리하기 어려웠다

해결 방법으론, 기존의 하나의 메소드를 불필요하다 싶은 생각이 들정도로 작은 단위로 메소드를 나누었고, 그러다보니 재귀를 사용하여 돌아갈 곳을 찾을 수 있었다
