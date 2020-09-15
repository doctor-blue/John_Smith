package com.example.kotlincoroutinesexample.async_await

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        /*  val time= measureTimeMillis {
              val a= launch { doSomeThingFunny1() }
              val b= launch { doSomeThingFunny2() }

              println(a + b)
          }*/
        val time = measureTimeMillis {
            val a:Deferred<Int> = async { doSomeThingFunny1() }

            val b:Deferred<Int> = async { doSomeThingFunny2() }

            println(a.await() + b.await())
        }
        println("Time = $time")
        GlobalScope
    }
}

suspend fun doSomeThingFunny1(): Int {
    delay(1000)
    return 10
}

suspend fun doSomeThingFunny2(): Int {
    delay(1000)
    return 20
}
