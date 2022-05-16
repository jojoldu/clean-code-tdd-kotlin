# (Kotlin) 단일 함수만 존재하는 경우 파일명은 어떻게 해야할까?

NextStep의 [이펙티브 코틀린 with TDD, Refactoring, Clean Code](https://edu.nextstep.camp/c/Z9QeJlCi/) 을 수강중이다.  

> 내가 작성한 코드에 대해 이렇게 많이 리뷰 받는게 얼마만인지 모르겠다.  

이번에 받은 리뷰중에서는 납득이 잘 안되는게 있어서 리뷰어이신 재성님(Jason) 과 이런저런 토론을 진행했었다.  

## 토론(리뷰) 대상

토론 대상인 코드는 다음과 같다.

```kotlin
fun main() {
    val raceGame = RaceGame(InputView(ReadInInput()), OutputView(PrintOutput()))
    raceGame.run()
}
```

public 함수 하나(`main`)만 존재하기 때문에 파일명을 `main.kt`로 만들었다.  
  
이에 대한 리뷰가 진행되었는데, 재성님 생각으로는 파일은 전부 PascalCase를 쓰는게 좋다는 의견이셨다.

![review1](./images/review1.png)

* [Kotlin Convention](https://kotlinlang.org/docs/coding-conventions.html#source-file-names)

근데 내 생각으로는 **public 함수만 존재하는 경우** (private 함수는 관계 없이) 오히려 그 함수를 나타내는 파일명이 더 좋지않나? 라는 생각이였다.

> 실제로 지금 JS/TS 프로젝트에서 그렇게 하고 있고 좋다고 느꼈기 때문이다.

![slack1](./images/slack1.png)

재성님과 이야기 나누면서 확실하게 미리 서로 정리하고 진행한 부분은 다음과 같다

* 꼭 클래스나 함수명에 맞춰서 파일명을 지을 필요는 없다.
* 해당 파일의 코드들이 **무엇을 다루는가에 따라 이름을 지어야 한다**



그래서 서로 그런 케이스가 없는지 Kotlin의 `stdlib` 쪽 코드를 살펴봤다.  

## 결론

* public interface (`class`, `function` 등) 들이 **여러개**가 존재하는 경우
  * PascalCase (`Maps.kt`, `Numbers.kt` 등)
* public interface (`class`, `function` 등) 들이 **1개만** 존재하는 경우
  * 해당 interface의 이름과 같은 컨벤션
    * `class`: `ClassName.kt`
    * `function`: `funName.kt`