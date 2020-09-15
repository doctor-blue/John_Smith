package com.example.kotlincoroutinesexample.coroutinecontext

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        /*  withTimeout(1800L){
              repeat(1000){
                  println("I'm sleeping $it")
                  delay(500L)
              }
          }*/
        val result = withTimeoutOrNull(1800L) {
            repeat(2) {
                println("I'm sleeping $it")
                delay(500L)
            }
            "Done"
        }
        println("Result = $result")

    }
}