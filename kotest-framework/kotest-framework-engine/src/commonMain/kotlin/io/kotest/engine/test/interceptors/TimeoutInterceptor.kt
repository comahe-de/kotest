package io.kotest.engine.test.interceptors

import io.kotest.core.config.Configuration
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestScope
import io.kotest.core.test.TestResult
import io.kotest.engine.test.scopes.withCoroutineContext
import io.kotest.engine.test.resolvedTimeout
import io.kotest.mpp.log
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withTimeout
import kotlin.time.Duration
import kotlin.time.milliseconds

/**
 * A [TestExecutionInterceptor] that installs a general timeout for all invocations of a test.
 */
internal class TimeoutInterceptor(
   private val configuration: Configuration
) : TestExecutionInterceptor {

   override suspend fun intercept(
      test: suspend (TestCase, TestScope) -> TestResult
   ): suspend (TestCase, TestScope) -> TestResult = { testCase, context ->

      // this timeout applies to the test itself. If the test has multiple invocations then
      // this timeout applies across all invocations. In other words, if a test has invocations = 3,
      // each test takes 300ms, and a timeout of 800ms, this would fail, becauase 3 x 300 > 800.
      val timeout = resolvedTimeout(testCase, configuration.timeout.milliseconds)
      log { "TimeoutInterceptor: Test '${testCase.name.testName}' will execute with timeout ${timeout}ms" }

      try {
         log { "TimeoutInterceptor: Switching context to add timeout $timeout" }
         withTimeout(timeout) {
            test(testCase, context.withCoroutineContext(coroutineContext))
         }
      } catch (e: TimeoutCancellationException) {
         log { "TimeoutInterceptor: Caught TimeoutCancellationException ${e.message} for '${testCase.descriptor.path().value}'" }
         throw TestTimeoutException(timeout, testCase.name.testName)
      }
   }
}

/**
 * Exception used for when a test exceeds its timeout.
 */
open class TestTimeoutException(val timeout: Duration, val testName: String) :
   Exception("Test '${testName}' did not complete within $timeout")
