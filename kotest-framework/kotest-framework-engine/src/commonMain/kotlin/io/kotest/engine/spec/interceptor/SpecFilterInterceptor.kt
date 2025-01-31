package io.kotest.engine.spec.interceptor

import io.kotest.core.config.ExtensionRegistry
import io.kotest.core.filter.SpecFilter
import io.kotest.core.filter.SpecFilterResult
import io.kotest.core.spec.SpecRef
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.engine.listener.TestEngineListener
import io.kotest.engine.spec.SpecExtensions
import io.kotest.mpp.log

/**
 * Evaluates a spec against any registered [SpecFilter]s.
 */
class SpecFilterInterceptor(
   private val listener: TestEngineListener,
   private val registry: ExtensionRegistry
) : SpecRefInterceptor {

   private val extensions = SpecExtensions(registry)

   override suspend fun intercept(
      fn: suspend (SpecRef) -> Map<TestCase, TestResult>
   ): suspend (SpecRef) -> Map<TestCase, TestResult> = { ref ->

      val excluded = registry.all().filterIsInstance<SpecFilter>().mapNotNull {
         val result = it.filter(ref.kclass)
         if (result is SpecFilterResult.Exclude) result else null
      }.firstOrNull()

      log { "SpecFilterInterceptor: ${ref.kclass} is excludedByFilters = $excluded" }

      if (excluded == null) {
         fn(ref)
      } else {
         val reason = excluded.reason ?: "Disabled by spec filter"
         listener.specIgnored(ref.kclass, reason)
         extensions.ignored(ref.kclass, reason)
         emptyMap()
      }
   }
}
