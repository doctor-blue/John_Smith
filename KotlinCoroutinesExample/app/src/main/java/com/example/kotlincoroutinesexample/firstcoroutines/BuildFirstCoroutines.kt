package com.example.kotlincoroutinesexample.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Hello ")
    }

    println("World ")
    Thread.sleep(2000L)

}*/
/*fun main() {

    runBlocking {
        delay(1000)
        print("Hello ")
        delay(1000)
        print("Coroutines ")
    }

}*/
fun main() {
    val start=System.currentTimeMillis()
    runBlocking {
        repeat(1_000_000){
            launch {
                println("Hello Coroutines !")
            }
        }
    }

    val end=System.currentTimeMillis()
    println("Time = ${end-start}ms")
}