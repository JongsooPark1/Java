## lotto-step2
---

> 당첨 통계 내용 중, 2등 (번호 5개 일치, 보너스 번호 일치) 추가
>
> enum Match 적용

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
5개 일치, 보너스번호 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

### analysis

* enum 적용

> 상수 값이 많은 경우 enum 적용한다. 자세한 내용은 study directory 내부 enum 참조에 정리해두었음

```java
// Match.java

public enum Match {
	MATCH3(3, false, "", 5000),
	MATCH4(4, false, "", 50000),
	MATCH5(5, false, "", 1500000),
	MATCH6(5, true, "보너스 번호 일치, ",30000000),
	MATCH7(6, false, "", 2000000000);

	int matchingCount;
	boolean bonusTag;
	String bonus;
	int prize;

	private Match(int matchingCount, boolean bonusTag, String bonus, int prize) {
		this.matchingCount = matchingCount;
		this.bonusTag = bonusTag;
		this.bonus = bonus;
		this.prize = prize;
	}

	public static Match findMatch(int matchingCount, boolean bonusTag) {
		for (Match eachMatch : Match.values()) {
			if (matchingCount == MATCH5.matchingCount && bonusTag) {
				return MATCH6;
			}
			if (eachMatch.matchingCount == matchingCount) {
				return eachMatch;
			}
		}
		return null;
	}
}
```

* Lottos Class 생성

> 기존의 Lotto Class에서 Lottos Class를 따로 생성하고 인스턴스 메소드를 이용하였다
>
> 파라미터 개수를 줄일 수 있었고, code 양도 줄어들었다. 그리고 code 읽기가 수월해졌음

```java
// Lottos.java
public class Lottos {

	List<Lotto> lottos;

	Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	List<Match> createMatches(List<Integer> winningLotto, int bonusNumber) {
		List<Match> matches = new ArrayList<>();
		for (Lotto eachLotto : this.lottos) {
			int matchingCount = eachLotto.makeMatchingCount(winningLotto);
			boolean bonusTag = eachLotto.makeMatchingBonusTag(bonusNumber);
			Match match = Match.findMatch(matchingCount, bonusTag);
			if (match != null) {
				matches.add(match);				
			}
		}
		return matches;
	}
}
```

* StatisticsSet Class 생성

> 기존의 Statistics Class에서 StaticsSet Class를 따로 생성하고 인스턴스 메소드를 이용하였다
>
> 파라미터 개수를 줄일 수 있었고, code 양도 줄어들었다. 그리고 code 읽기가 수월해졌음

```java
// StatisticsSet.java
public class StatisticsSet {

	List<Statistics> statisticsSet;

	StatisticsSet(List<Statistics> statisticsSet) {
		this.statisticsSet = statisticsSet;
	}

	double makeRateOfReturn(int money) {
		int sum = 0;
		for (Statistics eachStatistics : this.statisticsSet) {
			sum += eachStatistics.matchingTicketNum * eachStatistics.match.prize;
		}
		return (1.0 * sum / money) * 100;
	}

}
```
