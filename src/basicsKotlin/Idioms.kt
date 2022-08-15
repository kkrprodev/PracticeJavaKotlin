package basicsKotlin

import basicsKotlin.dataClass.Customer
import java.util.stream.IntStream

fun main() {

    Idioms().runDataClassFn()
}

class Idioms {

    fun runDataClassFn() {
        val customer = Customer("Lucas TVS", "Padi")
        println(customer.name)
        println(customer.location)
        customer.location = "Chennai"
        println(customer.location)

        val list: MutableList<Int> = IntStream.range(1, 50).boxed().toList()

        // default and named parameters
        val filterMultiples = filterMultiples(3, list = list)
        println(filterMultiples)

        // Traversing map
        val simpleMap = mapOf<String, String>("G" to "Google", "F" to "Facebook")
        for((k,v) in simpleMap) {
            println("$k is $v")
        }

        // Iterate over a range
        for (i in 1..10) println(i)
        for (i in 11 until 20) println(i)
        for (i in 21..30 step 2) println(i)
        for (i in 40 downTo 31) println(i)

        // Extension function
        var log = "Object created in database"
        log.printToFile()

        // Singleton
        println(statusBuffer.name)
    }
    private fun filterMultiples(factor: Int = 1, list: List<Int>): List<Int> {
        // filter list
        return list.filter { it % factor == 0 }
    }

    private fun String.printToFile() {
        // file writing mechanism
        println("File writing completed")
    }

    object statusBuffer {
        val name = "Krishnakumar"
    }

}