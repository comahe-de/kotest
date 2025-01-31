package com.sksamuel.kotest.engine.spec.style

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration

class WordSpecTest : WordSpec() {

   init {
      "a context" should {
         "have a test" {
            2.shouldBeGreaterThan(1)
         }
         "have another test" {
            2.shouldBeGreaterThan(1)
         }
         "have a test with config".config(enabled = false) {

         }
      }

      "another context" When {

         "using when" Should {
            "have a test" {
               2.shouldBeGreaterThan(1)
            }
            "have a test with config".config(timeout = Duration.milliseconds(10000)) {
                2.shouldBeGreaterThan(1)
            }
         }

      }
      "a context with coroutine in word spec when scope" When {
         launch { delay(1) }
         "a context with coroutine in word spec should scope" Should {
            launch { delay(1) }
            "a dummy test" {

            }
         }
      }
   }
}
