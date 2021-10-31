package io.kotest.matchers.collections

import io.kotest.assertions.AssertionsConfig
import io.kotest.assertions.eq.eq
import io.kotest.assertions.show.Printed
import io.kotest.assertions.show.show
import io.kotest.matchers.ComparableMatcherResult
import io.kotest.matchers.Matcher
import io.kotest.matchers.MatcherResult
import io.kotest.matchers.neverNullMatcher
import io.kotest.matchers.should
import io.kotest.matchers.shouldNot
import kotlin.jvm.JvmName

/**
 * Verifies that this collection contains the sub collections provided in the exact given order.
 *
 * So, for example, listOf(1,2,3) contains exactly the sub collections:
 *
 * [], [1], [2], [3], [1,2], [2,3] and [1,2,3].
 *
 */
@JvmName("shouldContainExactly_iterable")
infix fun <T> Iterable<T>?.shouldContainExactly(expected: Iterable<T>) =
   this?.toList() should containExactly(expected.toList())

@JvmName("shouldContainExactly_array")
infix fun <T> Array<T>?.shouldContainExactly(expected: Array<T>) =
   this?.asList() should containExactly(*expected)

fun <T> Iterable<T>?.shouldContainExactly(vararg expected: T) =
   this?.toList() should containExactly(*expected)

fun <T> Array<T>?.shouldContainExactly(vararg expected: T) =
   this?.asList() should containExactly(*expected)

fun ByteArray?.shouldContainExactly(vararg expected: Byte) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun ByteArray?.shouldContainExactly(expected: ByteArray) =
   this?.asList() should containExactly(expected.asList())

fun CharArray?.shouldContainExactly(vararg expected: Char) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun CharArray?.shouldContainExactly(expected: CharArray) =
   this?.asList() should containExactly(expected.asList())

fun ShortArray?.shouldContainExactly(vararg expected: Short) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun ShortArray?.shouldContainExactly(expected: ShortArray) =
   this?.asList() should containExactly(expected.asList())

fun IntArray?.shouldContainExactly(vararg expected: Int) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun IntArray?.shouldContainExactly(expected: IntArray) =
   this?.asList() should containExactly(expected.asList())

fun LongArray?.shouldContainExactly(vararg expected: Long) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun LongArray?.shouldContainExactly(expected: LongArray) =
   this?.asList() should containExactly(expected.asList())

fun FloatArray?.shouldContainExactly(vararg expected: Float) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactlyA")
infix fun FloatArray?.shouldContainExactly(expected: FloatArray) =
   this?.asList() should containExactly(expected.asList())

fun DoubleArray?.shouldContainExactly(vararg expected: Double) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactlyA")
infix fun DoubleArray?.shouldContainExactly(expected: DoubleArray) =
   this?.asList() should containExactly(expected.asList())

fun BooleanArray?.shouldContainExactly(vararg expected: Boolean) =
   this?.asList() should containExactly(expected.asList())

@JvmName("shouldContainExactly_array")
infix fun BooleanArray?.shouldContainExactly(expected: BooleanArray) =
   this?.asList() should containExactly(expected.asList())

infix fun <T, C : Collection<T>> C?.shouldContainExactly(expected: C) = this should containExactly(expected)
fun <T> Collection<T>?.shouldContainExactly(vararg expected: T) = this should containExactly(*expected)

fun <T> containExactly(vararg expected: T): Matcher<Collection<T>?> = containExactly(expected.asList())

/** Assert that a collection contains exactly the given values and nothing else, in order. */
fun <T, C : Collection<T>> containExactly(expected: C): Matcher<C?> = neverNullMatcher { actual ->

   val passed = eq(actual, expected, strictNumberEq = true) == null

   val failureMessage = {

      val missing = expected.filterNot { actual.contains(it) }
      val extra = actual.filterNot { expected.contains(it) }

      val sb = StringBuilder()
      sb.append("Expecting: ${expected.printed().value} but was: ${actual.printed().value}")
      sb.append("\n")
      if (missing.isNotEmpty()) {
         sb.append("Some elements were missing: ")
         sb.append(missing.printed().value)
         if (extra.isNotEmpty()) {
            sb.append(" and some elements were unexpected: ")
            sb.append(extra.printed().value)
         }
      } else if (extra.isNotEmpty()) {
         sb.append("Some elements were unexpected: ")
         sb.append(extra.printed().value)
      }
      sb.toString()
   }

   val negatedFailureMessage = { "Collection should not contain exactly ${expected.printed().value}" }

   if (actual.size <= AssertionsConfig.maxCollectionEnumerateSize && expected.size <= AssertionsConfig.maxCollectionEnumerateSize) {
      ComparableMatcherResult(
         passed,
         failureMessage,
         negatedFailureMessage,
         actual.show().value,
         expected.show().value,
      )
   } else {
      MatcherResult(
         passed,
         failureMessage,
         negatedFailureMessage,
      )
   }
}

@JvmName("shouldNotContainExactly_iterable")
infix fun <T> Iterable<T>?.shouldNotContainExactly(expected: Iterable<T>) = this?.toList() shouldNot containExactly(expected.toList())

@JvmName("shouldNotContainExactly_array")
infix fun <T> Array<T>?.shouldNotContainExactly(expected: Array<T>) = this?.asList() shouldNot containExactly(*expected)

fun <T> Iterable<T>?.shouldNotContainExactly(vararg expected: T) = this?.toList() shouldNot containExactly(*expected)
fun <T> Array<T>?.shouldNotContainExactly(vararg expected: T) = this?.asList() shouldNot containExactly(*expected)

fun ByteArray?.shouldNotContainExactly(vararg expected: Byte) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun ByteArray?.shouldNotContainExactly(expected: ByteArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun CharArray?.shouldNotContainExactly(vararg expected: Char) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun CharArray?.shouldNotContainExactly(expected: CharArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun ShortArray?.shouldNotContainExactly(vararg expected: Short) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun ShortArray?.shouldNotContainExactly(expected: ShortArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun IntArray?.shouldNotContainExactly(vararg expected: Int) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun IntArray?.shouldNotContainExactly(expected: IntArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun LongArray?.shouldNotContainExactly(vararg expected: Long) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun LongArray?.shouldNotContainExactly(expected: LongArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun FloatArray?.shouldNotContainExactly(vararg expected: Float) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactlyA")
infix fun FloatArray?.shouldNotContainExactly(expected: FloatArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun DoubleArray?.shouldNotContainExactly(vararg expected: Double) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactlyA")
infix fun DoubleArray?.shouldNotContainExactly(expected: DoubleArray) =
    this?.asList() shouldNot containExactly(expected.asList())

fun BooleanArray?.shouldNotContainExactly(vararg expected: Boolean) =
    this?.asList() shouldNot containExactly(expected.asList())

@JvmName("shouldNotContainExactly_array")
infix fun BooleanArray?.shouldNotContainExactly(expected: BooleanArray) =
    this?.asList() shouldNot containExactly(expected.asList())

infix fun <T, C : Collection<T>> C?.shouldNotContainExactly(expected: C) = this shouldNot containExactly(expected)
fun <T> Collection<T>?.shouldNotContainExactly(vararg expected: T) = this shouldNot containExactly(*expected)

fun <T, C : Collection<T>> C.printed(): Printed {
   val expectedPrinted = take(20).joinToString(",\n  ", prefix = "[\n  ", postfix = "\n]") { it.show().value }
   val expectedMore = if (size > 20) " ... (plus ${size - 20} more)" else ""
   return Printed("$expectedPrinted$expectedMore")
}
