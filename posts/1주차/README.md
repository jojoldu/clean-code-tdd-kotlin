# 1주차 - 이펙티브 코틀린 with TDD, Refactoring, Clean Code


## 코드리뷰

코틀린의 Contracts(since 1.3)과 관련된 삽질을 하다 보니 리뷰가 늦었네요. :man-bowing:
코틀린 API 외 개발자가 직접 만드는 API에서는 해당 기능이 실험 버전인데요. 실험 버전이라 당장 쓰기 보다 이걸 우회(?)하는 방식으로 개발을 많이 했던 것 같아요. 

```kotlin
fun calculate(expression: String?): Int {
    require(!expression.isNullOrEmpty()) { "빈문자열은 입력될 수 없습니다." }
    return splitAndCalculate(expression)
}


private fun splitAndCalculate(expression: String): Int {
    val elements = expression.split(" ").groupBy { isNumeric(it) }
    // 중략
```


이번 과정은 코틀린 1.6 버전을 사용하는데요. ‘아직도 계약 기능이 실험 버전이야?’라는 생각에 현재 동욱님의 함수 분리를 건드리지 않고 수정하는 방법을 연구해 보았어요. @ExperimentalContracts을 사용하면 해결이 가능하지만 상위 호출 함수에도 똑같이 붙여 줘야 하는 등 여전히 불편함이 남아 있더라고요. 코틀린에는 이러한 기능이 있다고 알려만 :kkk: 드리며 이번 문자열 계산기 리뷰는 마무리하도록 하겠습니다!

```kotlin
@ExperimentalContracts
private fun validate(expression: String?) {
    contract {
        returns() implies (expression != null)
    }

    if (expression.isNullOrEmpty()) {
        throw IllegalArgumentException("빈문자열은 입력될 수 없습니다.")
    }
}

```

* https://kotlinlang.org/docs/typecasts.html#is-and-is-operators
* https://kotlinlang.org/docs/whatsnew13.html#contracts
* https://www.baeldung.com/kotlin/contracts


### 자동차게임 리뷰

#### lazy init

```kotlin
    val carCount: Int by lazy { askCarCount() }
    val tryCount: Int by lazy { askTryCount() }
```

#### List

```kotlin
    constructor(carCount: Int) : this(List(carCount) { Car() })
```

* https://github.com/next-step/kotlin-racingcar/pull/522#discussion_r871959524
* https://github.com/next-step/kotlin-racingcar/pull/522#discussion_r871959812
* https://github.com/next-step/kotlin-racingcar/pull/522#discussion_r871959564
* https://github.com/next-step/kotlin-racingcar/pull/522#discussion_r871959655