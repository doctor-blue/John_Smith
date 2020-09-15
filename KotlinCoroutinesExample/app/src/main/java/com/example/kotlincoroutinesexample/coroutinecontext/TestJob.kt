package com.example.kotlincoroutinesexample.coroutinecontext

import kotlinx.coroutines.*

/*
fun main() {
    val job: Job = GlobalScope.launch {
        delay(2000)
        println("Hello Kotlin")
    }

    val job2:Job=GlobalScope.launch {
        job.join()
        delay(1000)
        println("I'm Coroutines")
    }

    Thread.sleep(4000)


}*/
/*fun main() {
    runBlocking {
       val job= launch(Dispatchers.Default) {
            repeat(1000){
                delay(500)
                println("I'm sleeping $it ... ")
            }
        }
        delay(1500)
        job.cancel()
        println("Cancelled coroutines")
    }
}*/
/*
fun main() {
    runBlocking {
        val startTime = System.currentTimeMillis()

        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // computation loop, just wastes CPU
                // print a message twice a second
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        }

        delay(1300L) // delay a bit
        println("main: I'm tired of waiting!")
        job.cancelAndJoin() // cancels the job and waits for its completion
        println("main: Now I can quit.")
    }
}*/

/*fun main() {
    runBlocking {
        val job=launch {
           try {
               repeat(1000){
                   delay(100)
                   println("Hello Coroutine")
               }
           }finally {
               println("Print from finally")
               delay(100)
               print("Please print me last times")
           }
        }
        delay(800)
        println("I want stop coroutine")
        job.cancel()

    }
}*/
fun main() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    delay(100)
                    println("Hello Coroutine")
                }
            } finally {
                println("Print from finally")

               withContext(NonCancellable){
                   repeat(10){
                       delay(100)
                       println("Print from NonCancellable")
                   }
               }
            }
        }
        delay(2000)
        println("I want stop coroutine")
        job.cancel()
    }
}
