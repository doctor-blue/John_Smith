sealed class SearchResult {
    data class Success(val data: List<String>) : SearchResult()
    data class Error(val exception: Exception) : SearchResult()

    //    abstract fun sayHello()
//    object SomeOne:SearchResult(){
//
//    }
    class Loading(val message: String) : SearchResult()

}

fun checkResultStatus(result: SearchResult){
    when(result){
        is SearchResult.Success ->{
            println("Success!")
        }
        is SearchResult.Error->{
            println("Error!")
        }
        is SearchResult.Loading->{
            println("Loading... ")
        }
    }
}
