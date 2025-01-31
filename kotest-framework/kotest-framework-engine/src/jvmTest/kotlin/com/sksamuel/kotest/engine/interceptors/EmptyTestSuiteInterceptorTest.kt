package com.sksamuel.kotest.engine.interceptors

import io.kotest.common.ExperimentalKotest
import io.kotest.common.KotestInternal
import io.kotest.core.config.Configuration
import io.kotest.core.descriptors.append
import io.kotest.core.descriptors.toDescriptor
import io.kotest.core.names.TestName
import io.kotest.core.sourceRef
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.core.test.TestType
import io.kotest.engine.EngineResult
import io.kotest.engine.interceptors.EmptyTestSuiteException
import io.kotest.engine.interceptors.EmptyTestSuiteInterceptor
import io.kotest.engine.interceptors.EngineContext
import io.kotest.matchers.collections.shouldHaveSize
import kotlin.time.Duration

@ExperimentalKotest
@KotestInternal
class EmptyTestSuiteInterceptorTest : FunSpec() {
   init {

      test("should error on empty test suite") {
         val conf = Configuration()
         conf.failOnEmptyTestSuite = true
         val result =
            EmptyTestSuiteInterceptor.intercept(EngineContext.empty.withConfiguration(conf)) { EngineResult.empty }
         result.errors.filterIsInstance<EmptyTestSuiteException>().shouldHaveSize(1)
      }

      test("should not error on non empty test suite") {

         val tc = TestCase(
            EmptyTestSuiteInterceptorTest::class.toDescriptor().append("foo"),
            TestName("foo"),
            EmptyTestSuiteInterceptorTest(),
            {},
            sourceRef(),
            TestType.Test
         )

         val conf = Configuration()
         conf.failOnEmptyTestSuite = true
         val result = EmptyTestSuiteInterceptor.intercept(
            EngineContext.empty.withConfiguration(conf)
         ) {
            it.listener.testFinished(tc, TestResult.Success(Duration.ZERO))
            EngineResult.empty
         }
         result.errors.filterIsInstance<EmptyTestSuiteException>().shouldHaveSize(0)
      }
   }
}
