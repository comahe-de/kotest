package com.sksamuel.kotest.engine.interceptors

import io.kotest.core.ProjectContext
import io.kotest.core.config.Configuration
import io.kotest.core.projectContext
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.engine.spec.interceptor.ProjectContextInterceptor
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import kotlin.coroutines.coroutineContext

class ProjectContextInterceptorTest : FunSpec() {
   init {

      val c = ProjectContext(Configuration())
      var fired = false
      val fn: suspend (Spec) -> Map<TestCase, TestResult> = {
         fired = true
         coroutineContext.projectContext shouldBe c
         emptyMap()
      }

      test("ProjectContextInterceptor should set project context on coroutine scope") {
         fired.shouldBeFalse()
         ProjectContextInterceptor(c).intercept(fn).invoke(BazSpec())
         fired.shouldBeTrue()
      }
   }
}

private class BazSpec : FunSpec()
