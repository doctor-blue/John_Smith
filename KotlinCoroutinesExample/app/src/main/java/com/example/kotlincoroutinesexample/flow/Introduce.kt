package com.example.kotlincoroutinesexample.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {

        /*val foo = foo(200)

        foo(5).collect {
            println("i = $it")
        }*/

      /*  withTimeoutOrNull(3500){
            foo(10).collect{
                println("i = $it")
            }
        }*/

      /*  (1..5).asFlow().collect{
            println(it)
        }
        */
       /* val arr= arrayOf("first","second",1,5,6,9,7)
        arr.asFlow().collect {
            println(it)
        }
        */

        val list = listOf<Int>(5,9,8,3,54,5)
        list.asFlow().collect {
            println(it)
        }


    }

}

fun foo(x:Int):Flow<Int> = flow {
    for (i in 0..x){
        delay(1000)
        emit(i)
    }
}

