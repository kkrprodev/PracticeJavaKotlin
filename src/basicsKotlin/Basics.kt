@file:JvmName("BasicsFn")
package basicsKotlin

fun main() {
    Basics().printStart()
    Basics().stringTemplates()
    println(Basics().addTwoNumbers(3, 6))
    println(Basics().multiplyTwoNumbers(6, 6))
    println(Basics().isEven(5))
    Basics().printListOfFruits()
    println(Basics().getCountry("Chennai"))
    Basics().printUpto10()
    Basics().runCollections()
    Basics().runNullableFn()
}

class Basics {

    fun printStart() {
        println("--- START ---")
    }

    fun stringTemplates() {
        val name = "Krishnakumar"
        println("My name is $name. I can use $ symbol as well.")

        val greeting = "Welcome Mr. $name to home"

        // Expression in string template
        println("${greeting.replace("home", "office")}. Have a great workplace!")
    }

    fun addTwoNumbers(a: Int, b: Int) : Int {
        return a + b
    }

    fun multiplyTwoNumbers(a: Int, b: Int) = a * b

    fun isEven(a: Int) = if (a%2==0) "Even" else "Odd"

    fun printListOfFruits() {
        val fruits = listOf("Mango", "Banana", "Jack Fruit", "Cherry")

        for (fruit in fruits) println(fruit)
        for(index in fruits.indices) println(fruits[index])

        var currentIndex = 0
        while(currentIndex < fruits.size) {
            println("Fruit at the index of $currentIndex is ${fruits[currentIndex]}")
            currentIndex++
        }
    }

    fun getCountry(city: String): String {
        val ausCities = listOf("Sydney", "Melbourne")
        return when (city) {
            "Chennai" -> "India"
            "New York" -> "USA"
            in ausCities -> "Australia"
            else -> "Earth"
        }
    }

    fun printUpto10() {
        for(i in 1..10) println(i)
        for(i in 1..10 step 2) println(i)
        for(i in 10 downTo 1 step 3) println(i)
    }

    fun runCollections() {
        val range: IntRange = 1..15
        range.toList().forEach{ println(it) }
    }

    private fun getSquare(a: String?) : Int? {
        // Returns null safely without null pointer exception
        return a?.length
    }

    private fun printFirstLetter(obj: Any): String? {
        println(obj.javaClass.name)
        if (obj is String) return obj.substring(0,1)
        return null
    }

    fun runNullableFn() {
        println(getSquare("null"))
        println(getSquare(null))
        println(printFirstLetter("Krishnakumar"))
        println(printFirstLetter(1))
    }

}