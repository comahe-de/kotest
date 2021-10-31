package io.kotest.matchers.collections

import io.kotest.assertions.show.show
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.neverNullMatcher
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot
import kotlin.jvm.JvmName


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


fun ByteArray?.shouldContainExactlyInAnyOrder(vararg expected: Byte) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun ByteArray?.shouldContainExactlyInAnyOrder(expected: ByteArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun CharArray?.shouldContainExactlyInAnyOrder(vararg expected: Char) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun CharArray?.shouldContainExactlyInAnyOrder(expected: CharArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun ShortArray?.shouldContainExactlyInAnyOrder(vararg expected: Short) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun ShortArray?.shouldContainExactlyInAnyOrder(expected: ShortArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun IntArray?.shouldContainExactlyInAnyOrder(vararg expected: Int) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun IntArray?.shouldContainExactlyInAnyOrder(expected: IntArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun LongArray?.shouldContainExactlyInAnyOrder(vararg expected: Long) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun LongArray?.shouldContainExactlyInAnyOrder(expected: LongArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun FloatArray?.shouldContainExactlyInAnyOrder(vararg expected: Float) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrderA")
infix fun FloatArray?.shouldContainExactlyInAnyOrder(expected: FloatArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun DoubleArray?.shouldContainExactlyInAnyOrder(vararg expected: Double) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrderA")
infix fun DoubleArray?.shouldContainExactlyInAnyOrder(expected: DoubleArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

fun BooleanArray?.shouldContainExactlyInAnyOrder(vararg expected: Boolean) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

@JvmName("shouldContainExactlyInAnyOrder_array")
infix fun BooleanArray?.shouldContainExactlyInAnyOrder(expected: BooleanArray) =
   this?.asList() should containExactlyInAnyOrder(expected.asList())

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


fun ByteArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Byte) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun ByteArray?.shouldNotContainExactlyInAnyOrder(expected: ByteArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun CharArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Char) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun CharArray?.shouldNotContainExactlyInAnyOrder(expected: CharArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun ShortArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Short) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun ShortArray?.shouldNotContainExactlyInAnyOrder(expected: ShortArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun IntArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Int) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun IntArray?.shouldNotContainExactlyInAnyOrder(expected: IntArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun LongArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Long) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun LongArray?.shouldNotContainExactlyInAnyOrder(expected: LongArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun FloatArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Float) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrderA")
infix fun FloatArray?.shouldNotContainExactlyInAnyOrder(expected: FloatArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun DoubleArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Double) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrderA")
infix fun DoubleArray?.shouldNotContainExactlyInAnyOrder(expected: DoubleArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

fun BooleanArray?.shouldNotContainExactlyInAnyOrder(vararg expected: Boolean) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

@JvmName("shouldNotContainExactlyInAnyOrder_array")
infix fun BooleanArray?.shouldNotContainExactlyInAnyOrder(expected: BooleanArray) =
   this?.asList() shouldNot containExactlyInAnyOrder(expected.asList())

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
