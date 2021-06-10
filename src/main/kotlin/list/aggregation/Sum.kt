package list.aggregation

import atomictest.eq
import java.math.BigDecimal

data class Product(
    val id: Long,
    val model: String,
    val price: Double
)

fun Product.getIntPrice() = price.toInt()

fun main() {
    val products = listOf(
        Product(1L, "bread", 2.0),
        Product(2L, "bread", 2.0),
        Product(3L, "wine", 5.0),
        Product(4L, "book", 3.0),
    )

    products.map(Product::price).sum() eq 12.0

    // sumBy() 함수는 Int, sumByDouble()은 Double 타입을 지원함:
    products.sumByDouble(Product::price) eq 12.0
    products.sumBy(Product::getIntPrice) eq 12

    // sumOf() 함수는 코틀린 1.4 부터 지원
    // sumOf() 함수는 Double, Int, Long, UInt, ULong, BigDecimal, BigInteger 타입을 지원함:
    products.sumOf(Product::price) eq 12.0
    products.sumOf(Product::getIntPrice) eq 12
    products.sumOf(Product::id) eq 10L
    products.sumOf { BigDecimal(it.id) } eq BigDecimal(10)
}
