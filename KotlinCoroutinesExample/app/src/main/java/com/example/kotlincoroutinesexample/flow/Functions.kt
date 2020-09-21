package com.example.kotlincoroutinesexample.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    val list = listOf<Int>(1, 8, 9, 3, 6, 7, 2)

    runBlocking {

        // transform
       /* list.asFlow().transform {
            emit(it*it)
            emit(it*it*it)
        }.collect {
            println("value = $it")
        }*/

        // map
     /*   list.asFlow().map {
            it*it
        }.collect {
            println("value = $it")
        }
*/
        // take
      /*  list.asFlow().take(3).collect {
            println("value = $it")
        }*/

        // filter
        /*list.asFlow().filter {
            it%2==0
        }.collect {
            println("value = $it")
        }*/

        //reduce
       /* val sum = list.asFlow().reduce { accumulator, value ->
            println("accumulator = $accumulator and value = $value")
            accumulator+value
        }
        println("Sum = $sum")*/

        //fold
//        val sum = list.asFlow().fold(5) { accumulator, value ->
//            println("accumulator = $accumulator and value = $value")
//            accumulator+value
//        }
//        println("Sum = $sum")

      /*  list.asFlow().filter {
            it%2==0
        }.map { it*2 }
            .take(2)
            .collect {
                println("value = $it")
            }*/


        //PART 2

        // single() and singleOrNull()
        //(1..10).asFlow().single()
        //listOf<Int>().asFlow().single()

        //val a = (1..10).asFlow().singleOrNull()





        //zip
     /*   val nums=(1..3).asFlow()
        val strs= listOf("one", "two", "three").asFlow()

        nums.zip(strs){num,str->
            "(num = $num and str = $str)"

        }.collect {
            println(it)
        }*/


        //combine
     /*   val nums=(1..3).asFlow().onEach { delay(100) }
        val strs= listOf("one", "two", "three").asFlow().onEach { delay(200) }

        var startTime = System.currentTimeMillis()
        nums.zip(strs){num,str->
            "(num = $num and str = $str)"

        }.collect {
            println("value = $it  at ${System.currentTimeMillis() - startTime}")
        }

        println("===========================")

        startTime = System.currentTimeMillis()
        nums.combine(strs){num,str->
            "(num = $num and str = $str)"

        }.collect {
            println("value = $it  at ${System.currentTimeMillis() - startTime}")
        }
*/


        //flatMapConcat()
       /* var startTime = System.currentTimeMillis()

        (1..3).asFlow().onEach { delay(100) }
            .flatMapConcat { requestFlow(it) }
            .collect {
                println("value = $it at ${System.currentTimeMillis() - startTime}")
            }*/


        // flatMapMerge()
      /*  val startTime = System.currentTimeMillis()

        (1..3).asFlow().onEach { delay(100) }
            .flatMapMerge { requestFlow(it) }
            .collect {
                println("value = $it at ${System.currentTimeMillis() - startTime}")
            }*/


        // flatMapLatest()
        val startTime = System.currentTimeMillis()

        (1..3).asFlow().onEach { delay(100) }
            .flatMapLatest { requestFlow(it) }
            .collect {
                println("value = $it at ${System.currentTimeMillis() - startTime}")
            }






    }


}

fun requestFlow(i: Int): Flow<String> = flow {
    emit("$i: First")
    delay(300) // wait 500 ms
    emit("$i: Second")
}

