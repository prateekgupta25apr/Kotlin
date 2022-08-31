import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..5) {
        delay(1000) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking {
    launch(Dispatchers.IO) {
        println("On a separate coroutine")
    }
    // Collect the flow
    simple().collect { value -> println(value) }
}

