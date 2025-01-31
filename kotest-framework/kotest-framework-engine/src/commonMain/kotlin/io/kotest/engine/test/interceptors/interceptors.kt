package io.kotest.engine.test.interceptors

import io.kotest.common.JVMOnly
import io.kotest.core.concurrency.CoroutineDispatcherFactory
import io.kotest.core.config.Configuration

/**
 * Returns a [TestExecutionInterceptor] for switching coroutine dispatchers.
 */
@JVMOnly
internal expect fun coroutineDispatcherFactoryInterceptor(
   defaultCoroutineDispatcherFactory: CoroutineDispatcherFactory
): TestExecutionInterceptor

/**
 * Returns a [TestExecutionInterceptor] for switching execution to a dedicated thread
 * when blockingTest is true.
 */
@JVMOnly
internal expect fun blockedThreadTimeoutInterceptor(configuration: Configuration): TestExecutionInterceptor

/**
 * Returns a [TestExecutionInterceptor] for keeping the error collector synchronized
 * with thread-switching coroutines.
 */
@JVMOnly
internal expect fun coroutineErrorCollectorInterceptor(): TestExecutionInterceptor
