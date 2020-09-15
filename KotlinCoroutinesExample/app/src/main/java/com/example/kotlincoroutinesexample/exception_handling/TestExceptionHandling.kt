package com.example.kotlincoroutinesexample.exception_handling

import kotlinx.coroutines.*
import java.lang.NullPointerException

//Part 1
/*
fun main() {
    runBlocking {
        val handler= CoroutineExceptionHandler{_,exception ->
            println("Error here: ${exception.toString()}")
        }

        val job=GlobalScope.launch(handler + Dispatchers.Default) {
            println("Throw Exception from Launch")
            throw NullPointerException()
        }
        job.join()

        val deferred=GlobalScope.async(handler) {
            println("Throw Exception from Async")
            throw IndexOutOfBoundsException()
        }

        try {
            deferred.await()
        }catch (e:IndexOutOfBoundsException){
            println(e.toString())
        }

    }
}*/

//Part 2
/*
fun main() {
    runBlocking {
        val handler= CoroutineExceptionHandler{_,exception ->
            println("Exception: $exception with suppressed ${exception.suppressed.contentToString()}")
        }

        val job = GlobalScope.launch(handler) {
            launch {
                println("Coroutine 1")
                delay(300)
                println("Coroutine 1 continue")
                throw IndexOutOfBoundsException("Coroutine 1")
            }

            launch {
                try {
                    delay(Long.MAX_VALUE)
                }finally {
                    throw ArithmeticException("Coroutine 2")
                }
            }

            launch {
                println("Coroutine 3")
                delay(400)
                println("Coroutine 3 continue")
                throw ArithmeticException("Coroutine 3")
            }
        }
        job.join()
        delay(1000)
    }
}*/

//Part 3
fun main() {
    runBlocking {
      /*  val superVisorJob = SupervisorJob()
        with(CoroutineScope(coroutineContext + superVisorJob)) {
            val firstChild=launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild=launch {
                firstChild.join()
                println("print from second Child. First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)
                }finally {
                    println("Second Child Cancelled")
                }
            }
            firstChild.join()
            println("Cancelling SuperVisorJob")
            superVisorJob.cancel()
            secondChild.join()
        }*/

        supervisorScope {
            val firstChild=launch {
                println("Print from First Child")
                throw NullPointerException()
            }

            val secondChild=launch {
                firstChild.join()
                println("print from second Child. First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)
                }finally {
                    println("Second Child Cancelled")
                }
            }
            firstChild.join()
            secondChild.join()
        }
    }
}




