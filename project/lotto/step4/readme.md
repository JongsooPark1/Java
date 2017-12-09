## lotto-step4
---

> 상속 적용해 중복되어 있는 코드 줄이기

### output

```
구입금액을 입력해 주세요.
14000
수동으로 구매할 번호를 입력해 주세요.
8, 21, 23, 41, 42, 43
3, 5, 11, 16, 32, 38
7, 11, 16, 35, 36, 44

수동으로 3장, 자동으로 11개를 구매했습니다.
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
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```


### analysis

* Lotto 클래스를 부모클래스로 지정

```java
// Lotto.java
public class Lotto {

	List<Integer> numbers;

	Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}
}

```

* UserLotto 클래스가 Lotto 클래스를 상속

```java
// UserLotto.java
public class UserLotto extends Lotto {

	UserLotto(List<Integer> numbers) {
		super(numbers);
	}

	int makeMatchingCount(List<Integer> winningLotto) {
		int matchingCount = 0;
		for (Integer number : winningLotto) {
			if (this.numbers.contains(number)) {
				matchingCount++;
			}
		}
		return matchingCount;
	}

	boolean makeMatchingBonusTag(int bonusNumber) {
		return this.numbers.contains(bonusNumber);
	}

	static List<Integer> makeNumbers() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 1; i <= 45; i++) {
			numbers.add(i);
		}
		return numbers;
	}

	private static List<Integer> createLottoNumbers() {
		List<Integer> numbers = makeNumbers();
		Collections.shuffle(numbers);
		List<Integer> userLotto = numbers.subList(0, 6);
		Collections.sort(userLotto);
		return userLotto;
	}

	static List<UserLotto> createLottos(int howManyManual, int howManyAuto) {
		List<UserLotto> lottos = new ArrayList<>();
		for (int i = 0; i < howManyManual; i++) {
			lottos.add(new UserLotto(Input.inputManualLotto()));
		}
		for (int i = 0; i < howManyAuto; i++) {
			lottos.add(new UserLotto(createLottoNumbers()));
		}
		return lottos;
	}
}
```

* WinningLotto 클래스가 Lotto 클래스를 상속

```java
// WinningLotto.java
public class WinningLotto extends Lotto{

	WinningLotto(List<Integer> numbers) {
		super(numbers);
	}

	static List<Integer> getWinningLotto() {
		String inputNum = Input.inputWinningLotto();
		String[] splittedInputNum = makeArray(inputNum);
		List<Integer> winningLotto = new ArrayList<>();
		for (String number : splittedInputNum) {
			winningLotto.add(Integer.parseInt(number));
		}
		if ( !checkLottoNumRange(winningLotto) ) {
			return getWinningLotto();
		}
		return winningLotto;
	}

	private static String[] makeArray(String inputNum) {
		String[] splittedInputNum = inputNum.split(",");
		if (splittedInputNum.length != 6) {
			System.out.println("1 ~ 45 중 6개의 숫자를 골라주세요!");
			return makeArray(Input.inputWinningLotto());
		}
		return splittedInputNum;
	}

	private static boolean checkLottoNumRange(List<Integer> winningLotto) {
		for (int numbers : winningLotto) {
			if (!(UserLotto.makeNumbers().contains(numbers))) {
				return false;
			}
		}
		return true;
	}
}

```
