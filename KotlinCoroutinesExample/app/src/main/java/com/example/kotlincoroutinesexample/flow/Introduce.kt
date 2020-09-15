package com.example.kotlincoroutinesexample.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        val foo = foo(200)

        foo(5).collect {
            println("i = $it")
        }

    }

}

fun foo(x:Int):Flow<Int> = flow {
    for (i in 0..x){
        delay(1000)
        emit(i)
    }
}