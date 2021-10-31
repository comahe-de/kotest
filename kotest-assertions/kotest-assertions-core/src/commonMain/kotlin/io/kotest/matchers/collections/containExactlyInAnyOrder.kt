package io.kotest.matchers.collections

import io.kotest.assertions.show.show
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.neverNullMatcher
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot


/**
 * Verifies that the given collection contains all the specified elements and no others, but in any order.
 *
 * For example, each of the following examples would pass for a collection [1,2,3].
 *
 * collection.shouldContainExactlyInAnyOrder(1, 2, 3)
 * collection.shouldContainExactlyInAnyOrder(3, 2, 1)
 * collection.shouldContainExactlyInAnyOrder(2, 1, 3)
 *
 * Note: Comparison is via the standard Java equals and hash code methods.
 *
 * From the javadocs for hashcode: If two objects are equal according to the equals(Object) method,
 * then calling the hashCode method on each of the two objects must produce the same integer result.
 *
 */
infix fun <T> Array<T>.shouldContainExactlyInAnyOrder(expected: Array<T>): Array<T> {
   asList().shouldContainExactlyInAnyOrder(expected.asList())
   return this
}

/**
 * Verifies that the given collection contains all the specified elements and no others, but in any order.
 *
 * For example, each of the following examples would pass for a collection [1,2,3].
 *
 * collection.shouldContainExactlyInAnyOrder(1, 2, 3)
 * collection.shouldContainExactlyInAnyOrder(3, 2, 1)
 * collection.shouldContainExactlyInAnyOrder(2, 1, 3)
 *
 * Note: Comparison is via the standard Java equals and hash code methods.
 *
 * From the javadocs for hashcode: If two objects are equal according to the equals(Object) method,
 * then calling the hashCode method on each of the two objects must produce the same integer result.
 *
 */
infix fun <T, C : Collection<T>> C?.shouldContainExactlyInAnyOrder(expected: Collection<T>?): C? {
   expected.shouldNotBeNull()
   this should containExactlyInAnyOrder(expected)
   return this
}

/**
 * Verifies that the given collection contains all the specified elements and no others, but in any order.
 *
 * For example, each of the following examples would pass for a collection [1,2,3].
 *
 * collection.shouldContainExactlyInAnyOrder(1, 2, 3)
 * collection.shouldContainExactlyInAnyOrder(3, 2, 1)
 * collection.shouldContainExactlyInAnyOrder(2, 1, 3)
 *
 * Note: Comparison is via the standard Java equals and hash code methods.
 *
 * From the javadocs for hashcode: If two objects are equal according to the equals(Object) method,
 * then calling the hashCode method on each of the two objects must produce the same integer result.
 *
 */
fun <T, C : Collection<T>> C?.shouldContainExactlyInAnyOrder(vararg expected: T): C? {
   this should containExactlyInAnyOrder(*expected)
   return this
}

/**
 * Verifies that the given collection contains all the specified elements and no others, but in any order.
 *
 * For example, each of the following examples would pass for a collection [1,2,3].
 *
 * collection.shouldContainExactlyInAnyOrder(1, 2, 3)
 * collection.shouldContainExactlyInAnyOrder(3, 2, 1)
 * collection.shouldContainExactlyInAnyOrder(2, 1, 3)
 *
 * Note: Comparison is via the standard Java equals and hash code methods.
 *
 * From the javadocs for hashcode: If two objects are equal according to the equals(Object) method,
 * then calling the hashCode method on each of the two objects must produce the same integer result.
 *
 */
fun <T> containExactlyInAnyOrder(vararg expected: T): Matcher<Collection<T>?> =
   containExactlyInAnyOrder(expected.asList())


fun ByteArray?.containExactlyInAnyOrder(vararg expected: Byte) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun ByteArray?.containExactlyInAnyOrder(expected: ByteArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun CharArray?.containExactlyInAnyOrder(vararg expected: Char) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun CharArray?.containExactlyInAnyOrder(expected: CharArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun ShortArray?.containExactlyInAnyOrder(vararg expected: Short) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun ShortArray?.containExactlyInAnyOrder(expected: ShortArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun IntArray?.containExactlyInAnyOrder(vararg expected: Int) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun IntArray?.containExactlyInAnyOrder(expected: IntArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun LongArray?.containExactlyInAnyOrder(vararg expected: Long) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun LongArray?.containExactlyInAnyOrder(expected: LongArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun FloatArray?.containExactlyInAnyOrder(vararg expected: Float) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrderA")
infix fun FloatArray?.containExactlyInAnyOrder(expected: FloatArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun DoubleArray?.containExactlyInAnyOrder(vararg expected: Double) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrderA")
infix fun DoubleArray?.containExactlyInAnyOrder(expected: DoubleArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

fun BooleanArray?.containExactlyInAnyOrder(vararg expected: Boolean) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("containExactlyInAnyOrder_array")
infix fun BooleanArray?.containExactlyInAnyOrder(expected: BooleanArray) =
    this?.asList() should containExactlyInAnyOrder(expected.asList())

infix fun <T> Array<T>.shouldNotContainExactlyInAnyOrder(expected: Array<T>): Array<T> {
   asList().shouldNotContainExactlyInAnyOrder(expected.asList())
   return this
}

infix fun <T, C : Collection<T>> C?.shouldNotContainExactlyInAnyOrder(expected: Collection<T>?): C? {
   expected.shouldNotBeNull()
   this shouldNot containExactlyInAnyOrder(expected)
   return this
}

fun <T, C : Collection<T>> C?.shouldNotContainExactlyInAnyOrder(vararg expected: T): C? {
   this shouldNot containExactlyInAnyOrder(*expected)
   return this
}

/** Assert that a collection contains exactly the given values and nothing else, in any order. */
fun <T, C : Collection<T>> containExactlyInAnyOrder(expected: C): Matcher<C?> = neverNullMatcher { value ->
   val valueGroupedCounts: Map<T, Int> = value.groupBy { it }.mapValues { it.value.size }
   val expectedGroupedCounts: Map<T, Int> = expected.groupBy { it }.mapValues { it.value.size }
   val passed = expectedGroupedCounts.size == valueGroupedCounts.size
      && expectedGroupedCounts.all { valueGroupedCounts[it.key] == it.value }

   MatcherResult(
      passed,
      { "Collection should contain ${expected.show().value} in any order, but was ${value.show().value}" },
      { "Collection should not contain exactly ${expected.show().value} in any order" }
   )
}
