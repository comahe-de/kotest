package io.kotest.engine

import io.kotest.core.spec.Spec
import io.kotest.core.test.NestedTest
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestContext
import io.kotest.engine.preconditions.ValidateSpec
import io.kotest.engine.spec.materializeAndOrderRootTests
import io.kotest.engine.test.CallingThreadExecutionContext
import io.kotest.engine.test.TeamCityTestCaseExecutionListener
import io.kotest.engine.test.TestCaseExecutor
import io.kotest.engine.test.status.isEnabledInternal
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

data class NativeEngineConfig(
   val validations: List<ValidateSpec>,
)

data class TestSuite(val specs: List<Spec>)

class NativeEngine(private val config: NativeEngineConfig) {
   fun execute(suite: TestSuite) {

      suite.specs.forEach { spec ->
         config.validations.forEach {
            it.invoke(spec::class)
         }
      }

      suite.specs.forEach { spec ->
         runBlocking {
            val runner = SpecRunner()
            runner.execute(spec)
         }
      }
   }
}

class SpecRunner {

   suspend fun execute(spec: Spec) {
      spec.materializeAndOrderRootTests()
         .filter { it.testCase.isEnabledInternal().isEnabled }
         .forEach { execute(it.testCase) }
   }

   private suspend fun execute(testCase: TestCase) = coroutineScope {
      val context = object : TestContext {
         override val testCase: TestCase = testCase
         override val coroutineContext: CoroutineContext = this@coroutineScope.coroutineContext
         override suspend fun registerTestCase(nested: NestedTest) {
            throw IllegalStateException("Spec styles that support nested tests are disabled in kotest-native")
         }
      }
      TestCaseExecutor(TeamCityTestCaseExecutionListener, CallingThreadExecutionContext).execute(testCase, context)
   }
}