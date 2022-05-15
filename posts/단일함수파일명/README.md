# (Kotlin) 단일 함수만 존재하는 경우 파일명은 어떻게 해야할까?

NextStep의 [이펙티브 코틀린 with TDD, Refactoring, Clean Code](https://edu.nextstep.camp/c/Z9QeJlCi/) 을 수강중이다.  


```kotlin
fun main() {
    val raceGame = RaceGame(InputView(ReadInInput()), OutputView(PrintOutput()))
    raceGame.run()
}
```

그래서 서로 그런 케이스가 없는지 Kotlin의 `stdlib` 쪽 코드를 살펴봤다.  

## 결론

* public interface (`class`, `function` 등) 들이 **여러개**가 존재하는 경우
  * PascalCase (`Maps.kt`, `Numbers.kt` 등)
* public interface (`class`, `function` 등) 들이 **1개만** 존재하는 경우
  * 해당 interface의 이름과 같은 컨벤션
    * `class`: `ClassName.kt`
    * `function`: `funName.kt`