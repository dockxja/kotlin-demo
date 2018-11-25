package be.continuum

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class Coroutines {

    @Test
    fun nonBlocking() {
        // Launch new coroutine in background and continue
        GlobalScope.launch {
            // Non-blocking delay for 1 second
            delay(1000L)
            // Print after delay
            println("World!")
        }
        // Main thread continues while coroutine is delayed
        println("Hello, ")
        // Block main thread for 2 seconds to keep JVM alive
        runBlocking {
            delay(2000L)
        }
        // Same effect as
        // Thread.sleep(2000L)
    }

    @Test
    fun waitForJob() {
        runBlocking {
            val job = GlobalScope.launch {
                delay(1000L)
                println("World!")
            }
            println("Hello, ")
            job.join()
        }
    }

    @Test
    fun lightweight() = runBlocking {
        // Launch a lot of coroutines
        repeat(100_000) {
            GlobalScope.launch {
                val delayInMillis = Random.nextLong(1000, 5000)
                delay(delayInMillis)
                println("I'm sleeping $delayInMillis ms ...")
            }
        }
        runBlocking {
            delay(5000)
        }
    }

}