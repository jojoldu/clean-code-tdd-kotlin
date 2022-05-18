# 코틀린의 Contracts

```kotlin
fun calculate(expression: String?): Int {
    require(!expression.isNullOrEmpty()) { "빈문자열은 입력될 수 없습니다." }
    return splitAndCalculate(expression)
}

private fun splitAndCalculate(expression: String): Int {
    val elements = expression.split(" ").groupBy { isNumeric(it) }
    // 중략
```

이번 과정은 코틀린 1.6 버전을 사용하는데요. ‘아직도 계약 기능이 실험 버전이야?’라는 생각에 현재 동욱님의 함수 분리를 건드리지 않고 수정하는 방법을 연구해 보았어요. @ExperimentalContracts을 사용하면 해결이 가능하지만 상위 호출 함수에도 똑같이 붙여 줘야 하는 등 여전히 불편함이 남아 있더라고요. 

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