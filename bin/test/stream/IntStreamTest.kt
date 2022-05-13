package stream

import io.kotest.core.spec.style.AnnotationSpec

class IntStreamTest: AnnotationSpec() {

  @Test
  fun `IntStream 대체`() {
    val orders = (1 until 3)
      .map { Order(it * 1000) }

  }
}

class Order(val amount:Int)